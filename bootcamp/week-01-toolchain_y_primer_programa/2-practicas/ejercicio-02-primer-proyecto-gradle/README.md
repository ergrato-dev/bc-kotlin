# Ejercicio 02 — Tu primer proyecto Gradle

> Al terminar habrás recorrido un proyecto Gradle archivo por archivo, habrás puesto tres
> tests en verde paso a paso y habrás ejecutado, empaquetado e instalado el programa.

**Duración estimada**: 2 h
**Prerrequisitos**: [Ejercicio 01](../ejercicio-01-compilar-a-mano/README.md) terminado;
[Teoría 05](../../1-teoria/05-gradle-y-el-wrapper.md) y
[Teoría 06](../../1-teoria/06-que-es-un-test.md) leídas.

## Contexto

El programa imprime una pequeña ficha del bootcamp con las herramientas que usas. Lo de
menos es el texto; lo importante es el **ciclo** que vas a repetir en todos los
ejercicios: tests en rojo → resolver un paso → verificar → siguiente paso.

El starter trae `src/main/kotlin/Main.kt` con tres pasos comentados (el 2, el 3 y el 4;
el Paso 1 es explorar) y `src/test/kotlin/MainTest.kt` con un test por paso.

## Paso 0: Entrar en el contenedor dentro del starter

**Por qué**: Gradle se ejecuta desde la carpeta del proyecto, la que tiene `gradlew`.

En tu máquina:

```bash
cd bootcamp/week-01-toolchain_y_primer_programa/2-practicas/ejercicio-02-primer-proyecto-gradle/starter
docker run --rm -it -v bc-kotlin-gradle:/home/ubuntu/.gradle -v "$PWD":/workspace bc-kotlin-dev
```

**Verifica**: `ls` muestra `build.gradle.kts  gradle  gradlew  gradlew.bat  settings.gradle.kts  src`.

## Paso 1: Explorar el proyecto

**Por qué**: antes de ejecutar nada, sabes qué es cada archivo.

```bash
cat settings.gradle.kts
cat gradle/wrapper/gradle-wrapper.properties
cat build.gradle.kts
find src -type f
```

`find src -type f` lista todos los archivos (*files*) dentro de `src`.

**Verifica**, comparando con la [Teoría 05](../../1-teoria/05-gradle-y-el-wrapper.md):

- `settings.gradle.kts` dice `rootProject.name = "first-gradle-project"`.
- `gradle-wrapper.properties` contiene `gradle-9.8.2-bin.zip`.
- `build.gradle.kts` declara `kotlin("jvm") version "2.4.21"` y `jvmToolchain(25)`.
- `find` muestra `src/main/kotlin/Main.kt`, `src/test/kotlin/MainTest.kt` y
  `src/test/kotlin/OutputCapture.kt`.

Ahora pide a Gradle sus versiones:

```bash
./gradlew --version
```

La primera vez descarga Gradle: puede tardar un par de minutos. **Verifica**: aparece
`Gradle 9.8.2`. La línea `Kotlin: 2.4.10` es el Kotlin interno de Gradle (Teoría 05,
sección 3.3); no es el que compila tu código.

## Paso 1b: Ver los tests en rojo

**Por qué**: comprobar que los tests funcionan y fallan por la razón esperada.

```bash
./gradlew test
```

**Verifica**: al final, `3 tests completed, 3 failed` y `BUILD FAILED`. Arriba, por
ejemplo:

```
MainTest > paso2PrintsTheTitle() FAILED
    org.opentest4j.AssertionFailedError: expected: <Bootcamp Kotlin — Semana 01> but was: <>
```

Abre `src/test/kotlin/MainTest.kt` en tu editor y localiza ese test: compara la cadena
de `assertEquals` con el mensaje.

## Paso 2: La primera línea

**Por qué**: un programa imprime en orden; la primera instrucción produce la primera
línea. El texto lleva una raya `—` (no un guion `-`): el test la compara exacta.

```kotlin
println("Bootcamp Kotlin — Semana 01")
```

