# Práctica 01 - Empezando proyecto Maven

<div align="center">
    <img src="../../../../extras/vinyl.gif" alt="vinyl" width="80%">
</div>

## Comandos y pasos básicos

1. **Instalar Maven**

   ```bash
   sudo apt-get install maven
   ```

2. **Instalar Java** (JDK recomendado, no solo el JRE):

   ```bash
   sudo apt-get install default-jdk
   ```

3. **Instalar extensiones en VS Code**

   * *Extension Pack for Java*
   * *Maven for Java*
   * *Debugger for Java*

4. **Crear un proyecto Maven en Java**

   * Desde la terminal:

     ```bash
     mvn archetype:generate -DgroupId=com.ejemplo -DartifactId=mi-proyecto -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
     ```
   * O desde VS Code: clic derecho en el panel de archivos → *Create Maven Project*.

5. **Configurar `.gitignore`**

   * Crear un archivo `.gitignore` en la raíz del proyecto.
   * Buscar en internet un ejemplo de `.gitignore` para proyectos Maven o usar este básico:

     ```
     /target/
     *.log
     *.class
     .idea/
     .vscode/
     ```

6. **Estructura de carpetas Maven**
   El código fuente debe ir en:

   ```
   src/main/java   → código fuente principal
   src/test/java   → pruebas unitarias
   ```