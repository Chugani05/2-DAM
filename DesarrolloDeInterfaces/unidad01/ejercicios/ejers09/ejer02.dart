//  Suma de lista segura

class ElementoNoEnteroException implements Exception {
  final dynamic elemento;
  ElementoNoEnteroException(this.elemento);

  @override
  String toString() => 'Elemento no entero: $elemento';
}

int sumarLista(List<dynamic> datos) {
  int suma = 0;
  for (var elemento in datos) {
    if (elemento is int) {
      suma += elemento;
    } else {
      throw ElementoNoEnteroException(elemento);
    }
  }
  return suma;
}

void main() {
  List<dynamic> datos = [10, 20, "hola", 5];

  try {
    int resultado = sumarLista(datos);
    print("Suma total: $resultado");
  } on ElementoNoEnteroException catch (e) {
    print("Error: $e");
  }
}