// Constructor de fábrica (factory)

class Sesion {
  static final Sesion _instancia = Sesion._interna();

  factory Sesion() {
    return _instancia;
  }

  Sesion._interna();

  void info() {
    print('Sesión activa');
  }
}

void main() {
  Sesion s1 = Sesion();
  Sesion s2 = Sesion();

  print('¿Son iguales? ${identical(s1, s2)}');
}