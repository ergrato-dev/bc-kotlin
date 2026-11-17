# 🧵 Proyecto hilo conductor

Durante 34 semanas construyes **un solo sistema**, en el dominio que te asigna el
instructor (una clínica veterinaria, un taller, un gimnasio...). Cada semana añade una
capa; ninguna capa depende de una posterior. Al final tienes una biblioteca Kotlin
probada, una CLI, un servicio Ktor con PostgreSQL en producción y un cliente
multiplataforma: un proyecto de portfolio, no 34 ejercicios sueltos.

**El dominio lo asigna el instructor** en la semana 01. Dos aprendices de la misma
cohorte no comparten dominio, y copiar el sistema de otro anula la entrega. Los ejemplos
del bootcamp usan biblioteca, tienda en línea y cine: esos tres no se asignan.

Nombre de tu repositorio: `bc-kotlin-<tu-dominio>` (por ejemplo `bc-kotlin-veterinaria`).
Una rama por semana (`week-01` ... `week-34`); `main` acumula.

## Capas por semana

| Semana | Capa que se añade | Qué existe al terminar |
| ------ | ----------------- | ---------------------- |
| 01 | Esqueleto | Proyecto Gradle propio que imprime la ficha de presentación del sistema |
| 02 | Datos del recurso | Valores del recurso principal con tipos correctos y cálculos (importes, totales) formateados |
| 03 | Reglas como funciones | Funciones puras que deciden (categorías, tarifas, validaciones) con `when` y rangos |
| 04 | Entrada segura | Lectura de datos desde la terminal sin `!!`, con errores modelados y mensajes claros |
| 05 | Inventario en memoria | Alta, baja, búsqueda y listado con colecciones read-only y mutables |
| 06-12 | Modelo del dominio | Clases, jerarquías, tipos sellados, genéricos y un DSL de configuración |
| 13-17 | Biblioteca profesional | Multimódulo, tests, interop, persistencia en archivos JSON, calidad automatizada |
| 18-21 | Procesado concurrente | Importaciones y notificaciones con coroutines y Flow |
| 22-28 | Servicio Ktor | API REST con PostgreSQL, seguridad, tests con Testcontainers, CI e imagen de producción |
| 29-31 | Cliente multiplataforma | Módulo KMP compartido y cliente de escritorio/web |
| 32-34 | Avanzado y entrega | Generación de código con KSP, rendimiento medido, sistema completo y presentación |

Las filas agrupadas se detallan al escribir cada semana.

## Reglas

- **Cada capa deja tests.** Los mínimos los nombra el `3-proyecto/README.md` de la
  semana; puedes añadir más.
- **`./gradlew test` en verde** es el criterio de entrega de toda semana.
- **El starter de cada semana es autocontenido** y usa un recurso genérico `Item`. Tú
  trabajas en **tu** repositorio, con los nombres de **tu** dominio; el starter es la
  referencia de qué firmas se esperan.
- **Versionado**: antes de empezar una semana, `git switch -c week-NN` desde `main`. Al
  terminar, pull request `week-NN` → `main` en tu repositorio.
