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