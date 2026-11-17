# 🛠️ Preparar el entorno

Necesitas **Docker** y **git**. Nada más: el JDK, el compilador de Kotlin y Gradle viven
dentro de un contenedor con las versiones exactas del bootcamp
([`stack-versions.md`](stack-versions.md)). Así, si un ejercicio funciona en tu máquina,
funciona en la corrección.

La semana 01 explica cada pieza paso a paso. Aquí está la referencia rápida.

## 1. Instalar Docker

- **Linux (Ubuntu/Debian)**: sigue la guía oficial
  [docs.docker.com/engine/install/ubuntu](https://docs.docker.com/engine/install/ubuntu/)
  y añade tu usuario al grupo `docker` (`sudo usermod -aG docker $USER`, cierra sesión
  y vuelve a entrar).
- **Windows**: instala WSL2 con Ubuntu 24.04 y Docker Desktop con integración WSL2.
  Trabaja siempre dentro de la terminal de Ubuntu, nunca en `C:\`.
- **macOS**: Docker Desktop.

Comprueba:

```bash
docker run --rm hello-world
```

Debe imprimir `Hello from Docker!`.

## 2. Clonar el bootcamp y construir la imagen

```bash
git clone https://github.com/ergrato-dev/bc-kotlin.git
cd bc-kotlin
docker build -t bc-kotlin-dev docker
```

Tarda unos minutos la primera vez. Comprueba:

```bash
docker run --rm bc-kotlin-dev kotlinc -version
```

Debe imprimir `info: kotlinc-jvm 2.4.21 (JRE 25...)`.

## 3. Trabajar dentro del contenedor

Desde la raíz del repositorio:

```bash
docker run --rm -it \
  -v bc-kotlin-gradle:/home/ubuntu/.gradle \
  -v "$PWD":/workspace \
  bc-kotlin-dev
```

| Opción | ¿Qué hace? | ¿Para qué? |
| ------ | ---------- | ---------- |
| `--rm` | Borra el contenedor al salir | No acumular contenedores parados |
| `-it` | Terminal interactiva | Escribir comandos dentro |
| `-v bc-kotlin-gradle:/home/ubuntu/.gradle` | Volumen con el caché de Gradle | Gradle y las dependencias se descargan una sola vez |
| `-v "$PWD":/workspace` | Monta tu carpeta actual dentro | Editas con tu editor fuera; compilas dentro |

Dentro, el prompt es `ubuntu@...:/workspace$`. Para salir: `exit`.

Atajo recomendado (añádelo a tu `~/.bashrc` o `~/.zshrc`):

```bash
alias kdev='docker run --rm -it -v bc-kotlin-gradle:/home/ubuntu/.gradle -v "$PWD":/workspace bc-kotlin-dev'
```

## 4. Editor

Cualquier editor sirve. Recomendado: **IntelliJ IDEA Community** (gratuito, de
JetBrains, los creadores de Kotlin) abriendo la carpeta `starter/` de cada ejercicio, o
VS Code con la extensión oficial *Kotlin* de JetBrains. Compilar y probar se hace siempre
con `./gradlew` dentro del contenedor: es lo que cuenta en la evaluación.

## Problemas frecuentes

| Síntoma | Causa | Arreglo |
| ------- | ----- | ------- |
| `permission denied while trying to connect to the Docker daemon` | Tu usuario no está en el grupo `docker` | `sudo usermod -aG docker $USER` y vuelve a iniciar sesión |
| `./gradlew: Permission denied` | El archivo perdió el permiso de ejecución | `chmod +x gradlew` |
| `Could not create parent directory for lock file` | El volumen del caché se creó con otra imagen | `docker volume rm bc-kotlin-gradle` y vuelve a lanzar |
| Archivos de `build/` con dueño `root` | Lanzaste el contenedor con `--user root` | No uses `--user`; la imagen ya usa `ubuntu` (UID 1000) |
