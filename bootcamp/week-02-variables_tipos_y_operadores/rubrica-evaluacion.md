# Rúbrica de evaluación — Semana 02: Variables, tipos y operadores

## 📊 Distribución de evidencias

| Tipo | Peso | Instrumento |
| ---- | ---- | ----------- |
| Conocimiento 🧠 | 30 % | Cuestionario de autoevaluación (10 preguntas) |
| Desempeño 💪 | 40 % | Ejercicios 01, 02 y 03 |
| Producto 📦 | 30 % | Proyecto: datos del recurso en tu repositorio |

**Nota mínima para aprobar**: 70 % en **cada** tipo de evidencia, no en el promedio.

---

## 🧠 Conocimiento (30 %)

Responde por escrito, sin mirar la teoría. Las respuestas están al final, plegadas.

| # | Pregunta | Puntos |
| - | -------- | ------ |
| 1 | ¿Qué diferencia hay entre `val` y `var`, y cuál se usa por defecto? ¿Por qué? | 10 |
| 2 | ¿Qué tipo infiere el compilador para `val a = 3`, `val b = 3_000_000_000`, `val c = 3.0` y `val d = '3'`? | 10 |
| 3 | `val price: Double = 3` no compila. Copia la parte importante del error, explícala y arréglalo. | 10 |
| 4 | ¿Qué imprimen `17 / 5`, `17 % 5`, `-17 / 5` y `17.0 / 5`? | 10 |
| 5 | ¿Por qué `10 / 3 * 3` y `10 * 3 / 3` dan resultados distintos? | 10 |
| 6 | ¿Qué es el desbordamiento? Da un ejemplo y di cómo se evita en los importes del bootcamp. | 10 |
| 7 | ¿Por qué los importes se guardan en centavos con `Long` y no en `Double`? | 10 |
| 8 | Escribe la expresión que calcula un impuesto del 21 % sobre `subtotalCents`, redondeando la mitad hacia arriba, y explica el `+ 50`. | 10 |
| 9 | ¿Qué imprime `"Letras: $name.length"` si `name` es `"Ada"`, y cómo se arregla? | 10 |
| 10 | En `divisor != 0 && 10 / divisor > 1` con `divisor = 0`, ¿por qué no se produce `ArithmeticException`? | 10 |

**Total**: 100 puntos → 30 % de la nota.

<details>
<summary>Respuestas</summary>

1. `val` se asigna una sola vez; `var` se puede reasignar. Por defecto `val`: quien lee
   sabe que el dato vale lo mismo en todo el programa, y el compilador impide cambiarlo
   por error.
2. `Int`, `Long` (no cabe en un `Int`), `Double` y `Char`.
3. `initializer type mismatch: expected 'Double', actual 'Int'`: declaraste `Double` y
   el valor `3` es un `Int`; Kotlin no convierte solo. Se arregla con `3.0`.
4. `3`, `2`, `-3` y `3.4`.
5. Con enteros, `/` descarta los decimales. `10 / 3` es `3` y `3 * 3` es `9`; en cambio
   `10 * 3` es `30` y `30 / 3` es `10`. Multiplicar antes de dividir pierde menos.
6. Un cálculo supera el máximo del tipo y el resultado da la vuelta sin avisar:
   `Int.MAX_VALUE * 2` da `-2`. Los importes van en `Long`, con un máximo mucho mayor.
7. `Double` guarda aproximaciones binarias (`0.1 + 0.2` da `0.30000000000000004`) y
   aparecen o desaparecen centavos. Los enteros son exactos; `Long` evita el
   desbordamiento al sumar importes grandes.
8. `(subtotalCents * 21 + 50) / 100`. Sumar la mitad del divisor hace que un resultado
   con ,5 o más suba al entero siguiente antes de que `/` trunque.
9. `Letras: Ada.length`: la plantilla `$name` termina en el nombre. Con llaves:
   `"Letras: ${name.length}"` imprime `Letras: 3`.
10. `&&` evalúa en cortocircuito: como `divisor != 0` es `false`, el resultado ya es
    `false` y la división no se evalúa.

</details>

---

## 💪 Desempeño (40 %)

| Ejercicio | Criterio | Puntos |
| --------- | -------- | ------ |
| 01 — Variables y tipos | `./gradlew test`: 5 de 5 en verde | 20 |
| | Explica los errores provocados en los pasos 2, 3 y 5 | 10 |
| 02 — Operadores y cálculos | `./gradlew test`: 5 de 5 en verde | 20 |
| | Explica los fallos de los pasos 2 y 5 y el reto del desbordamiento | 15 |
| 03 — Strings y lógica | `./gradlew test`: 5 de 5 en verde | 20 |
| | Explica las dos formas del reto y por qué cada línea del Paso 3 mide 22 caracteres | 15 |

**Total**: 100 puntos → 40 % de la nota. Los puntos de explicación se dan en una
conversación corta con el instructor o por escrito en el pull request.

---

## 📦 Producto (30 %)

| Criterio | Puntos |
| -------- | ------ |
| Rama `week-02` y pull request `week-02` → `main` | 10 |
| `./gradlew test`: 19 de 19 tests en verde | 50 |
| Datos con sentido para el dominio asignado (nombre y código reales, cantidad e importe plausibles) | 10 |
| Calidad: un `val` por dato con nombre y unidad, ningún importe escrito a mano ni en `Double`, sin `var`, el porcentaje una sola vez, commit claro | 30 |

**Total**: 100 puntos → 30 % de la nota.

---

## 🏅 Bandas

| Banda | Rango |
| ----- | ----- |
| Sobresaliente | 90-100 |
| Notable | 80-89 |
| Aprobado | 70-79 |
| No aprobado | < 70 en alguna evidencia |

---

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [← Proyecto — Datos del recurso](3-proyecto/README.md) | **Rúbrica de evaluación** | [Ebooks gratuitos →](4-recursos/ebooks-free/README.md) |
