# Teoría 06 — Qué es un test

## 🎯 Objetivos

- Explicar qué es un test automático y por qué los ejercicios vienen con tests escritos.
- Leer un test de esta semana y el mensaje que da cuando falla.
- Aplicar el ciclo de los ejercicios: rojo → resolver un paso → verde.
- Reconocer la convención `TODO("Paso N")` y `//> ` de los starters.

---

## 1. Qué problema resuelve un test

¿Cómo sabes que tu programa hace lo que debe? La primera respuesta es ejecutarlo y mirar
la salida. Funciona una vez. Pero cuando el programa crece, mirar a ojo cada salida, cada
vez que cambias algo, es lento y se te escapan cosas.

Un **test automático** es un pequeño programa que ejecuta el tuyo y **comprueba** el
resultado contra lo esperado. Si coincide, el test **pasa** (verde). Si no, **falla**
(rojo) y dice qué esperaba y qué obtuvo. Lo ejecutas con un comando, en segundos, tantas
veces como quieras.

En este bootcamp, los tests de los ejercicios están **ya escritos**: son el contrato del
ejercicio. Tu trabajo es ponerlos en verde, paso a paso, entendiendo cada línea.

## 2. Cómo funciona un test de esta semana

```kotlin
import kotlin.test.Test
import kotlin.test.assertEquals

class MainTest {
    private val lines = captureMain()

    @Test
    fun paso2PrintsTheTitle() {
        assertEquals("Bootcamp Kotlin — Semana 01", lines.getOrNull(0))
    }
}
```

Por ahora lee este archivo como una **plantilla**; las piezas que no entiendes se
explican en su semana. Lo que importa:

| Pieza | Qué hace |
| ----- | -------- |
| `import ...` | Trae de la biblioteca `kotlin-test` las herramientas `Test` y `assertEquals` |
| `class MainTest { ... }` | Agrupa los tests. Las clases llegan en la semana 07 |
| `captureMain()` | Función del starter (`OutputCapture.kt`) que ejecuta tu `main` y devuelve lo que imprimió, línea a línea |
| `@Test` | Marca la función de debajo como test: Gradle la ejecuta en `./gradlew test` |
| `fun paso2PrintsTheTitle()` | Un test. Su nombre dice qué comprueba |
| `assertEquals(esperado, obtenido)` | Compara dos valores. Si no son iguales, el test falla |
| `lines.getOrNull(0)` | La primera línea impresa (se cuenta desde 0), o `null` ("nada") si no hay ninguna |

Una **aserción** (*assertion*) es una afirmación que el test comprueba: "la primera línea
**es** `Bootcamp Kotlin — Semana 01`".

## 3. Cómo se usa: el ciclo de los ejercicios

### 3.1 La convención de los starters

En el código de cada ejercicio, cada paso tiene esta forma:

```kotlin
fun main() {
    // PASO 2: la primera línea del programa.
    TODO("Paso 2")
    //> println("Bootcamp Kotlin — Semana 01")
}
```

- `TODO("Paso 2")` es una función de la biblioteca estándar que **detiene el programa a
  propósito** con el error `NotImplementedError: An operation is not implemented: Paso 2`.
  Marca el sitio donde falta trabajo.
- Las líneas que empiezan con `//> ` son la solución del paso, **comentada**. El
  compilador las ignora.

**Resolver un paso** es: leer en el README del ejercicio por qué se hace, borrar la línea
`TODO("Paso N")` y quitar `//> ` del principio de cada línea del paso. Escríbelas a mano
si quieres fijarlas mejor; el resultado debe ser el mismo.

### 3.2 Rojo

Antes de tocar nada, ejecuta los tests:

```bash
./gradlew test
```

```
MainTest > paso2PrintsTheTitle() FAILED
    org.opentest4j.AssertionFailedError: expected: <Bootcamp Kotlin — Semana 01> but was: <>

MainTest > paso4PrintsTheClosingLine() FAILED
    org.opentest4j.AssertionFailedError: expected: <Listo para la semana 02.> but was: <null>

3 tests completed, 3 failed
```

Cómo se lee: `expected: <...>` es lo que el test esperaba; `but was: <...>` es lo que
obtuvo. `<>` vacío: la línea existe pero está vacía. `<null>`: esa línea ni siquiera
existe. Todos fallan porque `main` se detiene en el primer `TODO`.

Es importante ver el rojo **antes** de cambiar nada: confirma que los tests funcionan y
que fallan por la razón esperada, no por un problema de instalación.

### 3.3 Un paso, verde

Resuelves el Paso 2 y vuelves a ejecutar:

```
MainTest > paso2PrintsTheTitle() PASSED
MainTest > paso4PrintsTheClosingLine() FAILED
MainTest > paso3PrintsTheToolList() FAILED
3 tests completed, 2 failed
```

El test del Paso 2 pasa. Los otros siguen en rojo porque `main` ahora se detiene en
`TODO("Paso 3")`. `captureMain()` devuelve lo impreso **hasta** ese punto: por eso cada
paso resuelto pasa aunque falten los siguientes.

El orden en que Gradle lista los tests puede variar entre ejecuciones; no importa.

### 3.4 Todo verde

Con todos los pasos resueltos:

```
MainTest > paso2PrintsTheTitle() PASSED
MainTest > paso4PrintsTheClosingLine() PASSED
MainTest > paso3PrintsTheToolList() PASSED
BUILD SUCCESSFUL in 1s
```

El ejercicio está terminado cuando `./gradlew test` dice `BUILD SUCCESSFUL`.

## 4. Antipatrones

- ❌ **Cambiar el test para que pase.** El test es el contrato. Si crees que está mal,
  léelo dos veces y compáralo con el README; si sigue pareciendo mal, avísalo al
  instructor. Nunca lo edites.
- ❌ **Resolver todos los pasos de golpe.** Si algo falla, no sabrás cuál fue. Un paso,
  una verificación.
- ❌ **Fijarte solo en `PASSED`/`FAILED`.** El mensaje `expected/but was` te dice
  exactamente qué carácter sobra o falta: un espacio, una tilde, un punto final.

## 5. Trucos

- Las diferencias invisibles (un espacio al final, un guion `-` frente a una raya `—`)
  son las más frecuentes. Copia el texto esperado del mensaje del test y compáralo con el
  tuyo carácter a carácter.
- `./gradlew test` y luego `./gradlew -q run` es una buena pareja: el primero dice si
  está bien; el segundo te enseña la salida completa.

## ✅ Checklist

- [ ] Sé qué es un test automático y una aserción
- [ ] Leo `expected: <...> but was: <...>`, incluidos `<>` y `<null>`
- [ ] Sé resolver un paso: borrar `TODO("Paso N")` y quitar `//> `
- [ ] Sigo el ciclo: rojo, un paso, verificar
- [ ] Nunca edito un test para que pase

---

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [← Teoría 05 — Gradle y el wrapper](05-gradle-y-el-wrapper.md) | **Teoría 06 — Qué es un test** | [Ejercicio 01 — Compilar a mano →](../2-practicas/ejercicio-01-compilar-a-mano/README.md) |
