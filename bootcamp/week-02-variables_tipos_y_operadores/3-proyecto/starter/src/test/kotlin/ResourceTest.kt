import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlin.test.fail

class ResourceTest {
    private val lines = captureMain().dropLastWhile { it.isEmpty() }
    private val amount = Regex("^\\d+\\.\\d{2}$")
    private val taxLine = Regex("^Impuesto \\((\\d{1,3}) %\\): (\\d+\\.\\d{2})$")

    private fun valueAfter(label: String, index: Int): String {
        val line = lines.getOrNull(index) ?: ""
        assertTrue(line.startsWith(label), "La línea ${index + 1} debe empezar por \"$label\" y es \"$line\"")
        return line.removePrefix(label)
    }

    private fun toCents(text: String, index: Int): Long {
        assertTrue(amount.matches(text), "La línea ${index + 1} debe terminar en un importe como 45.38 y termina en \"$text\"")
        return text.replace(".", "").toLong()
    }

    private fun quantity(): Long =
        valueAfter("Cantidad: ", 12).toLongOrNull() ?: fail("La línea 13 debe terminar en un número entero")

    private fun unitCents() = toCents(valueAfter("Importe unitario: ", 13), 13)

    private fun subtotalCents() = toCents(valueAfter("Subtotal: ", 15), 15)

    private fun tax(): Pair<Int, Long> {
        val line = lines.getOrNull(16) ?: ""
        val match = taxLine.matchEntire(line) ?: fail("La línea 17 debe ser \"Impuesto (<n> %): <importe>\" y es \"$line\"")
        return match.groupValues[1].toInt() to toCents(match.groupValues[2], 16)
    }

    private fun totalCents() = toCents(valueAfter("Total: ", 17), 17)

    @Test
    fun separatesTheResourceBlock() {
        assertEquals("", lines.getOrNull(8))
        assertEquals("--- Ficha del recurso ---", lines.getOrNull(9))
    }

    @Test
    fun namesTheResource() {
        assertTrue(valueAfter("Nombre: ", 10).isNotBlank(), "El recurso necesita un nombre")
    }

    @Test
    fun hasAWellFormedCode() {
        val code = valueAfter("Código: ", 11)
        assertTrue(Regex("^[A-Z]{3}-\\d{4}$").matches(code), "Código con forma AAA-0000 esperado: \"$code\"")
    }

    @Test
    fun hasAPositiveQuantity() {
        assertTrue(quantity() >= 1, "La cantidad debe ser 1 o más")
    }

    @Test
    fun showsAPositiveUnitAmount() {
        assertTrue(unitCents() > 0, "El importe unitario debe ser mayor que 0.00")
    }

    @Test
    fun blankLineBeforeTheTotals() {
        assertEquals("", lines.getOrNull(14))
    }

    @Test
    fun subtotalIsQuantityTimesUnitAmount() {
        assertEquals(quantity() * unitCents(), subtotalCents(), "Subtotal = cantidad × importe unitario (en centavos)")
    }

    @Test
    fun taxIsRoundedHalfUp() {
        val (rate, taxCents) = tax()
        assertEquals((subtotalCents() * rate + 50) / 100, taxCents, "Impuesto = subtotal × $rate / 100, redondeando la mitad hacia arriba")
    }

    @Test
    fun totalAddsSubtotalAndTax() {
        assertEquals(subtotalCents() + tax().second, totalCents(), "Total = subtotal + impuesto")
    }

    @Test
    fun flagsTotalsThatNeedApproval() {
        assertEquals("Requiere aprobación: ${totalCents() >= 10_000}", lines.getOrNull(18), "true si el total es 100.00 o más")
    }

    @Test
    fun hasNoExtraLines() {
        assertEquals(19, lines.size, "El programa imprime exactamente 19 líneas")
    }
}
