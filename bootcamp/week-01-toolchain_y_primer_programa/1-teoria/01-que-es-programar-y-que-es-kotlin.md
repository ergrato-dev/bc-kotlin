# Teoría 01 — Qué es programar y qué es Kotlin

## 🎯 Objetivos

- Explicar con tus palabras qué es un programa, un lenguaje de programación y un compilador.
- Situar Kotlin: quién lo creó, para qué y dónde se usa.
- Saber qué vas a construir en este bootcamp y con qué herramientas.

---

## 1. Qué problema resuelve programar

Un ordenador solo hace una cosa: seguir instrucciones muy simples, muy rápido. "Suma
estos dos números", "guarda este valor en esta posición de memoria", "si este valor es
cero, salta a esta otra instrucción". Nada más. No entiende "calcula la factura del
mes" ni "avisa a los clientes con citas mañana".

**Programar** es escribir la lista de instrucciones que lleva al ordenador desde un
problema humano ("calcula la factura") hasta una respuesta. Esa lista escrita se llama
**programa**. Cuando el ordenador la sigue, decimos que el programa **se ejecuta** (en
inglés, *runs*).

### Términos que vas a leer todo el tiempo

| Término | Qué significa |
| ------- | ------------- |
| **Programa** | Lista de instrucciones que un ordenador puede seguir |
| **Código fuente** (*source code*) | El texto del programa, tal como lo escribe una persona |
| **Lenguaje de programación** | Las reglas de escritura de ese texto: qué palabras existen y cómo se combinan |
| **Sintaxis** (*syntax*) | La parte de esas reglas que dice cómo se escribe (dónde va cada paréntesis, cada comilla) |
| **Ejecutar** (*run*) | Hacer que el ordenador siga las instrucciones del programa |
| **Salida** (*output*) | Lo que el programa muestra o produce; en este bootcamp, al principio, texto en la terminal |
| **Terminal** | La ventana donde escribes comandos de texto y ves sus respuestas |

## 2. Cómo funciona: del texto a algo que el ordenador entiende

El procesador de tu ordenador no lee texto. Lee **código máquina**: números que
codifican instrucciones simples, distintos para cada tipo de procesador. Escribir
código máquina a mano es posible, pero lento y propenso a errores.

Por eso existen los lenguajes de programación: tú escribes texto legible, y un programa
especial lo **traduce**. Ese traductor se llama **compilador** (*compiler*). Compilar es
traducir el código fuente completo, de una vez, a una forma que se puede ejecutar.

```kotlin
fun main() {
    println("Hola, Kotlin")
}
```

Esto es código fuente Kotlin. Una persona lo lee así: "el programa empieza aquí
(`main`), e imprime en la terminal el texto `Hola, Kotlin`". El compilador lo traduce;
en la [Teoría 02](02-del-codigo-fuente-a-la-jvm.md) ves a qué y por qué.

Si el texto no sigue las reglas del lenguaje, el compilador **se niega a traducir** y
te dice dónde está el problema. Eso es un **error de compilación**. Parece un obstáculo,
pero es una ayuda: el compilador encuentra el fallo antes de que el programa llegue a
ejecutarse. En la [Teoría 04](04-anatomia-de-un-programa.md) aprendes a leer esos
mensajes.

## 3. Qué es Kotlin

**Kotlin** es un lenguaje de programación creado por **JetBrains**, la empresa que hace
IntelliJ IDEA. Se presentó en 2011 y su versión 1.0 salió en 2016. Hoy es de código
abierto (cualquiera puede leer y proponer cambios a su compilador) y lo mantienen
JetBrains y la Kotlin Foundation.

Se diseñó para resolver problemas concretos que los programadores tenían con Java, el
lenguaje dominante en la misma plataforma:

