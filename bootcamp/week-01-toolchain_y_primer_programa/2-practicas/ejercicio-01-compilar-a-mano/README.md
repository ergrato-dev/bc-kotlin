# Ejercicio 01 — Compilar a mano

> Al terminar habrás compilado un programa con `kotlinc`, lo habrás ejecutado con la
> JVM, habrás mirado su bytecode, lo habrás empaquetado en un JAR y habrás provocado y
> leído los errores más frecuentes.

**Duración estimada**: 2 h
**Prerrequisitos**: [Teoría 02](../../1-teoria/02-del-codigo-fuente-a-la-jvm.md),
[Teoría 03](../../1-teoria/03-el-contenedor-de-desarrollo.md) y
[Teoría 04](../../1-teoria/04-anatomia-de-un-programa.md) leídas; Docker instalado según
[`docs/setup.md`](../../../../docs/setup.md).

## Contexto

Antes de dejar que Gradle haga todo, lo haces tú a mano una vez. Así, cuando Gradle diga
`compileKotlin`, sabrás qué hay debajo. Este ejercicio no tiene tests: cada paso se
verifica comparando tu salida con la que se muestra aquí.

La carpeta `archivos/` trae `Hello.kt`. Vas a trabajar sobre una copia.

## Paso 0: Construir la imagen y entrar en el contenedor

**Por qué**: todo se compila dentro del contenedor, con las versiones del bootcamp.

En la terminal de tu máquina, desde la raíz del repositorio `bc-kotlin`:

```bash
docker build -t bc-kotlin-dev docker
```

La primera vez tarda unos minutos. Termina con una línea como
`naming to docker.io/library/bc-kotlin-dev`. Después, ve a la carpeta del ejercicio y
haz una copia de trabajo de `archivos/`:

```bash
cd bootcamp/week-01-toolchain_y_primer_programa/2-practicas/ejercicio-01-compilar-a-mano
cp -r archivos mi-copia
cd mi-copia
```

`cp -r origen destino` copia una carpeta con todo su contenido. Entra en el contenedor
(o usa el alias `kdev` de la [Teoría 03](../../1-teoria/03-el-contenedor-de-desarrollo.md)):

```bash
docker run --rm -it -v bc-kotlin-gradle:/home/ubuntu/.gradle -v "$PWD":/workspace bc-kotlin-dev
```

**Verifica**: el prompt termina en `/workspace$` y `ls` muestra `Hello.kt`.

## Paso 1: Comprobar las versiones

**Por qué**: es lo primero que se mira cuando algo falla. Si no coinciden, no estás en el
contenedor del bootcamp.

```bash
java -version
kotlinc -version
```

**Verifica**: la primera línea de `java -version` contiene `openjdk version "25`; la de
`kotlinc` dice `info: kotlinc-jvm 2.4.21`.

## Paso 2: Compilar

**Por qué**: es la traducción de `.kt` (texto) a `.class` (bytecode).

```bash
cat Hello.kt
kotlinc Hello.kt
ls
```

`cat` muestra el contenido de un archivo. `kotlinc` tarda unos segundos y no imprime nada
si todo va bien.

**Verifica**: `ls` muestra `Hello.kt  HelloKt.class  META-INF`.

## Paso 3: Ejecutar con la JVM

**Por qué**: el `.class` no se ejecuta solo; lo ejecuta la JVM.

```bash
java -cp .:/opt/kotlinc/lib/kotlin-stdlib.jar HelloKt
```

**Verifica**: imprime `Hola, Kotlin`.

Ahora el error clásico, a propósito:

```bash
java HelloKt.class
```

**Verifica**: imprime `Error: Could not find or load main class HelloKt.class`. La JVM
espera el nombre de la clase, sin `.class`.

## Paso 4: Mirar el bytecode por fuera

**Por qué**: comprobar que dentro del `.class` está tu `main`.

```bash
javap HelloKt.class
```

**Verifica**:

