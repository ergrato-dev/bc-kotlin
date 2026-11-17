# Ejercicio 01 — Variables y tipos

> Al terminar habrás declarado variables con `val` y `var`, habrás usado un valor de
> cada tipo básico, habrás visto el límite de `Int` y habrás provocado y leído los
> errores de tipo más frecuentes.

**Duración estimada**: 2 h
**Prerrequisitos**: [Teoría 01](../../1-teoria/01-valores-y-variables.md) y
[Teoría 02](../../1-teoria/02-tipos-basicos-e-inferencia.md) leídas.

## Contexto

Cada paso imprime una o dos líneas y tiene su test. Además de resolver el paso, en
varios vas a **romper** el código a propósito para ver el error del compilador: es la
forma más rápida de aprender a leerlo. Después de cada rotura, deja el código como
estaba antes de seguir.

El starter trae cinco pasos en `src/main/kotlin/Main.kt` y cinco tests en
`src/test/kotlin/MainTest.kt`.

## Paso 0: Entrar y ver el rojo

En tu máquina, desde la raíz del repositorio `bc-kotlin`:

```bash
cd bootcamp/week-02-variables_tipos_y_operadores/2-practicas/ejercicio-01-variables-y-tipos/starter
docker run --rm -it -v bc-kotlin-gradle:/home/ubuntu/.gradle -v "$PWD":/workspace bc-kotlin-dev
./gradlew test
```

**Verifica**: `5 tests completed, 5 failed`.

## Paso 1: `val` e inferencia

**Por qué**: un dato con nombre se escribe una vez y se usa donde haga falta. El
compilador deduce el tipo del valor.

```kotlin
val language = "Kotlin"
val firstYear = 2016
println("$language 1.0 salió en $firstYear")
```

**Abre `src/main/kotlin/Main.kt`** y resuelve el Paso 1: borra la línea
`TODO("Paso 1")` y quita `//> ` del principio de sus tres líneas.

**Verifica**: `./gradlew test` → `paso1PrintsValuesWithATemplate() PASSED`.

**Rómpelo**: cambia `val firstYear = 2016` por `val firstYear = "2016"`. Ejecuta
`./gradlew test`: **sigue pasando**. Con comillas, `firstYear` es un `String`, y una
plantilla imprime igual un texto que un número. El tipo importa cuando calculas, no
cuando imprimes. Quita las comillas.

## Paso 2: `var` y reasignación

**Por qué**: el stock baja con cada venta; necesita una variable que se pueda reasignar.

```kotlin
var stock = 10
println("Stock inicial: $stock")
stock = 7
println("Stock tras la venta: $stock")
```

Resuelve el Paso 2.

**Verifica**: `paso2ReassignsAVar() PASSED`.

**Rómpelo**: cambia `var stock` por `val stock`. Ejecuta `./gradlew test`. El compilador
se detiene antes de los tests:

```
e: file:///workspace/src/main/kotlin/Main.kt:13:5 'val' cannot be reassigned.
```

Gradle muestra los errores con otra forma que `kotlinc`: `e:` (error), la ruta del
archivo, `línea:columna` y el mensaje. La línea 13 es `stock = 7` (si ya borraste las
líneas `TODO` de los pasos 1 y 2; si no, el número cambia). Vuelve a `var`.

## Paso 3: Un valor de cada tipo

**Por qué**: cada dato tiene el tipo que le corresponde por lo que vas a hacer con él
(Teoría 02, sección 4).

```kotlin
val units: Int = 3
val priceCents: Long = 1250
val weightKg: Double = 4.5
val isAvailable: Boolean = true
val initial: Char = 'K'
println("$units | $priceCents | $weightKg | $isAvailable | $initial")
```

Resuelve el Paso 3.

**Verifica**: `paso3PrintsOneValueOfEachType() PASSED`.

**Rómpelo**, de uno en uno, ejecutando `./gradlew test` cada vez y restaurando después:

| Cambio | Error que verás |
| ------ | --------------- |
| `val weightKg: Double = 4` | `initializer type mismatch: expected 'Double', actual 'Int'.` |
| `val initial: Char = "K"` | `initializer type mismatch: expected 'Char', actual 'String'.` |
| `val units: Int = 3_000_000_000` | `initializer type mismatch: expected 'Int', actual 'Long'.` |

En los tres, **expected** es el tipo que escribiste y **actual** el del valor.

## Paso 4: El límite de `Int`

**Por qué**: un `Int` no guarda cualquier número. Si el literal no cabe, el compilador
infiere `Long`.

```kotlin
val maxInt = Int.MAX_VALUE
val worldPopulation = 8_100_000_000
println("Máximo Int: $maxInt")
println("Población mundial: $worldPopulation")
```

Resuelve el Paso 4.

**Verifica**: `paso4ShowsIntLimitAndInferredLong() PASSED`. En el editor, deja el
cursor sobre `worldPopulation`: el tipo inferido es `Long`.

## Paso 5: Dígitos que no son números

**Por qué**: un código o un teléfono tienen dígitos, pero no se suman ni se multiplican.
Si los guardas como número, pierdes información.

```kotlin
val code = "LIB-0042"
val phone = "0341234567"
println("Código: $code")
println("Teléfono: $phone")
```

Resuelve el Paso 5.

**Verifica**: `./gradlew test` → `BUILD SUCCESSFUL`, 5 de 5.

**Rómpelo**: quita las comillas del teléfono: `val phone = 0341234567`. El compilador
responde `leading zeros are not allowed in integer literals.`: un número no puede
empezar por 0. Aunque lo aceptara, el `0` inicial se perdería. Restaura las comillas.

## Criterios de éxito

- [ ] `./gradlew test`: 5 de 5 tests en verde
- [ ] Sabes leer un error de Gradle: `e:`, ruta, línea, columna y mensaje
- [ ] Provocaste y leíste los tres `initializer type mismatch` del Paso 3
- [ ] Explicas por qué un teléfono es un `String`

## Reto extra

Añade al final de `main` (fuera de los pasos) una variable `var counter = 0`, después
`counter = 2.5` y un `println(counter)`. Antes de compilar, escribe qué error esperas.
Compila y compara. Luego arréglalo de las dos formas posibles: cambiando el valor
inicial a `0.0` o cambiando el `2.5` por un entero. ¿Cuál tiene sentido para un
contador? Borra las líneas al terminar: los tests exigen la salida exacta.

---

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [← Teoría 06 — Comparaciones y lógica](../../1-teoria/06-comparaciones-y-logica.md) | **Ejercicio 01 — Variables y tipos** | [Ejercicio 02 — Operadores y cálculos →](../ejercicio-02-operadores-y-calculos/README.md) |
