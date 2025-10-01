// Excepción personalizada

// TODO: Crea una clase DivisionPorCeroException que implemente Exception
//       y sobrescriba toString() para mostrar "🚫 División prohibida"

class DivisionPorCeroException implements Exception {
  @override
  String toString() => "🚫 División prohibida";
}

void dividir(int a, int b) {
  // TODO: Lanza tu excepción personalizada si b == 0
  if (b == 0) {
    throw DivisionPorCeroException();
  }
  print(a / b);
}

void main() {
  try {
    dividir(8, 0);
  } 
  // TODO: Atrapa tu excepción personalizada y muéstrala
  catch (e) {
    print(e);
  }
}