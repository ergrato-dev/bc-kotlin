# Ejercicio 03 — Strings y lógica

> Al terminar habrás usado expresiones dentro de plantillas, habrás subrayado un título,
> alineado columnas, mostrado centavos con dos decimales y calculado condiciones con
> comparaciones y operadores lógicos.

**Duración estimada**: 2 h
**Prerrequisitos**: [Ejercicio 02](../ejercicio-02-operadores-y-calculos/README.md)
terminado; [Teoría 05](../../1-teoria/05-strings-y-templates.md) y
[Teoría 06](../../1-teoria/06-comparaciones-y-logica.md) leídas.

## Contexto

Este ejercicio junta todo lo de la semana en la forma en que lo usarás en el proyecto:
datos en variables, cálculos, y una salida con formato exacto. Los tests comparan cada
espacio, así que cuenta los caracteres cuando un test de columnas falle.

El starter trae cinco pasos en `src/main/kotlin/Main.kt` y cinco tests.

## Paso 0: Entrar y ver el rojo

```bash
cd bootcamp/week-02-variables_tipos_y_operadores/2-practicas/ejercicio-03-strings-y-logica/starter
docker run --rm -it -v bc-kotlin-gradle:/home/ubuntu/.gradle -v "$PWD":/workspace bc-kotlin-dev
./gradlew test
```

**Verifica**: `5 tests completed, 5 failed`.

## Paso 1: Expresiones en plantillas

**Por qué**: en cuanto hay un punto o una llamada, la plantilla necesita llaves
(Teoría 05, sección 2.1).

```kotlin
val name = "ada lovelace"
println("Nombre: ${name.uppercase()}")
println("Letras: ${name.length}")
```

Resuelve el Paso 1 (borra `TODO("Paso 1")` y quita `//> `).

**Verifica**: `paso1UsesExpressionsInTemplates() PASSED`. El espacio también cuenta como
carácter: `ada lovelace` tiene 12.

**Rómpelo**: quita las llaves de la segunda línea: `"Letras: $name.length"`. Ejecuta
`./gradlew test`:

```
MainTest > paso1UsesExpressionsInTemplates() FAILED
    org.opentest4j.AssertionFailedError: expected: <[Nombre: ADA LOVELACE, Letras: 12]> but was: <[Nombre: ADA LOVELACE, Letras: ada lovelace.length]>
```

Compila sin error y el fallo solo se ve en la salida: por eso hay tests. Restaura las
llaves.

## Paso 2: Subrayar un título

**Por qué**: si el subrayado se calcula a partir del título, sigue midiendo lo mismo
cuando cambias el título.

```kotlin
val title = "Inventario"
println(title)
println("=".repeat(title.length))
```

Resuelve el Paso 2.

**Verifica**: `paso2UnderlinesTheTitle() PASSED`: diez `=` bajo `Inventario`.

## Paso 3: Columnas alineadas

**Por qué**: con ancho fijo, cada columna empieza siempre en la misma posición. Textos a
la izquierda con `padEnd`, números a la derecha con `padStart` (Teoría 05, sección 3.1).

```kotlin
println("Producto".padEnd(12) + "Unidades".padStart(10))
println("Café".padEnd(12) + "3".padStart(10))
println("Pan".padEnd(12) + "12".padStart(10))
```

Resuelve el Paso 3.

**Verifica**: `paso3AlignsColumns() PASSED`. Con `./gradlew -q run`:

```
Producto      Unidades
Café                 3
Pan                 12
```

Cada línea mide exactamente 22 caracteres: 12 de la primera columna y 10 de la segunda.

## Paso 4: Centavos con dos decimales

**Por qué**: es la línea que usarás para cada importe del proyecto (Teoría 04,
sección 3.4).

```kotlin
val totalCents = 4505L
println("Total: ${totalCents / 100}.${(totalCents % 100).toString().padStart(2, '0')}")
```

Resuelve el Paso 4.

**Verifica**: `paso4FormatsCentsWithTwoDecimals() PASSED`: `Total: 45.05`.

**Rómpelo**: sustituye `(totalCents % 100).toString().padStart(2, '0')` por
`totalCents % 100`. Ejecuta `./gradlew test`:

```
MainTest > paso4FormatsCentsWithTwoDecimals() FAILED
    org.opentest4j.AssertionFailedError: expected: <Total: 45.05> but was: <Total: 45.5>
```

45,05 y 45,50 son importes distintos. Restaura `padStart`.

## Paso 5: Condiciones

**Por qué**: cada regla en su propio `val` con nombre de pregunta; la condición final
las combina (Teoría 06, sección 3.3).

```kotlin
val stock = 2
val requested = 3
val isBlocked = false
val coversRequest = stock >= requested
val canSell = stock > 0 && coversRequest && !isBlocked
println("Cubre el pedido: $coversRequest")
println("Se puede vender: $canSell")
println("Mismo nombre: ${"ADA".lowercase() == "ada"}")
```

**Predice** las tres líneas antes de ejecutar.

Resuelve el Paso 5.

**Verifica**: `./gradlew test` → `BUILD SUCCESSFUL`, 5 de 5. Las líneas son
`Cubre el pedido: false`, `Se puede vender: false` y `Mismo nombre: true`.

## Criterios de éxito

- [ ] `./gradlew test`: 5 de 5 tests en verde
- [ ] Sabes cuándo una plantilla necesita llaves
- [ ] Explicas por qué cada línea del Paso 3 mide 22 caracteres
- [ ] Sabes por qué sin `padStart` sale `45.5`
- [ ] Predijiste las tres líneas del Paso 5

## Reto extra

En el Paso 5, cambia **un solo valor** para que `Se puede vender` salga `true`. Hay más
de una forma; encuentra dos y explica, para cada una, qué regla cambia. Después prueba a
poner `val isBlocked = true` con esos cambios y explica el resultado. Restaura los
valores originales al terminar: el test espera `false`.

---

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [← Ejercicio 02 — Operadores y cálculos](../ejercicio-02-operadores-y-calculos/README.md) | **Ejercicio 03 — Strings y lógica** | [Proyecto — Datos del recurso →](../../3-proyecto/README.md) |
