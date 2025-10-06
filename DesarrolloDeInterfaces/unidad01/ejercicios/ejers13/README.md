# Cuestionario sobre asincronía: Future

<div align="center">
    <img src="../../../../extras/vinyl.gif" alt="vinyl" width="80%">
</div>

## Tabla de contenidos

- [LECTURA DE ARCHIVOS](#lectura-de-archivos)
- [TESTEAR CONEXIÓN](#testear-conexión)
- [ESCRIBIR UN REGISTRO](#escribir-un-registro)

## LECTURA DE ARCHIVOS

- Crea un programa que lea el contenido del archivo `datos.txt` y lo muestre por pantalla.
- Si el archivo no existe, muestra un mensaje de error.
- Usa `await` y marca la función `main` como `async`.

```dart
import 'dart:io';

Future<void> main() async {
  final file = File('datos.txt');

  try {
    // Lee el contenido del archivo con readAsString()
    String contenido = await file.readAsString();
    // Muestra el contenido por pantalla
    print(contenido);
  } catch (e) {
    // Si ocurre un error (como que el archivo no existe), muestra un mensaje
    print('Error al leer el archivo: $e');
  }
}
```

## TESTEAR CONEXIÓN

- Intenta resolver el dominio `google.com`.
- Si se resuelve, muestra “✅ Conectado a Internet”.
- Si falla, muestra “❌ Sin conexión a Internet”.
- Usa `try-catch` para capturar errores `SocketException`.

```dart
import 'dart:io';

Future<void> main() async {
  print('Comprobando conexión a Internet...');

  try {
    final result = await InternetAddress.lookup('google.com');

    if (result.isNotEmpty) {
      print('✅ Conectado a Internet');
    } else {
      print('❌ Sin conexión a Internet');
    }
  } on SocketException catch (_) {
    print('❌ Sin conexión a Internet');
  }
}
```

## ESCRIBIR UN REGISTRO

- Crea un archivo llamado `registro.txt`.
- Cada vez que ejecutes el programa, añade una línea con la fecha y hora actuales.
- No sobrescribas el contenido previo (usa el modo `append`).
- Muestra el mensaje “Registro guardado correctamente.” al terminar.

```dart
import 'dart:io';

Future<void> main() async {
  final file = File('registro.txt');
  final fecha = DateTime.now();

  try {
    // Escribe la fecha en el archivo en modo append
    await file.writeAsString('$fecha\n', mode: FileMode.append);
    // Muestra mensaje de confirmación
    print('Registro guardado correctamente.');
  } catch (e) {
    print('Error al guardar el registro: $e');
  }
}
```