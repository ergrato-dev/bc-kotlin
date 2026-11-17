# Proyecto Semana 01 — Ficha del sistema

> Primera capa del sistema que construyes durante el bootcamp: tu repositorio, tu
> proyecto Gradle y un programa que presenta el sistema de tu dominio.

**Duración estimada**: 4 h
**Prerrequisitos**: los tres ejercicios de la semana terminados.

## Qué se añade y por qué ahora

Todavía no sabes guardar datos ni tomar decisiones; sí sabes crear un proyecto,
imprimir con precisión y verificar con tests. Con eso basta para lo que todo proyecto
necesita el primer día: **existir**, compilar, tener tests en verde y decir qué es. En
las próximas semanas, cada capa se añade sobre este mismo proyecto
([hilo conductor](../../../docs/proyecto-hilo-conductor.md)).

**Tu dominio lo asigna el instructor.** Pídeselo antes de empezar. Los ejemplos de este
README usan una biblioteca: es un dominio reservado para ejemplos y nadie lo recibe.

## Paso 1: Crear tu repositorio

1. En GitHub, crea un repositorio **vacío** llamado `bc-kotlin-<tu-dominio>` (por
   ejemplo `bc-kotlin-veterinaria`), sin README ni `.gitignore`.
2. En tu máquina, copia el starter a una carpeta nueva fuera de `bc-kotlin`:

   ```bash
   cp -r bc-kotlin/bootcamp/week-01-toolchain_y_primer_programa/3-proyecto/starter bc-kotlin-veterinaria
   cd bc-kotlin-veterinaria
   ```

3. Cambia en `settings.gradle.kts` el nombre por el de tu sistema, en minúsculas y con
   guiones: `rootProject.name = "vetcare"`.
4. Crea un `.gitignore` con estas tres líneas, para no subir lo que Gradle genera:

   ```
   build/
   .gradle/
   .kotlin/
   ```

5. Inicializa git y crea la rama de la semana:

   ```bash
   git init -b main
   git add .
   git commit -m "chore: start project from week 01 starter"
   git switch -c week-01
   ```

## Paso 2: Escribir la ficha

Abre `src/main/kotlin/Main.kt`. Los `// TODO:` describen las ocho líneas que debe
imprimir el programa. Escribe un `println` por línea. Ejemplo para una biblioteca:

```
=== BiblioRed ===

Sistema: préstamo de libros entre bibliotecas de barrio
Recurso principal: libro
Aprendiz: Ada Lovelace
Versión: 0.1.0

Compilado con Kotlin 2.4.21 sobre JDK 25
```

## Requisitos verificables

`./gradlew test` ejecuta 8 tests. Todos deben pasar:

| Test | Comprueba |
| ---- | --------- |
| `titleIsFramed` | La línea 1 es `=== <nombre> ===`, sin espacios sobrantes junto al nombre |
| `blankLinesSeparateTheBlocks` | Las líneas 2 y 7 están vacías |
| `describesTheSystem` | La línea 3 empieza por `Sistema: ` y la descripción tiene al menos 10 caracteres |
| `namesTheMainResource` | La línea 4 empieza por `Recurso principal: ` y no está vacía después |
| `namesTheLearner` | La línea 5 empieza por `Aprendiz: ` y no está vacía después |
| `hasTheInitialVersion` | La línea 6 es exactamente `Versión: 0.1.0` |
| `closesWithTheToolchain` | La línea 8 es exactamente `Compilado con Kotlin 2.4.21 sobre JDK 25` y no hay más líneas |
| `everyLineFitsInSixtyColumns` | Ninguna línea pasa de 60 caracteres |

## Cómo verificarlo

Dentro del contenedor, en la carpeta de tu proyecto:

```bash
./gradlew test
./gradlew -q run
./gradlew installDist
build/install/vetcare/bin/vetcare
```

(Cambia `vetcare` por el `rootProject.name` que elegiste.) **Debe salir**:
`BUILD SUCCESSFUL` con 8 tests `PASSED`, y la ficha impresa dos veces: con `run` y con
el lanzador.

## Entregar

En tu máquina (no en el contenedor), en la carpeta de tu proyecto:

```bash
git add .
git commit -m "feat: print the system card"
git remote add origin https://github.com/<tu-usuario>/bc-kotlin-<tu-dominio>.git
git push -u origin main week-01
```

En GitHub, abre un pull request de `week-01` hacia `main` y entrega su enlace.

## Criterios de calidad (no automatizables)

- La descripción de la línea 3 dice **qué hace** el sistema, no qué es ("préstamo de
  libros entre bibliotecas", no "un sistema de biblioteca").
- El recurso principal está en singular y es lo que el sistema **gestiona** (libro,
  mascota, vehículo), no quién lo usa.
- `Main.kt` no conserva los `// TODO:`: un TODO resuelto se borra.
- El commit tiene un mensaje que dice qué cambió.

## Adaptación al dominio

Los tres dominios reservados para ejemplos, para que veas el patrón. El tuyo sale de la
asignación del instructor.

| Dominio (ejemplo) | Título | Recurso principal |
| ----------------- | ------ | ----------------- |
| Biblioteca | `=== BiblioRed ===` | libro |
| Tienda en línea | `=== MercaFácil ===` | producto |
| Cine | `=== CineClub ===` | función |

---

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [← Ejercicio 03 — Salida con formato](../2-practicas/ejercicio-03-salida-con-formato/README.md) | **Proyecto — Ficha del sistema** | [Rúbrica de evaluación →](../rubrica-evaluacion.md) |
