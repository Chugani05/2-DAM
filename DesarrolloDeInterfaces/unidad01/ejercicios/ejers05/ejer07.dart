// Ejercicio con clase const

class ColorRGB {
  final int r;
  final int g;
  final int b;

  const ColorRGB(this.r, this.g, this.b);
}

void main() {
  const color1 = ColorRGB(255, 0, 0);
  const color2 = ColorRGB(255, 0, 0);

  print('¿Son iguales? ${identical(color1, color2)}');
}