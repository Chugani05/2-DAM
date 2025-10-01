// `Future.any` con el primero que termine

Future<String> lenta() async {
  await Future.delayed(Duration(seconds: 2));
  return "Lenta";
}

Future<String> rapida() async {
  await Future.delayed(Duration(seconds: 1));
  return "Rápida";
}

void main() async {
  String primero = await Future.any([lenta(), rapida()]);
  print("Primero: $primero");
}