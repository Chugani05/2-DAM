// Reintentos en conexión simulada

import 'dart:math';

Future<void> conectar() async {
  final random = Random();
  if (random.nextBool()) {
    throw Exception("Fallo de red");
  }
}

Future<void> intentarConectar() async {
  int intentos = 0;
  const maxIntentos = 3;

  while (intentos < maxIntentos) {
    try {
      await conectar();
      print("Conexión exitosa");
      return;
    } catch (e) {
      intentos++;
      print("Intento ${intentos}: Error - $e");
      if (intentos >= maxIntentos) {
        throw Exception("Conexión fallida tras $intentos intentos");
      }
    }
  }
}

void main() async {
  try {
    await intentarConectar();
  } catch (e) {
    print("Error final: $e");
  }
}