# Instrucciones para agentes — bc-kotlin

Fuente de verdad de las convenciones del bootcamp. Léela **antes** de generar contenido.
No deduzcas el patrón mirando archivos sueltos.

## Contexto

| Dato | Valor |
| ---- | ----- |
| Nombre | bc-kotlin — Bootcamp Kotlin Zero to Advanced |
| Duración | 34 semanas × 14 h = 476 h |
| Modalidad | Autoestudio guiado, 100 % práctico |
| Nivel de entrada | Cero absoluto en programación y en Kotlin |
| Nivel de salida | Avanzado: lenguaje a fondo, coroutines, backend Ktor + PostgreSQL, Kotlin Multiplatform, metaprogramación y rendimiento |
| Fuera de alcance | Android (lo cubre `bc-android-kotlin`) |
| Stack | Kotlin 2.4, JDK 25 LTS, Gradle 9 (Kotlin DSL), kotlin-test/JUnit Platform, Docker `ubuntu:24.04`, PostgreSQL |

Versiones exactas y política para cambiarlas: [`docs/stack-versions.md`](../docs/stack-versions.md).

## Malla curricular

| Fase | Semana | Carpeta | Tema |
| ---- | ------ | ------- | ---- |
| 1 · Fundamentos | 01 | `week-01-toolchain_y_primer_programa` | JDK, `kotlinc`, Gradle wrapper, contenedor, `main`, scripts `.kts` |
| | 02 | `week-02-variables_tipos_y_operadores` | `val`/`var`, inferencia, tipos básicos, strings y templates, operadores |
| | 03 | `week-03-control_de_flujo_y_funciones` | `if`/`when` como expresión, rangos, bucles, funciones, named/default args, `tailrec` |
| | 04 | `week-04-null_safety_y_errores` | `?.` `?:` `!!`, smart casts, excepciones, `require`/`check`, `Result` |
| | 05 | `week-05-colecciones` | List/Set/Map, read-only vs mutable, arrays, operaciones básicas |
| | 06 | `week-06-lambdas_y_orden_superior` | Lambdas, funciones de orden superior, scope functions, `Sequence` |
| 2 · POO y tipos | 07 | `week-07-clases_y_propiedades` | Clases, constructores, propiedades, visibilidad, paquetes |
| | 08 | `week-08-herencia_e_interfaces` | Herencia, interfaces, abstractas, `object`, `companion` |
| | 09 | `week-09-modelado_con_tipos` | data, enum, sealed, value classes |
| | 10 | `week-10-genericos_y_varianza` | `in`/`out`, star projection, `inline` + `reified` |
| | 11 | `week-11-extensiones_y_delegacion` | Extensiones, `by`, `lazy`, `observable`, operator overloading |
| | 12 | `week-12-dsls_type_safe` | Lambdas con receiver, `@DslMarker`, context parameters |
| 3 · Ecosistema JVM y calidad | 13 | `week-13-gradle_kotlin_dsl` | Multimódulo, version catalogs, tareas |
| | 14 | `week-14-testing` | JUnit Platform, kotest, MockK, TDD |
| | 15 | `week-15-interop_java_y_jvm` | Bytecode, `@Jvm*`, platform types, JDK APIs |
| | 16 | `week-16-io_y_serializacion` | Archivos, kotlinx-serialization, kotlinx-datetime |
| | 17 | `week-17-calidad_de_codigo` | ktlint, detekt, Kover, Dokka |
| 4 · Concurrencia | 18 | `week-18-coroutines` | `suspend`, builders, dispatchers |
| | 19 | `week-19-concurrencia_estructurada` | Scopes, cancelación, excepciones, supervisión |
| | 20 | `week-20-flow` | Flow, StateFlow, SharedFlow, operadores |
| | 21 | `week-21-channels_y_estado_compartido` | Channels, Mutex, coroutines-test, Turbine |
| 5 · Backend Ktor | 22 | `week-22-ktor_server` | Routing, plugins, content negotiation, configuración |
| | 23 | `week-23-postgresql_con_exposed` | Exposed, Flyway, Docker Compose |
| | 24 | `week-24-arquitectura_hexagonal` | Puertos y adaptadores, Koin, validación, errores |
| | 25 | `week-25-seguridad` | JWT, sesiones, hashing, OWASP API Top 10 |
| | 26 | `week-26-testing_backend` | `testApplication`, Testcontainers PostgreSQL |
| | 27 | `week-27-cliente_y_observabilidad` | Ktor client, resiliencia, OpenAPI, logs, métricas, OpenTelemetry |
| | 28 | `week-28-produccion` | Imagen multi-stage, configuración, CI con GitHub Actions |
| 6 · Multiplatform y avanzado | 29 | `week-29-kmp_fundamentos` | Targets, source sets, `expect`/`actual` |
| | 30 | `week-30-kmp_compartido` | Ktor client, SQLDelight, Kotlin/JS y Wasm |
| | 31 | `week-31-compose_multiplatform` | Escritorio y web |
| | 32 | `week-32-metaprogramacion` | Anotaciones, reflexión, KSP |
| | 33 | `week-33-rendimiento_y_compilador` | JMH, asignaciones, inline, K2, compiler plugins |
| | 34 | `week-34-proyecto_integrador` | Integración final |

