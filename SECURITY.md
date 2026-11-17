# Política de seguridad

## Alcance

Este repositorio es material educativo. Contiene un `Dockerfile`, scripts de shell y,
desde la fase 5, un servicio HTTP con autenticación y base de datos. Un fallo de
seguridad aquí es, sobre todo, **un mal ejemplo que alguien copiará a producción**:
secretos en el código, SQL concatenado, tokens sin caducidad, contenedores como root.

## Cómo reportar

No abras un issue público. Usa
[GitHub Security Advisories](https://github.com/ergrato-dev/bc-kotlin/security/advisories/new)
con el título `[SECURITY] bc-kotlin: <resumen>`, la ruta del archivo y cómo
reproducirlo. Respuesta en un máximo de 7 días.

## Fuera de alcance

- Fallos de Kotlin, Gradle, la JVM, Ktor o Docker como productos: repórtalos a sus proyectos.
- Código de ejemplo marcado explícitamente con `// ❌` como lo que **no** se hace.
