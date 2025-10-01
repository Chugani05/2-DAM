//  Conversor de números con validación

int toIntSeguro(String valor) {
  try {
    return int.parse(valor);
  } catch (e) {
    throw FormatException("Valor inválido: $valor");
  }
}

void main() {
  List<String> valores = ["123", "abc", "45"];

  for (var valor in valores) {
    try {
      int numero = toIntSeguro(valor);
      print("Conversión exitosa: $valor -> $numero");
    } on FormatException catch (e) {
      print("Error: ${e.message}");
    }
  }
}