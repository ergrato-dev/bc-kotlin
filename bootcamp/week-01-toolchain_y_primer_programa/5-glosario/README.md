# 📖 Glosario — Semana 01

| Término | Definición | Ejemplo |
| ------- | ---------- | ------- |
| Aserción (*assertion*) | Afirmación que un test comprueba; si es falsa, el test falla | `assertEquals("Hola", lines.getOrNull(0))` |
| Biblioteca estándar (*standard library*) | Código que trae Kotlin ya escrito y listo para usar | `println`, `trimIndent()` |
| Bytecode | Instrucciones para la JVM, iguales en todos los sistemas | El contenido de `HelloKt.class` |
| Classpath | Lista de lugares donde la JVM busca bytecode | `java -cp .:kotlin-stdlib.jar HelloKt` |
| Compilador (*compiler*) | Programa que traduce código fuente a una forma ejecutable | `kotlinc Hello.kt` |
| Contenedor (*container*) | Imagen de Docker en ejecución, aislada de tu máquina | `docker run --rm -it bc-kotlin-dev` |
| Dependencia (*dependency*) | Biblioteca que un proyecto necesita y Gradle descarga | `testImplementation(kotlin("test"))` |
| Error de compilación | El código no sigue las reglas del lenguaje; no se genera nada | `error: unresolved reference 'printn'.` |
| Excepción (*exception*) | Error que detiene un programa mientras se ejecuta | `ArithmeticException: / by zero` |
| Función (*function*) | Bloque de instrucciones con nombre | `fun main() { ... }` |
| Herramienta de build (*build tool*) | Automatiza compilar, probar y empaquetar un proyecto | Gradle |
| Imagen (*image*) | Sistema de archivos preparado y congelado a partir de un Dockerfile | `bc-kotlin-dev` |
| JAR (*Java ARchive*) | Archivo que agrupa muchos `.class` | `hello.jar` |
| JDK (*Java Development Kit*) | La JVM más las herramientas de desarrollo | OpenJDK 25 |
| JVM (*Java Virtual Machine*) | Programa que ejecuta bytecode | `java -jar hello.jar` |
| Raw string | String entre `"""` sin escapes, que puede ocupar varias líneas | `"""a\nb"""` imprime `a\nb` |
| Secuencia de escape (*escape sequence*) | `\` + carácter que representa algo especial dentro de un string | `\n`, `\t`, `\"` |
| String | Texto entre comillas | `"Hola, Kotlin"` |
| Tarea (*task*) | Unidad de trabajo de Gradle | `./gradlew test` |
| Test automático | Programa que ejecuta el tuyo y comprueba el resultado | `MainTest.kt` |
| Volumen (*volume*) | Almacenamiento de Docker que sobrevive al contenedor | `-v bc-kotlin-gradle:/home/ubuntu/.gradle` |
| Warning | Aviso del compilador: compila, pero algo huele mal | `warning: division by zero.` |
| Wrapper | Script que descarga y ejecuta la versión exacta de Gradle del proyecto | `./gradlew` |

---

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [← Webgrafía](../4-recursos/webgrafia/README.md) | **Glosario** | [Índice del bootcamp →](../../README.md) |
