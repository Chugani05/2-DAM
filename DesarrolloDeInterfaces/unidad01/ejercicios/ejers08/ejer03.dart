// Formato inválido

void main() {
  try {
    var numero = int.parse("abc"); // ❌ Esto da FormatException
    print(numero);
  } 
  // TODO: Usa on FormatException y muestra un mensaje claro
  on FormatException catch (e) {
    print("Error: formato inválido");
  }
}