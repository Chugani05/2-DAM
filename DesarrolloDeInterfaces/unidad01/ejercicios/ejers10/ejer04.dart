// try/catch con async/await

Future<int> dividir(int a, int b) async {
  if (b == 0) {
    throw Exception("División por cero");
  }
  return a ~/ b;
}

void main() async {
  try {
    int resultado = await dividir(10, 0);
    print("Resultado: $resultado");
  } catch (e) {
    print("Error: $e");
  }
}