# Proyecto Semana 02 — Datos del recurso

> Segunda capa de tu sistema: los datos de un recurso de tu dominio, cada uno con su
> tipo, y los importes calculados en centavos y mostrados con dos decimales.

**Duración estimada**: 4 h
**Prerrequisitos**: los tres ejercicios de la semana terminados; tu proyecto de la
semana 01 con el pull request `week-01` fusionado en `main`.

## Qué se añade y por qué ahora

La ficha de la semana 01 solo decía qué es tu sistema. Ahora sabes guardar datos con su
tipo, calcular con ellos y mostrar el resultado con formato: suficiente para describir
**un** recurso concreto y cuánto cuesta. Todavía es un solo recurso con valores escritos
en el código; en la semana 04 los datos llegarán desde el teclado y en la 05 habrá
muchos recursos ([hilo conductor](../../../docs/proyecto-hilo-conductor.md)).

Los ejemplos usan un cine, un dominio reservado para ejemplos. El tuyo es el que te
asignó el instructor.

## Paso 1: Preparar la rama

En tu máquina, en la carpeta de tu proyecto `bc-kotlin-<tu-dominio>`:

```bash
git switch main
git pull
git switch -c week-02
```

`git pull` trae a tu copia el `main` de GitHub, que ya incluye la semana 01 fusionada.

## Paso 2: Traer los tests de la semana

Los tests de esta semana sustituyen a los de la semana 01: comprueban la ficha (ahora
con versión `0.2.0`) y el bloque nuevo. Cópialos sobre los tuyos, cambiando la ruta por
la de tu copia de `bc-kotlin`:

```bash
cp ../bc-kotlin/bootcamp/week-02-variables_tipos_y_operadores/3-proyecto/starter/src/test/kotlin/*.kt src/test/kotlin/
ls src/test/kotlin
```

**Verifica**: `MainTest.kt  OutputCapture.kt  ResourceTest.kt`. Dentro del contenedor,
`./gradlew test` muestra `19 tests completed` con fallos: el de la versión y los 11 del
recurso.

**No copies** el `Main.kt` del starter: tu `Main.kt` ya tiene tu ficha. El del starter
solo lista, con `// TODO:`, lo que tienes que añadir; ábrelo para leerlo.

## Paso 3: Elegir el recurso y sus datos

Elige un recurso concreto de tu dominio y decide qué significan la cantidad y el importe
unitario. Ejemplos con los dominios reservados:

| Dominio (ejemplo) | Recurso | Cantidad | Importe unitario |
| ----------------- | ------- | -------- | ---------------- |
| Cine | Una función | Entradas vendidas | Precio de una entrada |
| Biblioteca | Un libro | Días de retraso | Multa por día |
| Tienda en línea | Un producto | Unidades del pedido | Precio de una unidad |

Después, declara con `val` y con el tipo correcto:

| Dato | Tipo | Ejemplo (cine) |
| ---- | ---- | -------------- |
| Nombre | `String` | `"Sala 2, sesión de las 20:00"` |
| Código | `String`, forma `AAA-0000` | `"FUN-0042"` |
| Cantidad | `Int` | `4` |
| Importe unitario en centavos | `Long` | `850L` (8.50) |
| Porcentaje de impuesto | `Int` | `19` |

## Paso 4: Calcular

Con `val` y en centavos, como en el Paso 5 del Ejercicio 02:

- **Subtotal** = cantidad × importe unitario.
- **Impuesto** = subtotal × porcentaje / 100, redondeando la mitad hacia arriba
  (Teoría 04, sección 3.3).
- **Total** = subtotal + impuesto.
- **Requiere aprobación** (`Boolean`) = el total es 100.00 o más, es decir,
  `totalCents >= 10_000`.

## Paso 5: Imprimir

Añade al final de `main`, después de tu ficha, estas 11 líneas. Ejemplo del cine:

