# Rúbrica de evaluación — Semana 01: Toolchain y primer programa

## 📊 Distribución de evidencias

| Tipo | Peso | Instrumento |
| ---- | ---- | ----------- |
| Conocimiento 🧠 | 30 % | Cuestionario de autoevaluación (10 preguntas) |
| Desempeño 💪 | 40 % | Ejercicios 01, 02 y 03 |
| Producto 📦 | 30 % | Proyecto: ficha del sistema en tu repositorio |

**Nota mínima para aprobar**: 70 % en **cada** tipo de evidencia, no en el promedio.

---

## 🧠 Conocimiento (30 %)

Responde por escrito, sin mirar la teoría. Las respuestas están al final, plegadas.

| # | Pregunta | Puntos |
| - | -------- | ------ |
| 1 | ¿Qué hace un compilador y por qué un error de compilación es una ayuda y no un obstáculo? | 10 |
| 2 | ¿Qué problema resuelve compilar a bytecode en vez de a código máquina? | 10 |
| 3 | ¿Qué diferencia hay entre `kotlinc`, `java` y `kotlin`? Da un ejemplo de uso de cada uno. | 10 |
| 4 | ¿Por qué `java -cp . HelloKt` necesita, en general, la biblioteca estándar de Kotlin en el classpath, y por qué `java -jar hello.jar` no, si se creó con `-include-runtime`? | 10 |
| 5 | ¿Qué es una imagen, qué es un contenedor y qué hace `-v "$PWD":/workspace`? | 10 |
| 6 | ¿Por qué se usa `./gradlew` y no un `gradle` instalado en el sistema? | 10 |
| 7 | ¿Qué significa `UP-TO-DATE` en la salida de Gradle y qué ventaja da? | 10 |
| 8 | Este mensaje: `Main.kt:4:5: error: unresolved reference 'printn'.` ¿Qué te dice cada parte y qué arreglo necesita? | 10 |
| 9 | ¿Qué diferencia hay entre `"a\nb"` y un raw string `"""a\nb"""` al imprimirlos? | 10 |
| 10 | Un test dice `expected: <Listo para la semana 02.> but was: <null>`. ¿Qué significa `<null>` aquí y qué es lo más probable que pase en el programa? | 10 |

**Total**: 100 puntos → 30 % de la nota.

<details>
<summary>Respuestas</summary>

1. Traduce el código fuente completo a una forma ejecutable (en Kotlin/JVM, bytecode).
   Si el código no sigue las reglas, se niega y dice archivo, línea y columna: el fallo
   aparece antes de que el programa se ejecute y llegue a alguien.
2. El código máquina es distinto para cada procesador y sistema operativo. El bytecode es
   el mismo en todas partes: se compila una vez y cualquier JVM lo ejecuta, traduciéndolo
   al código máquina de su sistema mientras corre.
3. `kotlinc` compila `.kt` a `.class` (`kotlinc Hello.kt`). `java` arranca la JVM y
   ejecuta bytecode (`java -jar hello.jar`). `kotlin` ejecuta scripts o programas Kotlin
   (`kotlin hello.main.kts`).
4. Todo lo que el programa use de la biblioteca estándar (por ejemplo `reversed()`) vive en
   `kotlin-stdlib.jar`; si la JVM no lo encuentra, falla con `NoClassDefFoundError`.
   `-include-runtime` mete esa biblioteca dentro del JAR.
5. Una imagen es un sistema de archivos preparado y congelado (el resultado del
   Dockerfile). Un contenedor es una imagen en ejecución. `-v "$PWD":/workspace` hace que
   la carpeta actual del host aparezca en `/workspace` dentro del contenedor: editas fuera
   y compilas dentro sobre los mismos archivos.
6. El wrapper descarga y usa la versión exacta de Gradle que pide el proyecto
   (`gradle-wrapper.properties`). Un `gradle` del sistema puede ser otra versión, o no
   existir.
7. Que la tarea ya está hecha y nada de lo que necesita cambió: Gradle se la salta. Las
   construcciones repetidas son mucho más rápidas.
8. Archivo `Main.kt`, línea 4, columna 5; `unresolved reference`: el compilador no conoce
   nada llamado `printn`. Es una errata de `println`: se corrige el nombre.
9. `"a\nb"` imprime dos líneas (`a` y `b`): `\n` es un escape. En un raw string no hay
   escapes: imprime una línea con los cuatro caracteres `a\nb`.
10. `<null>` indica que esa línea no existe: el programa imprimió menos líneas de las
    esperadas. Lo más probable es que `main` se detenga antes (por ejemplo, en un
    `TODO("Paso N")` sin resolver) o que falten `println`.

</details>

---

## 💪 Desempeño (40 %)

| Ejercicio | Criterio | Puntos |
| --------- | -------- | ------ |
| 01 — Compilar a mano | Compila con `kotlinc`, ejecuta con `java -cp` y `java -jar` | 10 |
| | Explica los dos `main` de `javap` y los errores de los pasos 6 y 7 | 10 |
| 02 — Primer proyecto Gradle | `./gradlew test`: 3 de 3 en verde | 15 |
| | Ejecuta el lanzador de `installDist` y explica `UP-TO-DATE` | 15 |
| 03 — Salida con formato | `./gradlew test`: 5 de 5 en verde | 30 |
| | Explica qué pasa sin `trimIndent()` | 20 |

**Total**: 100 puntos → 40 % de la nota. Los puntos de explicación se dan en una
conversación corta con el instructor o por escrito en el pull request.

---

## 📦 Producto (30 %)

| Criterio | Puntos |
| -------- | ------ |
| Repositorio `bc-kotlin-<dominio>` con `.gitignore` y pull request `week-01` → `main` | 10 |
| `./gradlew test`: 8 de 8 tests en verde | 50 |
| `rootProject.name` propio y el lanzador de `installDist` imprime la ficha | 10 |
| Calidad: descripción que dice qué hace el sistema, recurso en singular, sin `// TODO:` restantes, mensaje de commit claro | 30 |

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
| [← Proyecto — Ficha del sistema](3-proyecto/README.md) | **Rúbrica de evaluación** | [Ebooks gratuitos →](4-recursos/ebooks-free/README.md) |
