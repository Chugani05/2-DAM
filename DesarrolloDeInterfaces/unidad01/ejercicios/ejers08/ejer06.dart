// Async y manejo de errores

Future<void> cargarDatos() async {
  await Future.delayed(Duration(seconds: 1));
  // TODO: Lanza una excepción aquí simulando un fallo de conexión
  throw Exception("Fallo de conexión");
}

void main() async {
  try {
    await cargarDatos();
  } 
  // TODO: Atrapa el error y muestra "Error: no se pudieron cargar los datos"
  catch (e) {
    print("Error: no se pudieron cargar los datos");
  }
}