import kotlin.test.Test
import kotlin.test.assertEquals

class MainTest {
    private val lines = captureMain()

    @Test
    fun paso1JoinsThreePrintsInOneLine() {
        assertEquals("Kotlin + JVM", lines.getOrNull(0))
    }

    @Test
    fun paso2UsesEscapeSequences() {
        assertEquals(
            listOf("Columna\tColumna", "Ella dijo: \"hola\"", "Ruta: C:\\bootcamp", "Precio: \$10"),
            lines.drop(1).take(4),
        )
    }

    @Test
    fun paso3SplitsOneStringInTwoLines() {
        assertEquals(listOf("Primera línea", "Segunda línea"), lines.drop(5).take(2))
    }

    @Test
    fun paso4PrintsABoxWithoutIndentation() {
        assertEquals(listOf("+----------+", "|  Kotlin  |", "+----------+"), lines.drop(7).take(3))
    }

    @Test
    fun paso5PrintsUnicode() {
        assertEquals(listOf("Año 2026: ñ, á, ü, → y ✓", "¡Hola!"), lines.drop(10).take(2))
    }
}
