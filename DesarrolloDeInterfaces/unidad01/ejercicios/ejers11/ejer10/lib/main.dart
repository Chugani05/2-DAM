// Uso de `compute` en Flutter

import 'package:flutter/foundation.dart';

String convertirAMinusculas(String texto) {
  return texto.toLowerCase();
}

void procesarTexto() async {
  String textoGrande = "Este Es Un Texto Muy Largo Que Necesitamos Convertir...";
  String textoEnMinusculas = await compute(convertirAMinusculas, textoGrande);
  print(textoEnMinusculas);
}