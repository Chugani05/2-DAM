// Ejercicio con mixin

mixin Recargable {
  void recargar() {
    print('Recargando...');
  }
}

class Telefono with Recargable {
  void usar() {
    print('Usando teléfono.');
  }
}

class Linterna with Recargable {
  void iluminar() {
    print('Iluminando con la linterna.');
  }
}

void main() {
  var telefono = Telefono();
  var linterna = Linterna();

  telefono.recargar();
  linterna.recargar();
}