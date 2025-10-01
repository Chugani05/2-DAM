// finally con async/await

Future<void> cargarArchivo() async {
  await Future.delayed(Duration(seconds: 1));
  throw Exception("Archivo no encontrado");
}

void main() async {
  try {
    await cargarArchivo();
  } catch (e) {
    print("Error: $e");
  } finally {
    print("Proceso terminado");
  }
}