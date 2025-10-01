// Constructor con redirección

class Alumno {
  String nombre;
  double nota;

  Alumno(this.nombre, this.nota);

  Alumno.aprobado(this.nombre) : nota = 5.0;
}

void main() {
  Alumno alumno1 = Alumno('Carlos', 8.5);
  Alumno alumno2 = Alumno.aprobado('Ana');

  print('Alumno 1: ${alumno1.nombre}, Nota: ${alumno1.nota}');
  print('Alumno 2: ${alumno2.nombre}, Nota: ${alumno2.nota}');
}