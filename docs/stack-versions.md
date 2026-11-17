# 📌 Versiones del stack

Toda herramienta y dependencia se fija a una **versión exacta**. Nunca `latest`, nunca
rangos (`1.+`), nunca ramas. Una versión flotante cambia sin avisar y rompe un starter
que compilaba ayer.

## Toolchain

| Herramienta | Versión | Dónde se fija | Por qué esta |
| ----------- | ------- | ------------- | ------------ |
| Imagen base | `ubuntu:24.04` | `docker/Dockerfile` | LTS con soporte hasta 2029; trae OpenJDK 25 en sus repositorios |
| JDK | OpenJDK 25 (paquete `openjdk-25-jdk-headless`) | `docker/Dockerfile` y `jvmToolchain(25)` | LTS vigente de Java |
| Kotlin | `2.4.21` | `kotlin("jvm") version "2.4.21"` y `ARG KOTLIN_VERSION` | Última estable con más de dos semanas publicada |
| Gradle | `9.8.2` | `gradle/wrapper/gradle-wrapper.properties` | Última estable de la rama 9 con más de dos semanas publicada |
| kotlin-test | la de Kotlin (`kotlin("test")`) | `build.gradle.kts` | Versión alineada con el compilador; usa JUnit Platform |

## Dependencias por semana

Cada dependencia se añade a esta tabla **en la semana que la introduce**, con la versión
verificada ese día. Hasta entonces no se fija nada.

| Biblioteca | Versión | Desde la semana | Uso |
| ---------- | ------- | --------------- | --- |
| — | — | — | — |

## Política

1. **Cómo se elige una versión**: la última estable publicada hace al menos dos semanas
   (deja tiempo a que salgan los parches urgentes). Se consulta el release oficial en
   GitHub o Maven Central, nunca un blog.
2. **Cómo se cambia**: en un solo commit `chore(deps): ...` que actualiza esta tabla,
   el `Dockerfile`, la plantilla `docs/plantillas/starter-gradle/` y **todos** los
   starters, y que pasa `./scripts/compilar-starters.sh` en cada semana publicada.
3. **Seguridad**: antes de fijar una dependencia nueva se revisan sus avisos de
   seguridad (GitHub Security Advisories). Con un CVE abierto no se fija.
