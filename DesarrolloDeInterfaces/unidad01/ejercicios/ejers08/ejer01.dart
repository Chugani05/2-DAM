//  División por cero

void dividir(int a, int b) {
  // TODO: Si b es 0, lanza una excepción con throw
  if (b == 0) {
    throw Exception("División por cero");
  }
  print(a / b);
}

void main() {
  try {
    dividir(10, 0);
  } 
  // TODO: Atrapa la excepción y muestra "Error: división por cero"
  catch (e) {
    print("Error: $e");
  }
}