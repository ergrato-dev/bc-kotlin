# Teoría 05 — Strings y templates

## 🎯 Objetivos

- Insertar variables y expresiones en un texto con `$nombre` y `${expresión}`.
- Usar las propiedades y funciones básicas de `String`: `length`, `uppercase()`,
  `lowercase()`, `trim()`, `repeat()`, `padStart()` y `padEnd()`.
- Explicar por qué un string no cambia cuando llamas a sus funciones.
- Alinear columnas de texto.
- Usar plantillas dentro de raw strings y escribir un `$` literal en ellos.

---

## 1. Qué problema resuelven las plantillas

Para construir `Total: 45.38 (3 unidades)` con `+` necesitas cuatro trozos, comillas por
todas partes y espacios que se olvidan:

```kotlin
println("Total: " + total + " (" + units + " unidades)")
```

Con una **plantilla de string** (*string template*), el texto se escribe tal como se va
a ver y los datos se insertan en su sitio:

```kotlin
println("Total: $total ($units unidades)")
```

Mismo resultado, se lee de un vistazo y es imposible olvidar un espacio entre trozos.

## 2. Cómo funciona

### 2.1 `$nombre` y `${expresión}`

| Forma | Qué inserta | Ejemplo |
| ----- | ----------- | ------- |
| `$nombre` | El valor de una variable | `"Hola, $name!"` |
| `${expresión}` | El resultado de cualquier expresión | `"Letras: ${name.length}"` |

```kotlin
fun main() {
    val name = "Ada"
    println("Hola, $name!")
    println("Letras: ${name.length}")
    println("Letras: $name.length")
}
```

```
Hola, Ada!
Letras: 3
Letras: Ada.length
```

La tercera línea es el error típico: `$name` termina donde termina el nombre, así que se
inserta `Ada` y `.length` queda como texto normal. En cuanto haya un punto, un operador o
una llamada, usa llaves: `${name.length}`, `${units * 2}`.

Si el nombre después de `$` no existe, no compila. Añade `println("$nameX")` como
línea 6, creyendo que imprimirá `Ada` seguido de `X`:

```
E9.kt:6:15: error: unresolved reference 'nameX'.
```

`$` toma como nombre todas las letras y dígitos seguidos: busca una variable `nameX`. Si
quieres `AdaX`, escribe `"${name}X"`.

### 2.2 Propiedades y funciones de `String`

Una **propiedad** es un dato que un valor lleva consigo; se lee con un punto y sin
paréntesis: `name.length`. Una **función** de un valor hace algo con él; se llama con
punto y paréntesis: `name.uppercase()`.

| Expresión | Resultado | Qué hace |
| --------- | --------- | -------- |
| `"Kotlin".length` | `6` | Número de caracteres |
| `"Kotlin".uppercase()` | `"KOTLIN"` | Todo en mayúsculas |
| `"Kotlin".lowercase()` | `"kotlin"` | Todo en minúsculas |
| `"  hola  ".trim()` | `"hola"` | Quita los espacios del principio y del final |
| `"=".repeat(5)` | `"====="` | Repite el texto 5 veces |
| `"7".padStart(3, '0')` | `"007"` | Rellena por la izquierda hasta 3 caracteres |
| `"Pan".padEnd(6)` | `"Pan   "` | Rellena por la derecha con espacios hasta 6 |
| `"Kotlin"[0]` | `'K'` | El carácter en la posición 0 (la primera) |

Las posiciones empiezan en **0**: en `"Kotlin"`, la `K` es la posición 0 y la `n` la 5.

Si el texto ya es igual o más largo que lo pedido, `padStart` y `padEnd` no lo tocan:
`"Kotlin".padEnd(3)` sigue siendo `"Kotlin"`.

### 2.3 Los strings no cambian

```kotlin
fun main() {
    val name = "Ada"
    val loud = name.uppercase()
    println(name)
    println(loud)
}
```

```
Ada
ADA
```

`uppercase()` **devuelve un string nuevo**; `name` sigue valiendo `"Ada"`. Los strings
de Kotlin son **inmutables**: una vez creados, no cambian. Si quieres conservar el
resultado, guárdalo en una variable.

## 3. Cómo se escribe

### 3.1 Columnas alineadas

`padEnd` y `padStart` dan a cada dato un ancho fijo. Con ancho fijo, las columnas
quedan alineadas aunque los datos tengan distinta longitud:

```kotlin
fun main() {
    println("Producto".padEnd(10) + "Precio".padStart(8))
    println("Café".padEnd(10) + "3.00".padStart(8))
    println("Pan integral".padEnd(10) + "12.50".padStart(8))
}
```

```
Producto    Precio
Café          3.00
Pan integral   12.50
```

Las dos primeras filas quedan alineadas; la tercera no, porque `"Pan integral"` tiene 12
caracteres y `padEnd(10)` no recorta. El ancho de la columna tiene que ser al menos el
del dato más largo. Fíjate también en el criterio: **textos a la izquierda** (`padEnd`) y
**números a la derecha** (`padStart`), para que las cifras queden una debajo de otra.

### 3.2 Plantillas dentro de raw strings

Los raw strings `"""..."""` de la semana 01 también admiten plantillas:

```kotlin
fun main() {
    val name = "Ada"
    val units = 3
    println(
        """
        Aprendiz: $name
        Unidades: ${units * 2}
        """.trimIndent()
    )
}
```

```
Aprendiz: Ada
Unidades: 6
```

### 3.3 Un `$` literal

En un string normal, `\$` escribe un `$` (semana 01). En un raw string no hay escapes,
así que `\$` no sirve. La forma es insertar el carácter `$` con una plantilla:
`${'$'}`.

```kotlin
fun main() {
    val price = """Total: ${'$'}10"""
    println(price)
}
```

Sale `Total: $10`. Es la respuesta al reto del Ejercicio 03 de la semana 01.

## 4. Antipatrones

- ❌ **Concatenar con `+` lo que cabe en una plantilla.** Más comillas, más errores de
  espacios.
- ❌ **`$name.length` esperando el número.** Sin llaves, solo se inserta `name`.
- ❌ **Llamar a `uppercase()` y no guardar el resultado.** El original no cambia.
- ❌ **Expresiones largas dentro de `${}`.** Si la cuenta no se lee de un vistazo,
  calcúlala antes en un `val` con nombre y usa `$nombre`.

## 5. Trucos

- Una línea separadora del mismo ancho que un título: `"=".repeat(title.length)`.
- Para mostrar un `Double` con un número fijo de decimales:
  `"%.2f".format(3.14159)` da `3.14`. Usa la configuración regional del sistema; en el
  contenedor del bootcamp el separador es el punto. Para importes, sigue con centavos
  (Teoría 04).

## ✅ Checklist

- [ ] Uso `$nombre` y `${expresión}` y sé cuándo hacen falta las llaves
- [ ] Uso `length`, `uppercase()`, `lowercase()`, `trim()`, `repeat()`, `padStart()` y
  `padEnd()`
- [ ] Sé que los strings son inmutables y guardo los resultados
- [ ] Alineo columnas: textos con `padEnd`, números con `padStart`
- [ ] Escribo plantillas y `${'$'}` dentro de raw strings

---

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [← Teoría 04 — Conversiones y dinero](04-conversiones-y-dinero.md) | **Teoría 05 — Strings y templates** | [Teoría 06 — Comparaciones y lógica →](06-comparaciones-y-logica.md) |
