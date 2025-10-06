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