import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class MainTest {
    private val lines = captureMain().dropLastWhile { it.isEmpty() }

    private fun valueAfter(label: String, index: Int): String {
        val line = lines.getOrNull(index) ?: ""
        assertTrue(line.startsWith(label), "La línea ${index + 1} debe empezar por \"$label\" y es \"$line\"")
        return line.removePrefix(label)
    }

    @Test
    fun titleIsFramed() {
        val title = lines.getOrNull(0) ?: ""
        assertTrue(Regex("^=== \\S.*\\S ===$").matches(title), "Título enmarcado esperado: \"$title\"")
    }

    @Test
    fun blankLinesSeparateTheBlocks() {
        assertEquals("", lines.getOrNull(1))
        assertEquals("", lines.getOrNull(6))
    }

    @Test
    fun describesTheSystem() {
        assertTrue(valueAfter("Sistema: ", 2).length >= 10, "Describe el sistema en una frase")
    }

    @Test
    fun namesTheMainResource() {
        assertTrue(valueAfter("Recurso principal: ", 3).isNotBlank())
    }

    @Test
    fun namesTheLearner() {
        assertTrue(valueAfter("Aprendiz: ", 4).isNotBlank())
    }

    @Test
    fun hasTheWeekVersion() {
        assertEquals("Versión: 0.2.0", lines.getOrNull(5))
    }

    @Test
    fun closesWithTheToolchain() {
        assertEquals("Compilado con Kotlin 2.4.21 sobre JDK 25", lines.getOrNull(7))
    }

    @Test
    fun everyLineFitsInSixtyColumns() {
        lines.forEachIndexed { i, line -> assertTrue(line.length <= 60, "La línea ${i + 1} pasa de 60 columnas") }
    }
}
