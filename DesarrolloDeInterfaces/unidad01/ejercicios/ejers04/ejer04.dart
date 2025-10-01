// Constructor con parámetros nombrados ({})

class Mensaje {
  String texto;
  String prioridad;

  Mensaje({required this.texto, this.prioridad = 'normal'});
}

void main() {
  Mensaje m1 = Mensaje(texto: 'Revisar informe');
  Mensaje m2 = Mensaje(texto: 'Pagar el alquiler', prioridad: 'alto');

  print('Mensaje 1: ${m1.texto}, Prioridad: ${m1.prioridad}');
  print('Mensaje 2: ${m2.texto}, Prioridad: ${m2.prioridad}');
}