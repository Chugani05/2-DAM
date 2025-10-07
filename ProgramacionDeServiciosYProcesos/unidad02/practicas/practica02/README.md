# Práctica 02 - Proyecto Maven con Spring Boot

<div align="center">
    <img src="../../../../extras/vinyl.gif" alt="vinyl" width="80%">
</div>

Proyecto Maven con **Spring Boot** (JDK 17). Demuestra cómo **ejecutar y controlar procesos externos en Linux** desde Java mediante `ProcessBuilder`.

## Requisitos

- JDK 17 instalado y configurado (`java -version`).
- Maven 3.9+ (`mvn -version`).
- Linux (se usan comandos como `ls`, `ps`, `sort`, `sleep`).

## Ejecución

1. En la raíz del proyecto, compilar:

   ```bash
   mvn clean package
   ```

2. Ejecutar la aplicación directamente con Spring Boot:

   ```bash
   mvn spring-boot:run
   ```

   o bien usar el JAR generado:

   ```bash
   java -jar target/procesos-servicios-0.0.1-SNAPSHOT.jar
   ```
