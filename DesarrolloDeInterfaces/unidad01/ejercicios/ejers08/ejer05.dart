// Excepción personalizada

// TODO: Crea una clase DivisionPorCeroException que implemente Exception
//       y sobrescriba toString() para mostrar "🚫 División prohibida"

void dividir(int a, int b) {
  // TODO: Lanza tu excepción personalizada si b == 0
  print(a / b);
}

void main() {
  try {
    dividir(8, 0);
  } 
  // TODO: Atrapa tu excepción personalizada y muéstrala
}