Los nombres de carpeta de las semanas sin escribir son provisionales: se fijan al
escribir la semana y se actualiza esta tabla.

**Progresión estricta.** Ninguna semana usa lo que se enseña después. Antes de la 05
no hay colecciones más allá de `listOf` leído en un `for`; antes de la 06 no hay
lambdas; antes de la 07 no hay clases propias (salvo la clase de test que pide
kotlin-test, que se presenta como "plantilla" sin explicar); antes de la 09 no hay
`data class`; antes de la 18 no hay coroutines.

## Distribución de una semana (14 h)

| Parte | Tiempo |
| ----- | ------ |
| `1-teoria/` | 3 h |
| `2-practicas/` | 6 h |
| `3-proyecto/` | 4 h |
| Autoevaluación, recursos, glosario | 1 h |

## Estructura de una semana

```
bootcamp/week-NN-slug_snake_case/
├── README.md                  # Descripción, objetivos, prerrequisitos, contenidos, tiempos, navegación
├── rubrica-evaluacion.md      # Conocimiento 30 / Desempeño 40 / Producto 30
├── 0-assets/                  # SVG, uno por diagrama, NN-nombre.svg
├── 1-teoria/                  # NN-nombre-con-guion.md
├── 2-practicas/
│   └── ejercicio-NN-nombre/
│       ├── README.md          # Pasos guiados
│       └── starter/           # Proyecto Gradle: compila, tests escritos y en rojo
├── 3-proyecto/
│   ├── README.md
│   └── starter/
├── 4-recursos/{ebooks-free,videografia,webgrafia}/README.md
└── 5-glosario/README.md
```

Plantilla de proyecto Gradle: [`docs/plantillas/starter-gradle/`](../docs/plantillas/starter-gradle/).
Cópiala entera (con `gradlew`, `gradle/wrapper/`) y cambia `rootProject.name`.

## 1-teoria

- Número de archivos libre: los que pida el tema. Un archivo = un concepto.
- 200-300 líneas por archivo. Si se pasa, mezcla dos temas: se divide, no se recorta.
- Orden de cada archivo: `## 🎯 Objetivos` → **qué problema resuelve** → **cómo
  funciona** → **cómo se escribe en Kotlin** → **antipatrones** → **trucos** →
  `## ✅ Checklist` → navegación.
- **Cero absoluto de verdad**: cada término técnico se define la primera vez que
  aparece ("compilador", "JVM", "bytecode", "tipo", "expresión", "referencia"...).
- **Paso a paso, nunca asumir**: todo ejemplo dice dónde se escribe, qué comando lo
  ejecuta y qué salida exacta produce.
- **Todo fragmento compila** con la toolchain de `docs/stack-versions.md`. Un ejemplo
  de lo que NO se hace se marca `// ❌` con el error o warning exacto del compilador.
