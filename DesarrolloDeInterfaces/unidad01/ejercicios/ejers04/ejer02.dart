// Constructor nombrado

class Tarea {
  String descripcion;
  bool completada;

  Tarea(this.descripcion, this.completada);

  Tarea.incompleta(this.descripcion) : completada = false;
}

void main() {
  Tarea tarea1 = Tarea('Lavar los platos', true);
  Tarea tarea2 = Tarea.incompleta('Hacer la tarea');

  print('Tarea 1: ${tarea1.descripcion}, Completada: ${tarea1.completada}');
  print('Tarea 2: ${tarea2.descripcion}, Completada: ${tarea2.completada}');
}