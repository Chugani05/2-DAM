//  Índice fuera de rango

void main() {
  var lista = [1, 2, 3];

  try {
    print(lista[5]); // ❌ Esto da error
  } 
  // TODO: Usa on RangeError para capturar este error en específico
  on RangeError catch (e) {
    print("Error: índice fuera de rango");
  }
}