- Verifica antes de afirmar: compila el fragmento en el contenedor; enlaza
  [kotlinlang.org/docs](https://kotlinlang.org/docs/home.html) o la API de la stdlib.

## 2-practicas

Ejercicios **guiados**: el aprendiz sigue pasos, cada uno con su porqué, su código y
su verificación. Sin `solution/`: el código marcado en el starter es la solución.

Formato del starter (convención que `scripts/compilar-starters.sh` automatiza):

```kotlin
// PASO 2: elegir el saludo según la hora.
// Borra la línea TODO y descomenta las líneas que empiezan con `//> `.
fun greeting(hour: Int): String {
    TODO("Paso 2")
    //> return if (hour < 12) "Buenos días" else "Buenas tardes"
}
```

- `TODO("Paso N")` va solo en su línea, dentro de un cuerpo con llaves. Lanza
  `NotImplementedError` y el test del paso falla con un mensaje claro.
- Las líneas de solución empiezan con `//> `. Los comentarios explicativos usan `//`.
- Los **tests van escritos** en `src/test/kotlin/` y son el contrato del ejercicio.
- Cada paso del README: `## Paso N: título` → **Por qué** → código → **Abre** el
  archivo → **Verifica** con el comando exacto y la salida esperada (qué tests pasan,
  cuáles siguen en rojo y por qué).
- El starter compila con `allWarningsAsErrors`. Un starter con warnings no se publica.

## 3-proyecto

Cada semana añade una capa al **mismo sistema** del aprendiz (hilo conductor:
[`docs/proyecto-hilo-conductor.md`](../docs/proyecto-hilo-conductor.md)). El starter
usa `// TODO:` con la firma esperada y una pista, sobre un recurso genérico `Item` que
el aprendiz adapta a su dominio. **El dominio lo asigna el instructor**; el catálogo no
vive en este repo.

El README del proyecto incluye: capa que se añade y por qué ahora, requisitos
verificables, cómo verificar (`./gradlew test`, salida esperada), criterios de calidad
no automatizables y ejemplos de adaptación para cinco dominios genéricos (biblioteca,
tienda en línea, cine — los que el instructor no asigna).

La solución de referencia del proyecto **no va en este repo**: vive en el repo privado
`ergrato-dev/bc-instructor`, en `bc-kotlin/week-NN-slug/3-proyecto/`.

## 4-recursos y 5-glosario

- `ebooks-free/`: tabla `Título | Formato | Descripción | Enlace`. Solo gratuitos y legales.
- `videografia/`: tabla `Título | Canal | Duración | Enlace`. Mínimo 3; español si hay de calidad.
- `webgrafia/`: tabla `Recurso | Descripción`. Documentación oficial primero.
- Cada recurso lleva una línea de por qué vale la pena. Enlaces comprobados.
- Glosario: tabla `Término | Definición | Ejemplo`, A-Z, términos **nuevos** de la
  semana, término en español con el inglés entre paréntesis cuando exista.

## Convenciones de código

- **Nomenclatura técnica en inglés**: identificadores, paquetes, archivos `.kt`,
  nombres de proyecto Gradle, commits. Strings que ve el usuario del programa y
  comentarios: español.
- Estilo oficial de Kotlin (4 espacios, `camelCase`, `PascalCase` para tipos,
  `SCREAMING_SNAKE_CASE` para `const val`).
- Comentarios de documentación: **¿Qué? ¿Para qué? ¿Impacto?** donde aporten (archivos
  de build, Dockerfiles, scripts, decisiones no obvias). Nunca repitas un comentario
  que ya dijo lo mismo más arriba; nunca comentes lo que el código ya dice.
- Herramientas: **Docker** con base `ubuntu:24.04` cuando haga falta un entorno;
  **PostgreSQL** como única base de datos relacional (nunca MySQL); **pnpm** para
  cualquier herramienta Node invocada a mano (nunca npm); **uv** si aparece Python
  (nunca pip). Kotlin/JS y Wasm gestionan sus paquetes Node desde el plugin de Gradle:
  se documenta y no se invoca ningún gestor a mano.

## Escritura

- Español neutro con **tuteo**: tú, tienes, puedes, haz, mira. **Nunca voseo**
  (vos, tenés, podés, hacé, mirá).
- Directo y sin relleno. El porqué antes del cómo.
- Un término inglés se escribe en inglés cuando es nombre técnico (`smart cast`,
  `scope function`); la primera vez lleva su explicación en español.

## Navegación

Todo `.md` dentro de `bootcamp/` termina con una tabla de navegación:

```markdown
---

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [← Teoría 01 — Qué es Kotlin](01-que-es-kotlin.md) | **Teoría 02 — La JVM** | [Teoría 03 — Gradle →](03-gradle.md) |
```

Orden de lectura dentro de una semana: README → teorías → ejercicios → proyecto →
rúbrica → recursos (ebooks, videos, web) → glosario → README de la semana siguiente.
En los extremos se usa `—`. El README de la semana añade debajo de la tabla
`← [Volver al índice del bootcamp](../README.md)`.

Índice `bootcamp/README.md`: una semana publicada enlaza número y título
(`| [01](week-01-slug/README.md) | [Tema](week-01-slug/README.md) | ✅ |`); una sin
publicar, sin enlace y con ⬜.

## Diagramas SVG

Los que pida el contenido, ni uno más ni uno menos. Un diagrama entra cuando muestra lo
que el texto no puede (un flujo con ramas, capas, memoria, una secuencia en el tiempo);
sobra si es una lista con cajas o repite el bloque de código de al lado.

- `viewBox` obligatorio, sin `width`/`height` en la raíz; `role="img"`, `aria-label` y
  `<title>` como primer hijo.
- `<rect>` de fondo `#0d1117` que cubre el `viewBox`. **Sin degradados**, sin
  `foreignObject`, sin fuentes externas, texto ≥ 12 px.
- Prosa: `font-family="Inter, system-ui, -apple-system, 'Segoe UI', sans-serif"`.
  Código: `ui-monospace, SFMono-Regular, Menlo, monospace`.
- Cada SVG se enlaza desde la teoría donde aparece su concepto
  (`![texto alternativo que describe lo que muestra](../0-assets/NN-nombre.svg)`).
  Nunca ASCII art, nunca capturas, nunca Mermaid.

| Rol | Hex |
| --- | --- |
| Lienzo | `#0d1117` |
| Superficie | `#161b22` |
| Borde | `#30363d` |
| Texto principal | `#f0f6fc` |
| Texto secundario | `#8b949e` |
| Acento Kotlin (elemento principal) | `#7f52ff` / claro `#a98bff` |
| Azul (flujo, entrada) | `#58a6ff` |
| Verde (éxito) | `#3fb950` |
| Amarillo (aviso) | `#e3b341` |
| Rojo (error) | `#f85149` |
| Naranja (JVM, bytecode) | `#f0883e` |

## Rúbrica

Tres evidencias, **mínimo 70 % en cada una**: 🧠 Conocimiento 30 % (10 preguntas que
piden el porqué, con respuestas plegadas), 💪 Desempeño 40 % (ejercicios, verificados
por sus tests), 📦 Producto 30 % (proyecto: tests + calidad). Bandas: Sobresaliente
90-100, Notable 80-89, Aprobado 70-79.

## Checklist de publicación de una semana

- [ ] Tests de ejercicios y proyecto escritos antes del contenido
- [ ] `./scripts/compilar-starters.sh week-NN` en verde (starters compilan y fallan; resueltos pasan)
- [ ] `./scripts/verificar-enlaces.sh` en verde
- [ ] Sin voseo, sin `npm`/`pip`/MySQL, sin `solution/`, sin `docs/dominios.md`
- [ ] Solución del proyecto en `bc-instructor/bc-kotlin/week-NN-slug/3-proyecto/`
- [ ] Índice `bootcamp/README.md` actualizado (✅ + enlaces)
- [ ] Commit `feat(week-NN): ...` y push
