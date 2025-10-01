// Ejercicio con extends

class Empleado {
  String nombre;

  Empleado(this.nombre);

  void trabajar() {
    print('$nombre está trabajando.');
  }
}

class Programador extends Empleado {
  Programador(String nombre) : super(nombre);

  @override
  void trabajar() {
    print('Estoy programando en Dart.');
  }
}

void main() {
  var prog = Programador('Juan');
  prog.trabajar();
}