// Uso de `compute` en Flutter

import 'package:flutter/foundation.dart';

// Función que convierte un texto grande a minúsculas
String convertirAMinusculas(String texto) {
  // Aquí puede ser una operación costosa
  return texto.toLowerCase();
}

// Dentro de un widget o función asíncrona
void procesarTexto() async {
  String textoGrande = "Este Es Un Texto Muy Largo Que Necesitamos Convertir...";
  
  // Usamos compute para procesar en un hilo aparte
  String textoEnMinusculas = await compute(convertirAMinusculas, textoGrande);
  
  // Aquí podemos actualizar la UI con el resultado
  print(textoEnMinusculas);
}