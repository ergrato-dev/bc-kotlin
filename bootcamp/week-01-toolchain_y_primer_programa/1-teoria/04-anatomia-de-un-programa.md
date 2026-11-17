# Teoría 04 — Anatomía de un programa

## 🎯 Objetivos

- Reconocer cada pieza de un programa Kotlin mínimo y el orden en que se ejecuta.
- Imprimir texto con `println` y `print`, con secuencias de escape y con raw strings.
- Escribir comentarios útiles.
- Distinguir un error de compilación de un error de ejecución y leer ambos mensajes.

---

## 1. Qué problema resuelve conocer la anatomía

Esta semana tus programas solo imprimen texto. Parece poco, pero ya tienen todas las
piezas de cualquier programa: un punto de entrada, instrucciones en orden y valores. Si
las reconoces ahora, el resto del bootcamp es añadir piezas nuevas a una estructura que
ya entiendes.

## 2. Cómo funciona: el programa mínimo

```kotlin
fun main() {
    println("Bootcamp Kotlin")
}
```

| Pieza | Nombre | Qué hace |
| ----- | ------ | -------- |
| `fun` | Palabra reservada (*keyword*) | Declara una **función**: un bloque de instrucciones con nombre |
| `main` | Nombre de la función | La JVM empieza a ejecutar por aquí. Se escribe exactamente así, en minúsculas |
| `()` | Lista de parámetros | Vacía: `main` no recibe datos. Los parámetros llegan en la semana 03 |
| `{ ... }` | Cuerpo | Las instrucciones de la función |
| `println("...")` | Llamada a función | Ejecuta la función `println` de la biblioteca estándar con ese texto |
| `"Bootcamp Kotlin"` | String literal | Un texto escrito tal cual en el código |

Una **palabra reservada** es una palabra que el lenguaje usa para sí mismo; no puedes
usarla como nombre. Una **llamada a función** (*function call*) es pedir que se ejecute
una función: su nombre seguido de paréntesis, y dentro, los datos que necesita.

**Orden de ejecución**: las instrucciones del cuerpo se ejecutan una detrás de otra, de
arriba abajo. Cuando se acaba el cuerpo de `main`, el programa termina.

**Sangría** (*indentation*): los 4 espacios delante de `println` no son obligatorios
para el compilador, pero sí para las personas: muestran qué está dentro de qué. El estilo
oficial de Kotlin usa 4 espacios.

## 3. Cómo se escribe en Kotlin

### 3.1 `println` y `print`

`println` imprime y salta de línea (*print line*). `print` imprime y **no** salta.

```kotlin
fun main() {
    print("sin salto")
    print(" y sigue")
    println()
    println("Hola")
}
```

```
sin salto y sigue
Hola
```

`println()` sin nada imprime solo el salto de línea: así haces una línea vacía.

### 3.2 Secuencias de escape

Dentro de un string, la barra invertida `\` anuncia un carácter especial. A la pareja
`\` + letra se le llama **secuencia de escape** (*escape sequence*).

| Escribes | Obtienes |
| -------- | -------- |
| `\n` | Salto de línea (*newline*) |
| `\t` | Tabulador: salta a la siguiente columna de tabulación |
| `\"` | Una comilla doble, sin cerrar el string |
| `\\` | Una barra invertida |
| `\$` | Un signo `$` (en la semana 02 verás por qué `$` es especial) |
| `\u00A1` | El carácter Unicode con ese código: `¡` |

```kotlin
fun main() {
    println("Ella dijo: \"hola\"")
    println("Ruta: C:\\bootcamp")
    println("Primera línea\nSegunda línea")
}
```

```
Ella dijo: "hola"
Ruta: C:\bootcamp
Primera línea
Segunda línea
```

**Unicode** es el estándar que asigna un número a cada carácter de cualquier idioma
(tildes, ñ, emojis, flechas). Kotlin guarda los textos en Unicode: puedes escribir `ñ` o
`→` directamente; `\u` es para los que no puedes teclear.

### 3.3 Raw strings

Un **raw string** (texto en crudo) va entre tres comillas `"""`. Dentro, `\n` es una
barra y una ene, no un salto: lo que escribes es lo que sale, saltos de línea incluidos.

```kotlin
fun main() {
    println(
        """
        +----------+
        |  Kotlin  |
        +----------+
        """.trimIndent()
    )
}
```

```
+----------+
|  Kotlin  |
+----------+
```

