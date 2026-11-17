# Semana 02 — Variables, tipos y operadores

Tus programas dejan de imprimir solo texto fijo: guardan datos con nombre y tipo,
calculan con ellos y muestran el resultado con formato exacto. Al final, tu sistema
describe un recurso de tu dominio y calcula su importe al centavo.

## 🎯 Objetivos de aprendizaje

- Declarar variables con `val` y `var` y elegir entre ellas.
- Usar `Int`, `Long`, `Double`, `Boolean`, `Char` y `String`, con inferencia o con el
  tipo escrito.
- Calcular con `+`, `-`, `*`, `/` y `%`, y predecir la división entera, la precedencia
  y el desbordamiento.
- Convertir entre tipos y guardar importes en centavos con `Long`.
- Construir textos con plantillas `$nombre` y `${expresión}` y alinear columnas.
- Comparar valores y combinar condiciones con `&&`, `||` y `!`.

## 📋 Prerrequisitos

La [semana 01](../week-01-toolchain_y_primer_programa/README.md) completa: el
contenedor funciona, sabes resolver un paso de un starter y tu proyecto
`bc-kotlin-<dominio>` tiene el pull request `week-01` fusionado.

## 📚 Contenidos

| # | Recurso | Tiempo |
| - | ------- | ------ |
| 1 | [Teoría 01 — Valores y variables](1-teoria/01-valores-y-variables.md) | 30 min |
| 2 | [Teoría 02 — Tipos básicos e inferencia](1-teoria/02-tipos-basicos-e-inferencia.md) | 35 min |
| 3 | [Teoría 03 — Operadores aritméticos](1-teoria/03-operadores-aritmeticos.md) | 35 min |
| 4 | [Teoría 04 — Conversiones y dinero](1-teoria/04-conversiones-y-dinero.md) | 30 min |
| 5 | [Teoría 05 — Strings y templates](1-teoria/05-strings-y-templates.md) | 25 min |
| 6 | [Teoría 06 — Comparaciones y lógica](1-teoria/06-comparaciones-y-logica.md) | 25 min |
| 7 | [Ejercicio 01 — Variables y tipos](2-practicas/ejercicio-01-variables-y-tipos/README.md) | 2 h |
| 8 | [Ejercicio 02 — Operadores y cálculos](2-practicas/ejercicio-02-operadores-y-calculos/README.md) | 2 h |
| 9 | [Ejercicio 03 — Strings y lógica](2-practicas/ejercicio-03-strings-y-logica/README.md) | 2 h |
| 10 | [Proyecto — Datos del recurso](3-proyecto/README.md) | 4 h |
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

- En los tres ejercicios, `./gradlew test` termina en `BUILD SUCCESSFUL` y provocaste
  los errores de cada "Rómpelo".
- En tu repositorio, `./gradlew test` pasa los 19 tests y hay un pull request
  `week-02` → `main`.
- Respondes las 10 preguntas de la rúbrica sin mirar la teoría.

---

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [← Semana 01 — Glosario](../week-01-toolchain_y_primer_programa/5-glosario/README.md) | **Semana 02 — Variables, tipos y operadores** | [Teoría 01 — Valores y variables →](1-teoria/01-valores-y-variables.md) |

← [Volver al índice del bootcamp](../README.md)