**Abre `src/main/kotlin/Main.kt`**, borra la línea `TODO("Paso 2")` y quita `//> ` del
principio de la línea del Paso 2. Guarda.

**Verifica**:

```bash
./gradlew test
```

`MainTest > paso2PrintsTheTitle() PASSED`; los otros dos siguen `FAILED` porque `main`
se detiene en `TODO("Paso 3")`.

## Paso 3: Línea vacía y lista

**Por qué**: `println()` sin argumentos imprime una línea vacía, la forma de separar
bloques. Cada herramienta va en su línea para que se pueda comprobar por separado.

```kotlin
println()
println("Herramientas:")
println("- JDK 25")
println("- Kotlin 2.4.21")
println("- Gradle 9.8.2")
```

Resuelve el Paso 3 igual que el anterior.

**Verifica**: `./gradlew test` muestra `paso3PrintsTheToolList() PASSED` y solo falla
`paso4PrintsTheClosingLine()`.

## Paso 4: El cierre

```kotlin
println("Listo para la semana 02.")
```

Resuelve el Paso 4.

**Verifica**: `./gradlew test` termina en `BUILD SUCCESSFUL`, con los tres tests `PASSED`.

## Paso 5: Ejecutar

**Por qué**: los tests dicen que la salida es correcta; `run` te la enseña.

```bash
./gradlew run
```

**Verifica**: entre las líneas de Gradle (`> Task :compileKotlin UP-TO-DATE`,
`> Task :run`...) aparece la ficha completa, y al final `BUILD SUCCESSFUL`. Repite con
`-q` para ver solo la ficha:

```bash
./gradlew -q run
```

**Verifica**: exactamente siete líneas, de `Bootcamp Kotlin — Semana 01` a
`Listo para la semana 02.`.

## Paso 6: Empaquetar e instalar

**Por qué**: un programa que solo corre con `./gradlew run` no se puede entregar.
`installDist` crea una carpeta con un lanzador y todas las bibliotecas que necesita.

```bash
./gradlew build
./gradlew installDist
ls build/libs
ls build/install/first-gradle-project/bin build/install/first-gradle-project/lib
build/install/first-gradle-project/bin/first-gradle-project
```

**Verifica**:

- `build` termina en `BUILD SUCCESSFUL` (compila, prueba y empaqueta).
- `build/libs` contiene `first-gradle-project.jar`.
- `bin/` contiene `first-gradle-project` y `first-gradle-project.bat`; `lib/` contiene
  `first-gradle-project.jar`, `kotlin-stdlib-2.4.21.jar` y `annotations-13.0.jar`.
- El lanzador imprime la ficha.

## Paso 7: Ver el caché de tareas

**Por qué**: entender por qué la segunda ejecución es más rápida.

```bash
./gradlew build
./gradlew clean
./gradlew build
```

**Verifica**: el primer `build` muestra casi todas las tareas como `UP-TO-DATE` (nada
cambió). `clean` borra `build/`. El último vuelve a ejecutar `:compileKotlin` y `:test`
de verdad.

## Criterios de éxito

- [ ] `./gradlew test`: 3 de 3 tests en verde, `BUILD SUCCESSFUL`
- [ ] `./gradlew -q run` imprime exactamente las siete líneas
- [ ] Ejecutaste el lanzador de `build/install/first-gradle-project/bin/`
- [ ] Sabes explicar qué significa `UP-TO-DATE`

## Reto extra

Cambia en `Main.kt` la raya `—` del título por un guion `-` y ejecuta `./gradlew test`.
Copia el mensaje `expected/but was` y explica por qué dos textos que "se ven iguales" no
lo son. Después, devuélvelo a su estado correcto.

---

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [← Ejercicio 01 — Compilar a mano](../ejercicio-01-compilar-a-mano/README.md) | **Ejercicio 02 — Tu primer proyecto Gradle** | [Ejercicio 03 — Salida con formato →](../ejercicio-03-salida-con-formato/README.md) |
