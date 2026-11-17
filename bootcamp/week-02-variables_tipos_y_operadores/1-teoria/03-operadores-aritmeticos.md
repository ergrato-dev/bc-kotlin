# Teoría 03 — Operadores aritméticos

## 🎯 Objetivos

- Calcular con `+`, `-`, `*`, `/` y `%`.
- Predecir el resultado de la división entera y del resto, también con negativos.
- Aplicar la precedencia de operadores y usar paréntesis.
- Actualizar variables con `+=`, `-=`, `++` y `--`.
- Reconocer el desbordamiento de enteros y la división por cero.

---

## 1. Qué problema resuelven

Un sistema de verdad calcula: subtotales, impuestos, unidades restantes, minutos
convertidos en horas. Un **operador** es un símbolo que combina valores y produce un valor
nuevo. Una **expresión** es cualquier trozo de código que produce un valor: `3`, `price`
y `price * 3` son expresiones.

## 2. Cómo funciona: los cinco operadores

| Operador | Operación | Ejemplo | Resultado |
| -------- | --------- | ------- | --------- |
| `+` | Suma | `7 + 2` | `9` |
| `-` | Resta | `7 - 2` | `5` |
| `*` | Multiplicación | `7 * 2` | `14` |
| `/` | División | `7 / 2` | `3` |
| `%` | Resto (*remainder*) | `7 % 2` | `1` |

¿`7 / 2` da `3`? Sí, y es la sorpresa más frecuente de la semana.

### 2.1 División entera

Cuando los **dos** operandos son enteros (`Int` o `Long`), `/` hace **división entera**:
el resultado es entero y los decimales se descartan. Un **operando** es cada valor que
participa en la operación.

```kotlin
fun main() {
    println(17 / 5)
    println(17 % 5)
    println(17.0 / 5)
    println(17 / 5.0)
}
```

```
3
2
3.4
3.4
```

17 entre 5 cabe **3** veces (3 × 5 = 15) y **sobran 2**. `/` da las veces que cabe;
`%` da lo que sobra. Si al menos uno de los operandos es `Double`, el resultado es
`Double` y conserva los decimales.

### 2.2 Para qué sirve el resto

`%` parece raro, pero resuelve problemas muy comunes:

```kotlin
fun main() {
    val totalMinutes = 135
    val hours = totalMinutes / 60
    val minutes = totalMinutes % 60
    println("$hours h $minutes min")
}
```

Sale `2 h 15 min`. El mismo truco separa la parte entera de los centavos (`4538 / 100` es
`45` y `4538 % 100` es `38`) y dice si un número es par: `n % 2` es `0` en los pares y `1` en
los impares positivos.

### 2.3 Con números negativos

La división entera **trunca hacia cero**: descarta los decimales, sin redondear.

```kotlin
fun main() {
    println(-17 / 5)
    println(-17 % 5)
}
```

```
-3
-2
```

−3,4 se queda en −3, y el resto lleva el signo del primer operando: −3 × 5 + (−2) = −17.

## 3. Cómo se escribe

### 3.1 Precedencia y paréntesis

La **precedencia** decide qué operación se hace primero cuando hay varias. Como en
matemáticas: `*`, `/` y `%` antes que `+` y `-`. Con la misma precedencia, de izquierda
a derecha.

```kotlin
fun main() {
    println(2 + 3 * 4)
    println((2 + 3) * 4)
    println(10 / 3 * 3)
    println(10 * 3 / 3)
}
```

```
14
20
9
10
```

Las dos últimas líneas tienen los mismos números en distinto orden y dan resultados
distintos: `10 / 3` es `3` (división entera) y `3 * 3` es `9`; en cambio `10 * 3` es `30`
y `30 / 3` es `10`. Con enteros, **multiplica antes de dividir** si quieres perder lo
menos posible.

Cuando una expresión mezcla operadores, pon paréntesis aunque no hagan falta: quien lee
no tiene que recordar la tabla de precedencia.

### 3.2 Asignación compuesta

Actualizar una variable a partir de su propio valor es tan común que tiene atajo:

| Escribes | Equivale a |
| -------- | ---------- |
| `stock += 5` | `stock = stock + 5` |
| `stock -= 3` | `stock = stock - 3` |
| `stock *= 2` | `stock = stock * 2` |
| `stock /= 2` | `stock = stock / 2` |
| `stock %= 2` | `stock = stock % 2` |

Solo funciona con `var`: un `val` no se puede reasignar, tampoco con atajo.

### 3.3 Incremento y decremento

`stock++` suma 1 y `stock--` resta 1. Escrito solo en su línea es lo único que necesitas.
Si lo usas dentro de otra expresión, importa dónde va:

