// Constructor con inicialización (:)

class Circulo {
  double radio;
  double area;

  Circulo(this.radio) : area = 3.1416 * radio * radio;
}

void main() {
  Circulo c = Circulo(5);
  print('Radio: ${c.radio}, Área: ${c.area}');
}