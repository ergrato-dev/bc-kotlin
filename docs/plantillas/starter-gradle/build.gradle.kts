// ¿Qué? Build mínimo de un ejercicio: Kotlin/JVM + kotlin-test sobre JUnit Platform.
// ¿Para qué? Que `./gradlew test` compile y ejecute los tests del ejercicio sin configurar nada.
// ¿Impacto? allWarningsAsErrors convierte cada warning en error: el código sale limpio desde el día uno.
plugins {
    kotlin("jvm") version "2.4.21"
    application
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

kotlin {
    jvmToolchain(25)
    compilerOptions {
        allWarningsAsErrors.set(true)
    }
}

application {
    mainClass.set("MainKt")
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events("passed", "failed")
        exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.SHORT
    }
}
