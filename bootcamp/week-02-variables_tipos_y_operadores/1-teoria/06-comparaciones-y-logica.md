# Teoría 06 — Comparaciones y lógica

## 🎯 Objetivos

- Comparar valores con `==`, `!=`, `<`, `>`, `<=` y `>=`.
- Comparar strings y saber que distinguen mayúsculas.
- Combinar condiciones con `&&`, `||` y `!`.
- Explicar la evaluación en cortocircuito.
- Evitar comparar `Double` con `==`.

---

## 1. Qué problema resuelven

Un sistema no solo calcula: también **pregunta**. ¿Quedan unidades? ¿El importe supera
el límite? ¿El cliente es mayor de edad **y** tiene entrada? Cada respuesta es un
`Boolean`: `true` o `false`.

Esta semana guardas e imprimes esas respuestas. En la semana 03, con `if` y `when`, el
programa las usará para **decidir** qué hacer.

## 2. Cómo funciona

### 2.1 Operadores de comparación

| Operador | Pregunta | Ejemplo | Resultado |
| -------- | -------- | ------- | --------- |
| `==` | ¿Iguales? | `3 == 3` | `true` |
| `!=` | ¿Distintos? | `3 != 3` | `false` |
| `<` | ¿Menor? | `2 < 3` | `true` |
| `>` | ¿Mayor? | `2 > 3` | `false` |
| `<=` | ¿Menor o igual? | `3 <= 3` | `true` |
| `>=` | ¿Mayor o igual? | `2 >= 3` | `false` |

No confundas `=` (asignar) con `==` (comparar). `stock = 0` cambia el valor;
`stock == 0` pregunta y devuelve un `Boolean`.

```kotlin
fun main() {
    val stock = 4
    val minimumStock = 5
    val needsRestock = stock < minimumStock
    println("Reponer: $needsRestock")
}
```

Sale `Reponer: true`. Una comparación es una expresión: su resultado se guarda en un
`val` como cualquier otro valor.

### 2.2 Comparar strings

`==` entre strings compara el **contenido**, carácter a carácter. Por eso distingue
mayúsculas:

```kotlin
fun main() {
    println("kotlin" == "Kotlin")
    println("kotlin" == "Kotlin".lowercase())
    println("b" > "a")
    println("Z" < "a")
}
```

```
false
true
true
true
```

`<` y `>` comparan por el código Unicode de cada carácter. En Unicode, todas las
mayúsculas van antes que las minúsculas, así que `"Z" < "a"` es `true`. Sirve para
ordenar, pero no es el orden alfabético de un diccionario.

### 2.3 Comparar `Int` con `Long`

`<` y `>` funcionan entre `Int` y `Long`, pero `==` no compila:

```kotlin
fun main() {
    val units = 3
    val unitsLong = 3L
    println(units < unitsLong)
    println(units == unitsLong)
}
```

```
E12.kt:5:13: error: operator '==' cannot be applied to 'Int' and 'Long'.
```

Para comparar igualdad, convierte uno de los dos (Teoría 04): `units.toLong() == unitsLong`.

## 3. Cómo se escribe: operadores lógicos

### 3.1 `&&`, `||` y `!`

| Operador | Nombre | Es `true` cuando... |
| -------- | ------ | ------------------- |
| `a && b` | Y (*and*) | `a` y `b` son `true` |
| `a \|\| b` | O (*or*) | al menos uno es `true` |
| `!a` | No (*not*) | `a` es `false` |

```kotlin
fun main() {
    val age = 20
    val hasTicket = false
    val isMember = true
    println(age >= 18 && hasTicket)
    println(hasTicket || isMember)
    println(!hasTicket)
}
```

```
false
true
true
```

**Precedencia**: primero `!`, después `&&` y por último `||`. Las comparaciones (`>=`,
`==`...) van antes que todos ellos, por eso `age >= 18 && hasTicket` no necesita
paréntesis. Con `&&` y `||` mezclados, pon paréntesis siempre:
`(isMember || hasTicket) && age >= 18`.

### 3.2 Evaluación en cortocircuito

`&&` y `||` evalúan de izquierda a derecha y **se detienen** en cuanto el resultado ya es
seguro:

- En `a && b`, si `a` es `false`, el resultado es `false` sea cual sea `b`: `b` no se
  evalúa.
- En `a || b`, si `a` es `true`, el resultado es `true`: `b` no se evalúa.

```kotlin
fun main() {
    val divisor = 0
    println(divisor != 0 && 10 / divisor > 1)
}
```

Sale `false`, sin `ArithmeticException`. Como `divisor != 0` es `false`, la división
nunca se ejecuta. El orden de las condiciones importa: la que protege va primero.

### 3.3 Nombrar los `Boolean`

Un `Boolean` bien nombrado se lee como una pregunta: `isAvailable`, `hasTicket`,
`needsRestock`, `canBorrow`. Así `println("Disponible: $isAvailable")` se entiende sin
mirar cómo se calculó.

Cuando una condición combina varias, calcula cada parte en su propio `val` y júntalas al
final. Cada nombre explica una regla:

```kotlin
fun main() {
    val stock = 2
    val isBlocked = false
    val requested = 3
    val hasStock = stock > 0
    val coversRequest = stock >= requested
    val canSell = hasStock && coversRequest && !isBlocked
    println("Hay stock: $hasStock")
    println("Cubre el pedido: $coversRequest")
    println("Se puede vender: $canSell")
}
```

```
Hay stock: true
Cubre el pedido: false
Se puede vender: false
```

Si `canSell` sale `false`, las líneas anteriores dicen por qué.

## 4. No compares `Double` con `==`

```kotlin
fun main() {
    println(0.1 + 0.2 == 0.3)
}
```

Sale `false`, por la imprecisión de la Teoría 04. Dos cálculos con `Double` que
"deberían" dar lo mismo pueden diferir en el último decimal. Si necesitas igualdad
exacta, trabaja con enteros (centavos, gramos, minutos) y compara enteros.

## 5. Antipatrones

- ❌ **`=` donde va `==`.** `val empty = stock = 0` no compila: la asignación no es una
  expresión.
- ❌ **`isAvailable == true`.** `isAvailable` ya es un `Boolean`; escríbelo solo.
- ❌ **Mezclar `&&` y `||` sin paréntesis.** Funciona, pero quien lee tiene que recordar
  la precedencia.
- ❌ **Comparar importes en `Double`.** Compara centavos.

## 6. Trucos

- Para comparar textos sin importar mayúsculas, pasa los dos a minúsculas:
  `typed.lowercase() == expected.lowercase()`.
- Pon la condición que protege (`divisor != 0`) a la izquierda de `&&`: el cortocircuito
  evita la operación peligrosa.

## ✅ Checklist

- [ ] Comparo con `==`, `!=`, `<`, `>`, `<=` y `>=`, y guardo el resultado en un `val`
- [ ] Sé que `==` entre strings distingue mayúsculas y que `<` usa el orden Unicode
- [ ] Combino condiciones con `&&`, `||` y `!`, con paréntesis cuando se mezclan
- [ ] Explico el cortocircuito con el ejemplo de la división
- [ ] No comparo `Double` con `==`

---

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [← Teoría 05 — Strings y templates](05-strings-y-templates.md) | **Teoría 06 — Comparaciones y lógica** | [Ejercicio 01 — Variables y tipos →](../2-practicas/ejercicio-01-variables-y-tipos/README.md) |
