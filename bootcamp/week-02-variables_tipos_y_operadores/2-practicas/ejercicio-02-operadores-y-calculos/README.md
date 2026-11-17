# Ejercicio 02 — Operadores y cálculos

> Al terminar habrás usado la división entera y el resto, habrás comparado la división
> entera con la decimal, habrás aplicado la precedencia, habrás actualizado un stock con
> `-=`, `+=` y `++`, y habrás calculado un total en centavos con un impuesto redondeado.

**Duración estimada**: 2 h
**Prerrequisitos**: [Ejercicio 01](../ejercicio-01-variables-y-tipos/README.md)
terminado; [Teoría 03](../../1-teoria/03-operadores-aritmeticos.md) y
[Teoría 04](../../1-teoria/04-conversiones-y-dinero.md) leídas.

## Contexto

Todos los cálculos de este ejercicio tienen un resultado exacto que el test compara.
Antes de resolver cada paso, **predice** en papel qué va a imprimir. Si tu predicción
falla, relee la sección de la teoría que se indica: ese fallo es justo lo que el paso
quiere enseñarte.

El starter trae cinco pasos en `src/main/kotlin/Main.kt` y cinco tests.

## Paso 0: Entrar y ver el rojo

```bash
cd bootcamp/week-02-variables_tipos_y_operadores/2-practicas/ejercicio-02-operadores-y-calculos/starter
docker run --rm -it -v bc-kotlin-gradle:/home/ubuntu/.gradle -v "$PWD":/workspace bc-kotlin-dev
./gradlew test
```

**Verifica**: `5 tests completed, 5 failed`.

## Paso 1: División entera y resto

**Por qué**: `/` y `%` con el mismo divisor separan una cantidad en dos unidades:
minutos en horas y minutos, centavos en unidades y centavos (Teoría 03, sección 2.2).

```kotlin
val totalMinutes = 135
val hours = totalMinutes / 60
val minutes = totalMinutes % 60
println("$totalMinutes min = $hours h $minutes min")
```

**Predice** antes: ¿cuántas veces cabe 60 en 135, y cuánto sobra?

Resuelve el Paso 1 (borra `TODO("Paso 1")` y quita `//> `).

**Verifica**: `paso1SplitsMinutesIntoHours() PASSED`; la línea es
`135 min = 2 h 15 min`.

## Paso 2: Entera frente a decimal

**Por qué**: entre dos `Int`, `/` descarta los decimales. Para conservarlos, uno de los
operandos tiene que ser `Double` (Teoría 03, sección 2.1; Teoría 04, sección 2.2).

```kotlin
val distanceKm = 17
val trips = 5
println("Media entera: ${distanceKm / trips}")
println("Media real: ${distanceKm.toDouble() / trips}")
```

`${...}` mete el resultado de un cálculo dentro del texto (Teoría 04, sección 3.4).

Resuelve el Paso 2.

**Verifica**: `paso2ComparesIntegerAndRealDivision() PASSED`.

**Rómpelo**: quita `.toDouble()` de la segunda línea. Ejecuta `./gradlew test`:

```
MainTest > paso2ComparesIntegerAndRealDivision() FAILED
    org.opentest4j.AssertionFailedError: expected: <[Media entera: 3, Media real: 3.4]> but was: <[Media entera: 3, Media real: 3]>
```

El test compara las dos líneas a la vez, como una lista entre `[` y `]`. Busca la
diferencia: `3.4` frente a `3`. Restaura `.toDouble()`.

## Paso 3: Precedencia

**Por qué**: `*` va antes que `+`. Si el precio extra es por persona y la base también,
hacen falta paréntesis (Teoría 03, sección 3.1).

```kotlin
val basePrice = 20
val extra = 5
val people = 3
println("Sin paréntesis: ${basePrice + extra * people}")
println("Con paréntesis: ${(basePrice + extra) * people}")
```

**Predice** los dos resultados antes de ejecutar.

Resuelve el Paso 3.

**Verifica**: `paso3AppliesPrecedence() PASSED`: `35` y `75`.

## Paso 4: Actualizar el stock

**Por qué**: un `var` que cambia a partir de su propio valor se actualiza con los atajos
`-=`, `+=` y `++` (Teoría 03, secciones 3.2 y 3.3).

```kotlin
var stock = 10
stock -= 3
stock += 5
stock++
println("Stock final: $stock")
```

Sigue el valor línea a línea: 10, después 7, después 12, después 13.

Resuelve el Paso 4.

**Verifica**: `paso4UpdatesTheStock() PASSED`.

## Paso 5: Un total en centavos

**Por qué**: es el cálculo que harás en el proyecto. Importes en `Long`, porcentaje en
`Int`, y el redondeo de la mitad hacia arriba con `+ 50` (Teoría 04, secciones 3.2 y
3.3).

```kotlin
val unitPriceCents = 1250L
val units = 3
val taxRatePercent = 21
val subtotalCents = unitPriceCents * units
val taxCents = (subtotalCents * taxRatePercent + 50) / 100
val totalCents = subtotalCents + taxCents
println("Subtotal: $subtotalCents")
println("Impuesto: $taxCents")
println("Total: $totalCents")
```

Resuelve el Paso 5.

**Verifica**: `./gradlew test` → `BUILD SUCCESSFUL`, 5 de 5. Las tres líneas son
`Subtotal: 3750`, `Impuesto: 788` y `Total: 4538`.

**Rómpelo**: quita ` + 50` de la línea de `taxCents`. Ejecuta `./gradlew test`:

```
MainTest > paso5ComputesTheTotalInCents() FAILED
    org.opentest4j.AssertionFailedError: expected: <[Subtotal: 3750, Impuesto: 788, Total: 4538]> but was: <[Subtotal: 3750, Impuesto: 787, Total: 4537]>
```

3750 × 21 / 100 es 787,5: sin `+ 50` se trunca a 787 y el total pierde un centavo.
Restaura ` + 50`.

## Criterios de éxito

- [ ] `./gradlew test`: 5 de 5 tests en verde
- [ ] Predijiste los resultados de los pasos 1, 3 y 4 antes de ejecutarlos
- [ ] Sabes por qué sin `.toDouble()` sale `3`
- [ ] Sabes por qué sin `+ 50` el impuesto es `787`

## Reto extra

Cambia `val unitPriceCents = 1250L` por `val unitPriceCents = 1250` (sin `L`) y
`val units = 3` por `val units = 2_000_000`. Ejecuta `./gradlew -q run` y mira el
subtotal. ¿Por qué sale negativo? Vuelve a poner la `L` y ejecuta otra vez. Explica la
diferencia con la Teoría 03, sección 4.1. Restaura los valores originales al terminar.

---

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [← Ejercicio 01 — Variables y tipos](../ejercicio-01-variables-y-tipos/README.md) | **Ejercicio 02 — Operadores y cálculos** | [Ejercicio 03 — Strings y lógica →](../ejercicio-03-strings-y-logica/README.md) |