```kotlin
fun main() {
    var stock = 10
    stock++
    val a = stock++
    val b = ++stock
    println("$a $b $stock")
}
```

Sale `11 13 13`. `stock++` (**postincremento**) entrega el valor **antes** de sumar:
`a` recibe 11 y `stock` pasa a 12. `++stock` (**preincremento**) suma **primero**: `stock`
pasa a 13 y `b` recibe 13. Para no tener que pensarlo, el bootcamp usa `++` y `--` solo
en su propia línea.

### 3.4 Mezclar tipos numéricos

```kotlin
fun main() {
    val price = 12.5
    val units = 3
    println(price * units)
    println(units * price)
}
```

Sale `37.5` dos veces: `Double` con `Int` da `Double`. Lo que no se puede es **guardar**
el resultado en una variable de otro tipo. Añade esta línea al final del `main`
anterior (queda en la línea 6):

```kotlin
    val total: Int = units * price
```

```
E8.kt:6:20: error: initializer type mismatch: expected 'Int', actual 'Double'.
```

Pasar de un tipo a otro es una **conversión**, y siempre se pide de forma explícita
([Teoría 04](04-conversiones-y-dinero.md)).

### 3.5 `+` con texto

Entre strings, `+` **concatena** (une textos). Con un string a la izquierda, lo de la
derecha se convierte en texto:

```kotlin
fun main() {
    println("42" + 1)
    println("1" + 2 + 3)
}
```

Sale `421` y `123`: no hay suma, hay texto pegado. Al revés, `1 + "2"` no compila: un
`Int` no sabe sumarse un `String`. En la [Teoría 05](05-strings-y-templates.md) verás
que las plantillas `$` evitan casi siempre este `+`.

## 4. Cuando el cálculo se sale de los límites

### 4.1 Desbordamiento

Un `Int` tiene un máximo (Teoría 02). Si un cálculo lo supera, el resultado **da la
vuelta** y sale un número absurdo. Se llama **desbordamiento** (*overflow*):

```kotlin
fun main() {
    println(Int.MAX_VALUE * 2)
    println(3_000_000 * 1000)
    println(3_000_000L * 1000)
}
```

```
-2
-1294967296
3000000000
```

Ni error ni aviso: el compilador lo acepta y el programa sigue con un dato falso. La
tercera línea funciona porque `3_000_000L` es `Long`, y `Long` por `Int` da `Long`. Por
eso los importes en centavos van en `Long`.

### 4.2 División por cero

```kotlin
fun main() {
    println(10 / 0)
}
```

Con enteros, el compilador avisa (`warning: division by zero.`) y, si se ejecuta, el
programa se detiene con `java.lang.ArithmeticException: / by zero`, como viste en el
Ejercicio 01 de la semana 01. Con `Double` no se detiene: `1.0 / 0` da `Infinity` y
`0.0 / 0` da `NaN` (*Not a Number*), dos valores especiales que contaminan los cálculos
siguientes sin avisar. En la semana 03 aprenderás a comprobar el divisor antes de dividir.

## 5. Antipatrones

- ❌ **Dividir enteros esperando decimales.** `7 / 2` es `3`. Si necesitas `3.5`, uno de
  los operandos tiene que ser `Double`.
- ❌ **Dividir antes de multiplicar con enteros.** `10 / 3 * 3` pierde un 1 por el camino.
- ❌ **`++` dentro de expresiones.** Escríbelo en su propia línea.
- ❌ **Calcular importes grandes en `Int`.** El desbordamiento no avisa.

## 6. Trucos

- `n % 2 == 0` dice si un número es par (verás `==` en la
  [Teoría 06](06-comparaciones-y-logica.md)).
- Para pasar segundos a minutos y segundos, o centavos a unidades y centavos, el par
  `/` y `%` con el mismo divisor siempre va junto.

## ✅ Checklist

- [ ] Uso `+`, `-`, `*`, `/` y `%`
- [ ] Predigo `17 / 5`, `17 % 5`, `-17 / 5` y `17.0 / 5`
- [ ] Aplico la precedencia y pongo paréntesis cuando ayudan
- [ ] Uso `+=`, `-=`, `++` y `--` con `var`
- [ ] Sé qué es el desbordamiento y por qué `Long` lo evita en importes
- [ ] Sé qué pasa al dividir por cero con `Int` y con `Double`

---

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [← Teoría 02 — Tipos básicos e inferencia](02-tipos-basicos-e-inferencia.md) | **Teoría 03 — Operadores aritméticos** | [Teoría 04 — Conversiones y dinero →](04-conversiones-y-dinero.md) |
