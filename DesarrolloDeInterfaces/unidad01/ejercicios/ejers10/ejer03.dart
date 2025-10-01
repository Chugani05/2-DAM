// Manejo de errores con catchError

Future<void> fallo() async {
  throw Exception("Error en la carga");
}

void main() {
  fallo().catchError((error) {
    print("❌ Error atrapado: $error");
  });
}