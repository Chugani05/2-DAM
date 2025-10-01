// Ejercicio con clase abstracta

abstract class InstrumentoMusical {
  void tocar();
}

class Guitarra extends InstrumentoMusical {
  @override
  void tocar() {
    print('Tocando la guitarra.');
  }
}

class Piano extends InstrumentoMusical {
  @override
  void tocar() {
    print('Tocando el piano.');
  }
}

void main() {
  List<InstrumentoMusical> instrumentos = [Guitarra(), Piano()];

  for (var instrumento in instrumentos) {
    instrumento.tocar();
  }
}