```
=== CineClub ===

Sistema: venta de entradas y control de aforo de un cine
Recurso principal: función
Aprendiz: Ada Lovelace
Versión: 0.2.0

Compilado con Kotlin 2.4.21 sobre JDK 25

--- Ficha del recurso ---
Nombre: Sala 2, sesión de las 20:00
Código: FUN-0042
Cantidad: 4
Importe unitario: 8.50

Subtotal: 34.00
Impuesto (19 %): 6.46
Total: 40.46
Requiere aprobación: false
```

Cambia también la línea de la versión de tu ficha a `Versión: 0.2.0`. Cada importe se
muestra con `/`, `%` y `padStart` (Teoría 04, sección 3.4). Sí, es la misma expresión
cuatro veces: en la semana 03 la convertirás en una función.

## Requisitos verificables

`./gradlew test` ejecuta 19 tests: los 8 de `MainTest` (la ficha) y los 11 de
`ResourceTest`. Todos deben pasar.

| Test de `ResourceTest` | Comprueba |
| ---------------------- | --------- |
| `separatesTheResourceBlock` | La línea 9 está vacía y la 10 es `--- Ficha del recurso ---` |
| `namesTheResource` | La línea 11 empieza por `Nombre: ` y no está vacía después |
| `hasAWellFormedCode` | La línea 12 es `Código: ` y un código con forma `AAA-0000` |
| `hasAPositiveQuantity` | La línea 13 es `Cantidad: ` y un entero de 1 o más |
| `showsAPositiveUnitAmount` | La línea 14 es `Importe unitario: ` y un importe mayor que `0.00` |
| `blankLineBeforeTheTotals` | La línea 15 está vacía |
| `subtotalIsQuantityTimesUnitAmount` | Línea 16: `Subtotal: ` y cantidad × importe unitario |
| `taxIsRoundedHalfUp` | Línea 17: `Impuesto (<n> %): ` y el impuesto redondeado |
| `totalAddsSubtotalAndTax` | Línea 18: `Total: ` y subtotal + impuesto |
| `flagsTotalsThatNeedApproval` | Línea 19: `Requiere aprobación: ` y `true` si el total es 100.00 o más |
| `hasNoExtraLines` | El programa imprime exactamente 19 líneas |

Todos los importes se escriben con punto y dos decimales: `8.50`, no `8.5` ni `8,50`.
En `MainTest`, `hasTheWeekVersion` exige `Versión: 0.2.0` y
`everyLineFitsInSixtyColumns` sigue vigilando que ninguna línea pase de 60 caracteres.

## Cómo verificarlo

Dentro del contenedor, en la carpeta de tu proyecto:

```bash
./gradlew test
./gradlew -q run
```

**Debe salir**: `BUILD SUCCESSFUL` con 19 tests `PASSED`, y la ficha completa de 19
líneas.

## Entregar

En tu máquina:

```bash
git add .
git commit -m "feat: add resource data and amounts in cents"
git push -u origin week-02
```

En GitHub, abre un pull request de `week-02` hacia `main` y entrega su enlace.

## Criterios de calidad (no automatizables)

- Cada dato está en un `val` con nombre en inglés y camelCase que dice qué contiene, con
  la unidad cuando la tiene: `unitPriceCents`, no `price` ni `p`.
- Ningún importe está escrito a mano en un `println`: todos salen de un cálculo. Si
  cambias la cantidad, el subtotal, el impuesto, el total y la aprobación cambian solos.
- Ningún importe se guarda ni se calcula en `Double`.
- No hay `var`: esta semana ningún dato del proyecto necesita reasignarse.
- El porcentaje de impuesto aparece una sola vez en el código, en su `val`.

## Adaptación al dominio

Los tests no saben qué es tu recurso: comprueban formas y cuentas. Que los datos tengan
sentido para tu dominio es tu parte. Un nombre como `Recurso 1` o un código `AAA-0000`
pasan los tests, pero no los criterios de calidad.

---

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [← Ejercicio 03 — Strings y lógica](../2-practicas/ejercicio-03-strings-y-logica/README.md) | **Proyecto — Datos del recurso** | [Rúbrica de evaluación →](../rubrica-evaluacion.md) |
