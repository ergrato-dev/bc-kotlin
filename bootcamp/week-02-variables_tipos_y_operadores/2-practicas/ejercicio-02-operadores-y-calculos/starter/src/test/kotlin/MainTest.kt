import kotlin.test.Test
import kotlin.test.assertEquals

class MainTest {
    private val lines = captureMain()

    @Test
    fun paso1SplitsMinutesIntoHours() {
        assertEquals("135 min = 2 h 15 min", lines.getOrNull(0))
    }

    @Test
    fun paso2ComparesIntegerAndRealDivision() {
        assertEquals(listOf("Media entera: 3", "Media real: 3.4"), lines.drop(1).take(2))
    }

    @Test
    fun paso3AppliesPrecedence() {
        assertEquals(listOf("Sin paréntesis: 35", "Con paréntesis: 75"), lines.drop(3).take(2))
    }

    @Test
    fun paso4UpdatesTheStock() {
        assertEquals("Stock final: 13", lines.getOrNull(5))
    }

    @Test
    fun paso5ComputesTheTotalInCents() {
        assertEquals(listOf("Subtotal: 3750", "Impuesto: 788", "Total: 4538"), lines.drop(6).take(3))
    }
}
