import kotlin.test.Test
import kotlin.test.assertEquals

class MainTest {
    private val lines = captureMain()

    @Test
    fun paso1PrintsValuesWithATemplate() {
        assertEquals("Kotlin 1.0 salió en 2016", lines.getOrNull(0))
    }

    @Test
    fun paso2ReassignsAVar() {
        assertEquals(listOf("Stock inicial: 10", "Stock tras la venta: 7"), lines.drop(1).take(2))
    }

    @Test
    fun paso3PrintsOneValueOfEachType() {
        assertEquals("3 | 1250 | 4.5 | true | K", lines.getOrNull(3))
    }

    @Test
    fun paso4ShowsIntLimitAndInferredLong() {
        assertEquals(
            listOf("Máximo Int: 2147483647", "Población mundial: 8100000000"),
            lines.drop(4).take(2),
        )
    }

    @Test
    fun paso5KeepsLeadingZerosInStrings() {
        assertEquals(listOf("Código: LIB-0042", "Teléfono: 0341234567"), lines.drop(6).take(2))
    }
}
