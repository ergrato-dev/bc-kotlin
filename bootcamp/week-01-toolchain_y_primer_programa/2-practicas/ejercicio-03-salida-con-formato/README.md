# Ejercicio 03 — Salida con formato

> Al terminar controlarás exactamente qué imprime un programa: dónde salta de línea, cómo
> se escriben comillas, barras y tabuladores, cómo se imprime un bloque de texto y cómo
> salen las tildes y los símbolos.

**Duración estimada**: 2 h
**Prerrequisitos**: [Ejercicio 02](../ejercicio-02-primer-proyecto-gradle/README.md)
terminado; [Teoría 04](../../1-teoria/04-anatomia-de-un-programa.md), sección 3, leída.

## Contexto

Cada test de este ejercicio compara una línea de salida **carácter a carácter**. Un
espacio de más, un salto de línea que falta o una comilla sin escapar lo ponen en rojo.
Es un buen entrenamiento: en las próximas semanas, la salida de tus programas la
comprueban tests igual de estrictos.

El starter trae cinco pasos en `src/main/kotlin/Main.kt` y cinco tests.

## Paso 0: Entrar y ver el rojo

```bash
cd bootcamp/week-01-toolchain_y_primer_programa/2-practicas/ejercicio-03-salida-con-formato/starter
docker run --rm -it -v bc-kotlin-gradle:/home/ubuntu/.gradle -v "$PWD":/workspace bc-kotlin-dev
./gradlew test
```

**Verifica**: `5 tests completed, 5 failed`.

## Paso 1: `print` frente a `println`

**Por qué**: `print` deja el cursor en la misma línea; `println` salta. Tres llamadas
pueden producir **una sola** línea.

```kotlin
print("Kotlin")
print(" + ")
println("JVM")
```

Fíjate en los espacios: están dentro de `" + "`, no entre las llamadas.

**Abre `src/main/kotlin/Main.kt`** y resuelve el Paso 1 (borra `TODO("Paso 1")` y quita
`//> `).

**Verifica**: `./gradlew test` → `paso1JoinsThreePrintsInOneLine() PASSED`. Con
`./gradlew -q run` la primera línea es `Kotlin + JVM`, y después aparece el error del
`TODO("Paso 2")`: es lo esperado.

## Paso 2: Secuencias de escape

**Por qué**: algunos caracteres no se pueden escribir tal cual dentro de un string: la
comilla lo cerraría, la barra invertida anuncia un escape y `$` tiene un significado que
verás en la semana 02.

```kotlin
println("Columna\tColumna")
println("Ella dijo: \"hola\"")
println("Ruta: C:\\bootcamp")
println("Precio: \$10")
```

| Línea | Escape | Sale |
| ----- | ------ | ---- |
| 1 | `\t` | Un tabulador entre las dos palabras |
| 2 | `\"` | Comillas dentro del texto |
| 3 | `\\` | Una sola barra invertida |
| 4 | `\$` | Un signo de dólar |

Resuelve el Paso 2.

**Verifica**: `paso2UsesEscapeSequences() PASSED`. Con `./gradlew -q run`:

```
Kotlin + JVM
Columna	Columna
Ella dijo: "hola"
Ruta: C:\bootcamp
Precio: $10
```

Prueba a quitar la barra de `\"hola\"` (deja `"hola"`) y ejecuta `./gradlew test`. El
compilador falla antes de llegar a los tests: la comilla de `"hola` cierra el string y
`hola` queda suelto en el código. Lee el primer error, `unresolved reference 'hola'`,
con su línea y columna, y restaura las barras.

## Paso 3: Un salto de línea dentro del string

**Por qué**: `\n` parte un solo string en dos líneas de salida. Es lo que hace `println`
al final, pero en medio.

```kotlin
println("Primera línea\nSegunda línea")
```

Resuelve el Paso 3.

**Verifica**: `paso3SplitsOneStringInTwoLines() PASSED`. Una llamada, dos líneas.

## Paso 4: Un raw string con `trimIndent`

**Por qué**: para un bloque de varias líneas, un raw string `"""..."""` se escribe tal
como se ve. `trimIndent()` quita la sangría que pones para que el código se lea bien.

```kotlin
println(
    """
    +----------+
    |  Kotlin  |
    +----------+
    """.trimIndent()
)
```

Resuelve el Paso 4.

**Verifica**: `paso4PrintsABoxWithoutIndentation() PASSED`.

Ahora borra `.trimIndent()` (deja `"""` solo) y ejecuta `./gradlew -q run`. Verás una
línea vacía antes de la caja, la caja desplazada a la derecha y otra línea con espacios
después. Ejecuta `./gradlew test`: el Paso 4 falla y el Paso 5 también, porque todas las
líneas siguientes se han desplazado. Restaura `.trimIndent()`.

## Paso 5: Unicode

**Por qué**: Kotlin guarda el texto en Unicode. Las tildes, la ñ y los símbolos se
escriben directamente; `\u` sirve para los que no puedes teclear.

```kotlin
println("Año 2026: ñ, á, ü, → y ✓")
println("\u00A1Hola!")
```

`00A1` es el código Unicode de `¡`, en hexadecimal (base 16: dígitos del 0 al 9 y de la
A a la F).

Resuelve el Paso 5.

**Verifica**: `./gradlew test` → `BUILD SUCCESSFUL`, 5 de 5. La última línea de
`./gradlew -q run` es `¡Hola!`.

## Criterios de éxito

- [ ] `./gradlew test`: 5 de 5 tests en verde
- [ ] Sabes qué escape necesita cada uno de `"`, `\`, `$`, tabulador y salto de línea
- [ ] Viste qué pasa sin `trimIndent()` y por qué afecta a las líneas siguientes

## Reto extra

Imprime, con **un solo** `println` y un raw string, este recibo (respeta los espacios):

```
Producto      Precio
Café          $3
Pan           $1
Total:        $subtotal
```

Escríbelo, compila con `./gradlew -q run` y lee el error de la última línea:
`unresolved reference 'subtotal'`. Dentro de un raw string, `$` seguido de un nombre es
especial (lo verás en la semana 02) y `\$` no funciona, porque en un raw string `\` no es
un escape. Busca en la
[documentación de strings](https://kotlinlang.org/docs/strings.html#multiline-strings)
cómo se escribe un `$` literal dentro de `"""` y arréglalo. No hay test para el reto.

---

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [← Ejercicio 02 — Tu primer proyecto Gradle](../ejercicio-02-primer-proyecto-gradle/README.md) | **Ejercicio 03 — Salida con formato** | [Proyecto — Ficha del sistema →](../../3-proyecto/README.md) |
