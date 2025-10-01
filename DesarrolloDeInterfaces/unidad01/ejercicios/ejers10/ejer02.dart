// then() encadenados

void main() {
  Future<int>.value(5)
      .then((valor) => valor * 2)
      .then((valor) => valor + 10)
      .then((resultado) => print("Resultado final: $resultado"));
}