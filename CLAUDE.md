# CLAUDE.md — bc-kotlin

Bootcamp **Kotlin Zero to Advanced**: 34 semanas × 14 h = 476 h, autoestudio, de cero
absoluto a avanzado. Lenguaje, JVM, coroutines, backend Ktor + PostgreSQL, Kotlin
Multiplatform, metaprogramación y rendimiento. Sin Android (eso es `bc-android-kotlin`).

## Fuente de verdad

**[`.github/copilot-instructions.md`](.github/copilot-instructions.md)**: malla,
estructura de semana, formato de starters, navegación, paleta SVG, rúbrica y checklist.
Léelo antes de generar contenido.

## Reglas duras

1. **Todo fragmento compila** con la toolchain de `docs/stack-versions.md`, verificado
   en el contenedor (`docker build -t bc-kotlin-dev docker`). Ningún error ni warning
   se cita de memoria: se copia del compilador.
2. **Cero absoluto, paso a paso.** Cada término se define la primera vez. Cada ejemplo
   dice dónde se escribe, cómo se ejecuta y qué imprime. Nada se da por sabido.
3. **Progresión estricta.** Ninguna semana usa lo que se enseña después.
4. **Tuteo siempre, nunca voseo.** Prosa en español; código, identificadores, nombres de
   archivo de código y commits en inglés (Conventional Commits: `feat(week-01): ...`).
5. **Comentarios ¿Qué? ¿Para qué? ¿Impacto?** donde aporten, sin repetirlos.
6. **Herramientas**: Docker con `ubuntu:24.04`, PostgreSQL (nunca MySQL), pnpm (nunca
   npm), uv (nunca pip).
7. **SVG** los que pida el contenido; tema oscuro, sin degradados, sans-serif.
8. **Navegación en tabla** (Anterior | Actual | Siguiente) al pie de todo `.md` de `bootcamp/`.
9. **Sin soluciones en el repo.** Ejercicios: el código `//> ` del starter es la
   solución, nunca hay `solution/`. Proyecto: la solución va a
   `ergrato-dev/bc-instructor/bc-kotlin/week-NN-slug/3-proyecto/`; en ese repo se hace
   commit solo de la carpeta propia (`git add bc-kotlin && git commit -m "..." -- bc-kotlin`).
10. **Dominios fuera del repo.** Catálogo en `ergrato-dev/bc-dominios/catalogos/bc-kotlin.md`.
    Aquí solo se dice que el dominio lo asigna el instructor.
11. **Bloques de 5 semanas por sesión**, una semana por commit, push al cerrar cada semana.

## Antes de dar por terminada una semana

```bash
./scripts/compilar-starters.sh week-NN   # starters compilan y fallan; resueltos pasan
./scripts/verificar-enlaces.sh           # carpetas, enlaces, navegación, SVG, prohibidos
```

## Estructura

```
bootcamp/   34 semanas + README.md índice
docs/       setup, versiones, hilo conductor, plantillas/
docker/     Dockerfile (ubuntu:24.04 + JDK 25 + kotlinc); compose.yaml llega en la semana 23
scripts/    compilar-starters.sh, verificar-enlaces.sh
assets/     header del README
```
