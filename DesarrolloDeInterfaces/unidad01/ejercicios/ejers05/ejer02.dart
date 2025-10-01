// Ejercicio con setter

class Contrasenia {
  String _valor = '';

  set valor(String nuevaContrasenia) {
    if (nuevaContrasenia.length >= 8) {
      _valor = nuevaContrasenia;
      print('Contraseña guardada.');
    } else {
      print('Error: La contraseña debe tener al menos 8 caracteres.');
    }
  }

  String get valor => _valor;
}

void main() {
  var contra = Contrasenia();

  contra.valor = '1234567';
  contra.valor = '12345678';
  print('Contraseña actual: ${contra.valor}');
}