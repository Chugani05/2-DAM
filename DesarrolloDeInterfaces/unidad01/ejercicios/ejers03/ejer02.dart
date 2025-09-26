// Función con saludo y opción de apellido

void main() {
  void greet([String? lastName]) {
    print("Hola ${lastName ?? ""}.");
  }

  greet();
  greet("Chugani");
}