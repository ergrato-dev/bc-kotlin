import kotlin.test.Test
import kotlin.test.assertEquals

class MainTest {
    private val lines = captureMain()

    @Test
    fun paso1UsesExpressionsInTemplates() {
        assertEquals(listOf("Nombre: ADA LOVELACE", "Letras: 12"), lines.take(2))
    }

    @Test
    fun paso2UnderlinesTheTitle() {
        assertEquals(listOf("Inventario", "=========="), lines.drop(2).take(2))
    }

    @Test
    fun paso3AlignsColumns() {
        assertEquals(
            listOf("Producto      Unidades", "Café                 3", "Pan                 12"),
            lines.drop(4).take(3),
        )
    }

    @Test
    fun paso4FormatsCentsWithTwoDecimals() {
        assertEquals("Total: 45.05", lines.getOrNull(7))
    }

    @Test
    fun paso5EvaluatesConditions() {
        assertEquals(
            listOf("Cubre el pedido: false", "Se puede vender: false", "Mismo nombre: true"),
            lines.drop(8).take(3),
        )
    }
}
