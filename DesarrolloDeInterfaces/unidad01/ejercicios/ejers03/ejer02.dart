// Haz una función que muestre un saludo en consola. 
// El saludo debe poder llevar opcionalmente un apellido.

void main() {
  void greet([String? lastName]) {
    print("Hola ${lastName ?? ""}.");
  }

  greet();
  greet("Chugani");
}