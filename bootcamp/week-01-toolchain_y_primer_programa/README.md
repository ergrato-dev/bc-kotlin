# Semana 01 — Toolchain y primer programa

Instalas el entorno, compilas tu primer programa a mano para ver qué hay debajo, y
después lo haces como se hace siempre: con un proyecto Gradle y tests automáticos. Al
final, tu propio repositorio con la primera capa del sistema de tu dominio.

## 🎯 Objetivos de aprendizaje

- Explicar qué son un programa, un compilador, el bytecode y la JVM.
- Construir el contenedor de desarrollo y trabajar dentro de él.
- Compilar con `kotlinc`, ejecutar con `java` y empaquetar en un JAR.
- Recorrer un proyecto Gradle y usar `run`, `test`, `build` e `installDist`.
- Imprimir texto con exactitud: `print`, `println`, escapes, raw strings y Unicode.
- Leer errores de compilación, errores de ejecución y fallos de test.

## 📋 Prerrequisitos

Ninguno de programación. Necesitas un ordenador con **Docker** y **git** instalados
([`docs/setup.md`](../../docs/setup.md)) y una cuenta de GitHub.

## 📚 Contenidos

| # | Recurso | Tiempo |
| - | ------- | ------ |
| 1 | [Teoría 01 — Qué es programar y qué es Kotlin](1-teoria/01-que-es-programar-y-que-es-kotlin.md) | 25 min |
| 2 | [Teoría 02 — Del código fuente a la JVM](1-teoria/02-del-codigo-fuente-a-la-jvm.md) | 35 min |
| 3 | [Teoría 03 — El contenedor de desarrollo](1-teoria/03-el-contenedor-de-desarrollo.md) | 35 min |
| 4 | [Teoría 04 — Anatomía de un programa](1-teoria/04-anatomia-de-un-programa.md) | 35 min |
| 5 | [Teoría 05 — Gradle y el wrapper](1-teoria/05-gradle-y-el-wrapper.md) | 30 min |
| 6 | [Teoría 06 — Qué es un test](1-teoria/06-que-es-un-test.md) | 20 min |
| 7 | [Ejercicio 01 — Compilar a mano](2-practicas/ejercicio-01-compilar-a-mano/README.md) | 2 h |
| 8 | [Ejercicio 02 — Tu primer proyecto Gradle](2-practicas/ejercicio-02-primer-proyecto-gradle/README.md) | 2 h |
| 9 | [Ejercicio 03 — Salida con formato](2-practicas/ejercicio-03-salida-con-formato/README.md) | 2 h |
| 10 | [Proyecto — Ficha del sistema](3-proyecto/README.md) | 4 h |
| 11 | [Rúbrica de evaluación](rubrica-evaluacion.md) (autoevaluación) | 30 min |
| 12 | [Ebooks](4-recursos/ebooks-free/README.md), [videos](4-recursos/videografia/README.md), [webgrafía](4-recursos/webgrafia/README.md) y [glosario](5-glosario/README.md) | 30 min |

## ⏱️ Distribución del tiempo (14 h)

| Parte | Tiempo |
| ----- | ------ |
| Teoría | 3 h |
| Prácticas | 6 h |
| Proyecto | 4 h |
| Autoevaluación, recursos y glosario | 1 h |

## ✅ Cómo saber que terminaste

- Los tres ejercicios cumplen sus criterios de éxito; en el 02 y el 03,
  `./gradlew test` termina en `BUILD SUCCESSFUL`.
- En tu repositorio `bc-kotlin-<dominio>`, `./gradlew test` pasa los 8 tests del
  proyecto y hay un pull request `week-01` → `main`.
- Respondes las 10 preguntas de la rúbrica sin mirar la teoría.

---

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [← Índice del bootcamp](../README.md) | **Semana 01 — Toolchain y primer programa** | [Teoría 01 — Qué es programar y qué es Kotlin →](1-teoria/01-que-es-programar-y-que-es-kotlin.md) |

← [Volver al índice del bootcamp](../README.md)
