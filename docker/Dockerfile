# ¿Qué? Imagen de desarrollo del bootcamp: Ubuntu 24.04 + JDK 25 + compilador Kotlin.
# ¿Para qué? Que todos los aprendices compilen con las mismas versiones, sin instalar nada en su máquina.
# ¿Impacto? Si un ejercicio funciona aquí, funciona en la corrección. Gradle no se instala:
#           cada proyecto trae su wrapper (./gradlew) y descarga la versión fijada.
FROM ubuntu:24.04

ARG KOTLIN_VERSION=2.4.21

ENV DEBIAN_FRONTEND=noninteractive \
    LANG=C.UTF-8 \
    PATH=/opt/kotlinc/bin:$PATH

RUN apt-get update \
    && apt-get install -y --no-install-recommends \
        openjdk-25-jdk-headless ca-certificates curl unzip git \
    && rm -rf /var/lib/apt/lists/*

# ¿Qué? kotlinc oficial desde el release de GitHub de JetBrains.
# ¿Para qué? La semana 01 compila a mano, sin Gradle, para ver qué hace el compilador.
RUN curl -fsSL -o /tmp/kotlinc.zip \
        "https://github.com/JetBrains/kotlin/releases/download/v${KOTLIN_VERSION}/kotlin-compiler-${KOTLIN_VERSION}.zip" \
    && unzip -q /tmp/kotlinc.zip -d /opt \
    && rm /tmp/kotlinc.zip

# ¿Qué? Usuario sin privilegios `ubuntu` (UID 1000), que ya trae la imagen base.
# ¿Impacto? Los archivos que crea Gradle en el volumen montado no quedan como root.
# ¿Qué? Carpeta del caché de Gradle creada de antemano con dueño `ubuntu`.
# ¿Impacto? Un volumen montado ahí hereda ese dueño y Gradle puede escribir su caché.
RUN mkdir -p /home/ubuntu/.gradle && chown ubuntu:ubuntu /home/ubuntu/.gradle
USER ubuntu
WORKDIR /workspace

CMD ["bash"]
