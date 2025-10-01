// Future básico con retraso

Future<String> holaFuture() async {
  await Future.delayed(Duration(seconds: 2));
  return "Hola desde el futuro";
}

void main() async {
  String saludo = await holaFuture();
  print(saludo);
}