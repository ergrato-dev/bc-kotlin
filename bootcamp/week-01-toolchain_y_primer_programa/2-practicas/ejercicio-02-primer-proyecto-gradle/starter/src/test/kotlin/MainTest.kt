import kotlin.test.Test
import kotlin.test.assertEquals

class MainTest {
    private val lines = captureMain()

    @Test
    fun paso2PrintsTheTitle() {
        assertEquals("Bootcamp Kotlin — Semana 01", lines.getOrNull(0))
    }

    @Test
    fun paso3PrintsTheToolList() {
        assertEquals(listOf("", "Herramientas:", "- JDK 25", "- Kotlin 2.4.21", "- Gradle 9.8.2"), lines.drop(1).take(5))
    }

    @Test
    fun paso4PrintsTheClosingLine() {
        assertEquals("Listo para la semana 02.", lines.getOrNull(6))
    }
}