```
Compiled from "Hello.kt"
public final class HelloKt {
  public static final void main();
  public static void main(java.lang.String[]);
}
```

## Paso 5: Empaquetar en un JAR

**Por qué**: un solo archivo que contiene tu programa y la biblioteca estándar, y que
corre en cualquier JVM.

```bash
kotlinc Hello.kt -include-runtime -d hello.jar
ls -lh hello.jar
java -jar hello.jar
```

`ls -lh` muestra detalles del archivo con el tamaño legible (*human*).

**Verifica**: `hello.jar` pesa unos `5.5M` y `java -jar` imprime `Hola, Kotlin`.

## Paso 6: Provocar errores de compilación

**Por qué**: vas a ver estos mensajes cientos de veces. Mejor conocerlos ya, en un
programa de tres líneas.

Abre `mi-copia/Hello.kt` en tu editor (fuera del contenedor) y cambia `println` por
`printn`. Guarda y, dentro del contenedor:

```bash
kotlinc Hello.kt
```

**Verifica**:

```
Hello.kt:2:5: error: unresolved reference 'printn'.
    printn("Hola, Kotlin")
    ^^^^^^
```

Deja `println` bien escrito y quita la comilla de cierre: `println("Hola, Kotlin)`.
Compila otra vez.

**Verifica**: dos errores, ambos en `Hello.kt:2:27`: `Expecting '"'` y `Expecting ')'`.
El segundo es consecuencia del primero.

Restaura la comilla y cambia `main` por `Main`. Compila y ejecuta:

```bash
kotlinc Hello.kt
java -cp .:/opt/kotlinc/lib/kotlin-stdlib.jar HelloKt
```

**Verifica**: compila sin decir nada, y la JVM responde
`Error: Main method not found in class HelloKt`. Vuelve a escribir `main`.

## Paso 7: Provocar un error de ejecución

**Por qué**: distinguir "no compila" de "compila pero falla al ejecutarse".

Añade una línea entre `fun main() {` y el `println`, de modo que el archivo quede así:

```kotlin
fun main() {
    println(10 / 0)
    println("Hola, Kotlin")
}
```

```bash
kotlinc Hello.kt
java -cp .:/opt/kotlinc/lib/kotlin-stdlib.jar HelloKt
```

**Verifica**: al compilar, `warning: division by zero.`; al ejecutar,
`Exception in thread "main" java.lang.ArithmeticException: / by zero` y
`Hola, Kotlin` **no** se imprime. Borra la línea añadida.

## Paso 8: Un script

**Por qué**: para tareas rápidas no necesitas compilar ni escribir `main`.

Crea en `mi-copia/` el archivo `hello.main.kts`:

```kotlin
println("Hola desde un script")
println("Sin main y sin compilar a mano")
```

```bash
kotlin hello.main.kts
```

**Verifica**: imprime las dos líneas.

## Criterios de éxito

- [ ] Compilaste con `kotlinc` y ejecutaste con `java -cp` y con `java -jar`
- [ ] Viste los dos `main` con `javap`
- [ ] Provocaste y leíste los tres errores del Paso 6 y la excepción del Paso 7
- [ ] Ejecutaste un script `.main.kts`

Cuando termines, sal con `exit` y borra la copia: `rm -r mi-copia` (desde la carpeta del
ejercicio). `rm -r` borra una carpeta y todo lo que contiene, sin papelera: compruébalo
con `pwd` antes.

## Reto extra

Compila `Hello.kt` a un JAR **sin** `-include-runtime` e intenta ejecutarlo con
`java -jar`. ¿Funciona? Ahora cambia el programa para que imprima
`"Kotlin".reversed()` y repite. Explica en una frase la diferencia usando lo que viste
sobre la biblioteca estándar en la Teoría 02.

---

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [← Teoría 06 — Qué es un test](../../1-teoria/06-que-es-un-test.md) | **Ejercicio 01 — Compilar a mano** | [Ejercicio 02 — Tu primer proyecto Gradle →](../ejercicio-02-primer-proyecto-gradle/README.md) |
