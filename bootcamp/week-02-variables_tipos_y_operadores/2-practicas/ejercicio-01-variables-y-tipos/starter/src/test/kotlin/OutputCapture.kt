import java.io.ByteArrayOutputStream
import java.io.PrintStream

// ¿Qué? Ejecuta main() y devuelve, línea a línea, lo que imprimió.
// ¿Para qué? Los tests de esta semana comprueban la salida del programa.
// ¿Impacto? Si main() se detiene en un TODO("Paso N"), se devuelve lo impreso hasta
//           ese punto: los pasos ya resueltos pasan aunque falten los siguientes.
fun captureMain(): List<String> {
    val original = System.out
    val buffer = ByteArrayOutputStream()
    System.setOut(PrintStream(buffer, true, Charsets.UTF_8))
    try {
        main()
    } catch (_: NotImplementedError) {
    } finally {
        System.setOut(original)
    }
    return buffer.toString(Charsets.UTF_8).lines()
}