| Problema en el día a día | Cómo responde Kotlin |
| ------------------------ | -------------------- |
| Mucho texto repetitivo para cosas simples | Sintaxis corta: dices lo mismo con menos líneas |
| El error más frecuente en producción: usar un valor que no existe ("null") | El compilador distingue lo que puede faltar de lo que no (semana 04) |
| Código concurrente (varias tareas a la vez) difícil de escribir bien | Coroutines (semanas 18-21) |
| Reescribir la misma lógica para servidor, escritorio y web | Kotlin Multiplatform (semanas 29-31) |

Y una propiedad clave: **Kotlin funciona junto a Java**. Un programa Kotlin puede usar
cualquier biblioteca escrita en Java, y al revés. Eso le da acceso, desde el primer día,
a treinta años de herramientas ya escritas.

### Dónde se usa Kotlin

- **Backend**: servicios que responden peticiones por internet (Ktor, Spring). Lo
  construyes en la fase 5.
- **Android**: es el lenguaje recomendado por Google para Android. No es parte de este
  bootcamp; hay uno específico, `bc-android-kotlin`.
- **Multiplataforma**: lógica compartida entre JVM, escritorio, web e iOS. Fase 6.
- **Herramientas y scripts**: Gradle, la herramienta que usas desde esta semana, se
  configura en Kotlin.

## 4. Cómo se escribe: tu primera mirada al código

No hace falta que entiendas todo todavía; solo que distingas las piezas:

```kotlin
// Esto es un comentario: el compilador lo ignora. Sirve para explicar a personas.
fun main() {
    println("Bootcamp Kotlin")
    println("Semana 01")
}
```

| Pieza | Qué es |
| ----- | ------ |
| `//` | Inicio de un **comentario**: hasta el final de la línea, texto para personas |
| `fun` | Palabra reservada que declara una **función** (un bloque de instrucciones con nombre) |
| `main` | Nombre especial: la función por donde empieza el programa |
| `{` `}` | Llaves: delimitan el **cuerpo** de la función, las instrucciones que contiene |
| `println(...)` | Instrucción que imprime un texto y salta de línea |
| `"Semana 01"` | Un **string**: texto literal entre comillas dobles |

Al ejecutarlo, la terminal muestra:

```
Bootcamp Kotlin
Semana 01
```

Las instrucciones se ejecutan **en orden, de arriba abajo**. Esa es la primera regla
de cualquier programa.

## 5. Antipatrones

- ❌ **Copiar código sin ejecutarlo.** Leer un ejemplo no es entenderlo. Cada fragmento
  de este bootcamp está pensado para que lo escribas, lo ejecutes y compares la salida.
- ❌ **Ignorar los mensajes del compilador.** Un error de compilación siempre dice el
  archivo, la línea y la columna. Léelo entero antes de cambiar nada.
- ❌ **Instalar herramientas sueltas en tu máquina "por si acaso".** Todo lo que
  necesitas está en el contenedor ([Teoría 03](03-el-contenedor-de-desarrollo.md)).
  Versiones distintas producen errores distintos.

## 6. Trucos

- La documentación oficial está en [kotlinlang.org/docs](https://kotlinlang.org/docs/home.html).
  Úsala desde ya: en cada teoría hay enlaces a la página exacta.
- Si quieres probar una línea sin crear archivos, existe
  [play.kotlinlang.org](https://play.kotlinlang.org/), un editor en el navegador. Sirve
  para experimentar; los ejercicios se hacen siempre en el contenedor.

## ✅ Checklist

- [ ] Sé qué es un programa, el código fuente y un compilador
- [ ] Sé qué es un error de compilación y por qué es una ayuda
- [ ] Sé quién creó Kotlin y tres lugares donde se usa
- [ ] Reconozco `fun`, `main`, las llaves, `println` y un string en un programa

---

| Anterior | Actual | Siguiente |
| -------- | ------ | --------- |
| [← Semana 01](../README.md) | **Teoría 01 — Qué es programar y qué es Kotlin** | [Teoría 02 — Del código fuente a la JVM →](02-del-codigo-fuente-a-la-jvm.md) |