`.trimIndent()` se escribe pegado al string con un punto: es una función que **pertenece
al string** y devuelve una copia sin la sangría común ni las líneas vacías del principio
y del final. Sin ella, saldrían los espacios de la izquierda y una línea en blanco arriba
y abajo. El punto para llamar funciones de un valor lo usas todo el bootcamp; en la
semana 02 lo verás con más detalle.

### 3.4 Comentarios

```kotlin
// Comentario de una línea: desde // hasta el final.

/* Comentario de bloque:
   puede ocupar varias líneas. */
```

El compilador ignora los comentarios. Un buen comentario explica **por qué**, no repite
**qué**: el código ya dice qué hace.

```kotlin
// ❌ Imprime "Hola".
println("Hola")

// ✅ La primera línea es el título: los tests la comparan exacta.
println("Bootcamp Kotlin — Semana 01")
```

## 4. Dos tipos de error

### 4.1 Error de compilación

El código no sigue las reglas del lenguaje. `kotlinc` no genera nada y explica por qué.

```kotlin
fun main() {
    printn("Hola, Kotlin")
}
```

```
Hello.kt:2:5: error: unresolved reference 'printn'.
    printn("Hola, Kotlin")
    ^^^^^^
```

Cómo se lee: `Hello.kt` (archivo) `:2` (línea) `:5` (columna) `error:` y la descripción.
Debajo, la línea con el problema y `^` señalando el sitio exacto. *Unresolved reference*:
"no conozco nada con ese nombre". Es una errata: `printn` en vez de `println`.

Otro frecuente, una comilla sin cerrar:

```
Hello.kt:2:27: error: syntax error: Expecting '"'.
    println("Hola, Kotlin)
                          ^
```

*Syntax error: Expecting `"`*: "esperaba una comilla aquí". Cuando falta algo, el
compilador señala dónde se dio cuenta, que puede ser **después** del sitio real. Y un
error puede producir otros en cadena: arregla siempre **el primero** y vuelve a compilar.

### 4.2 Error de ejecución

El código compila, pero al ejecutarse ocurre algo imposible. La JVM detiene el programa
y lanza una **excepción** (*exception*): un aviso de que algo salió mal, con su causa.

```kotlin
fun main() {
    println("Antes")
    println(10 / 0)
    println("Después")
}
```

Al compilar, `kotlinc` ya avisa con un **warning** (advertencia: compila, pero huele mal):

```
Crash.kt:3:13: warning: division by zero.
```

Al ejecutar:

```
Antes
Exception in thread "main" java.lang.ArithmeticException: / by zero
	at CrashKt.main(Crash.kt:3)
	at CrashKt.main(Crash.kt)
```

`Antes` sí se imprime: la ejecución va en orden y se detiene en la línea 3. `Después`
nunca llega. La excepción dice qué pasó (`ArithmeticException: / by zero`) y dónde
(`Crash.kt:3`). Las excepciones se estudian en la semana 04.

### 4.3 El error que no avisa

```kotlin
fun Main() {
    println("Hola")
}
```

Compila sin errores ni warnings. Pero `Main` no es `main`: Kotlin distingue mayúsculas
de minúsculas. Al ejecutar:

```
Error: Main method not found in class CKt, please define the main method as:
   public static void main(String[] args)
```

## 5. Antipatrones

- ❌ **Arreglar el error de abajo primero.** Los errores en cadena desaparecen solos al
  arreglar el primero.
- ❌ **Ignorar los warnings.** En los proyectos del bootcamp, Gradle los convierte en
  errores (`allWarningsAsErrors`): un warning hoy es un bug mañana.
- ❌ **Comentar lo obvio.** Ruido que hay que mantener cuando el código cambia.

## 6. Trucos

- Si un string tiene muchas comillas o barras, un raw string se lee mejor que diez `\`.
- Para que la salida de un programa sea fácil de comprobar, imprime cada dato en su
  propia línea. Los tests de esta semana comparan línea a línea.

## ✅ Checklist

- [ ] Reconozco `fun`, `main`, parámetros, cuerpo, llamada a función y string literal
- [ ] Sé la diferencia entre `print` y `println`
- [ ] Uso `\n`, `\t`, `\"`, `\\`, `\$` y `\u`
- [ ] Escribo raw strings con `trimIndent()`
- [ ] Leo un error de compilación: archivo, línea, columna y descripción
- [ ] Distingo error de compilación, warning y error de ejecución

---

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [← Teoría 03 — El contenedor de desarrollo](03-el-contenedor-de-desarrollo.md) | **Teoría 04 — Anatomía de un programa** | [Teoría 05 — Gradle y el wrapper →](05-gradle-y-el-wrapper.md) |
