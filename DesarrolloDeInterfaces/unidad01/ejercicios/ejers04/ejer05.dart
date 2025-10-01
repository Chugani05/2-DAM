// Constructor const

class Moneda {
  final String codigo;
  final String simbolo;

  const Moneda(this.codigo, this.simbolo);
}

void main() {
  const moneda1 = Moneda('USD', '\$');
  const moneda2 = Moneda('USD', '\$');

  print('¿Son iguales? ${identical(moneda1, moneda2)}');
}
