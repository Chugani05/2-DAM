// Cargar datos con `.catchError()`

Future<String> cargarArchivo(String nombre) {
  if (nombre == "config.txt") {
    return Future.value("Archivo cargado");
  } else {
    return Future.error("Archivo no encontrado");
  }
}

void main() {
  cargarArchivo("datos.txt").then((mensaje) {
    print(mensaje);
  }).catchError((e) {
    print("Error: $e");
  });
}