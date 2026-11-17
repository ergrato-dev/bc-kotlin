# 📖 Glosario — Semana 02

| Término | Definición | Ejemplo |
| ------- | ---------- | ------- |
| Asignación compuesta | Atajo que actualiza una variable a partir de su propio valor | `stock -= 3` |
| Asignar | Dar un valor a una variable con `=` | `val units = 3` |
| Bit | Unidad mínima de información: 0 o 1 | Un `Int` ocupa 32 bits |
| camelCase | Convención de nombres: primera palabra en minúscula, las siguientes empiezan en mayúscula | `unitPriceCents` |
| Concatenar | Unir textos con `+` | `"42" + 1` da `"421"` |
| Conversión | Crear un valor de otro tipo a partir de uno existente | `units.toLong()` |
| Cortocircuito | `&&` y `\|\|` dejan de evaluar cuando el resultado ya es seguro | `divisor != 0 && 10 / divisor > 1` |
| Declarar | Crear una variable con su nombre y, normalmente, su valor inicial | `var stock = 10` |
| Desbordamiento (*overflow*) | Un cálculo supera el máximo del tipo y el resultado da la vuelta | `Int.MAX_VALUE * 2` da `-2` |
| División entera | División entre enteros que descarta los decimales | `17 / 5` da `3` |
| Expresión | Código que produce un valor | `price * units` |
| Función de un valor | Operación que un valor sabe hacer; se llama con punto y paréntesis | `name.uppercase()` |
| Inferencia de tipos | El compilador deduce el tipo a partir del valor inicial | `val weight = 4.5` es `Double` |
| Inmutable | Que no cambia una vez creado | Los `String` de Kotlin |
| Literal | Valor escrito directamente en el código | `42L`, `'K'`, `"Kotlin"` |
| Operador | Símbolo que combina valores y produce otro | `+`, `%`, `==`, `&&` |
| Operando | Cada valor que participa en una operación | En `17 / 5`, `17` y `5` |
| Plantilla de string (*string template*) | Texto con `$nombre` o `${expresión}` que se sustituyen por su valor | `"Total: ${units * 2}"` |
| Precedencia | Orden en que se aplican los operadores | `2 + 3 * 4` da `14` |
| Propiedad | Dato que lleva un valor; se lee con punto y sin paréntesis | `name.length` |
| Reasignar | Dar a una variable `var` un valor nuevo | `stock = 7` |
| Resto (*remainder*) | Lo que sobra de una división entera | `17 % 5` da `2` |
| Tipado estático | Cada variable tiene un tipo fijo que se comprueba al compilar | `var y = 5; y = "texto"` no compila |
| Tipo | Clase de dato de un valor; dice qué se puede hacer con él | `Int`, `Long`, `Double`, `Boolean`, `Char`, `String` |
| Truncar | Descartar los decimales sin redondear | `3.99.toInt()` da `3` |
| `val` | Variable de solo lectura: se asigna una vez | `val language = "Kotlin"` |
| `var` | Variable reasignable | `var stock = 10` |
| Variable | Nombre que apunta a un valor | `language` |

---

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [← Webgrafía](../4-recursos/webgrafia/README.md) | **Glosario** | [Índice del bootcamp →](../../README.md) |
