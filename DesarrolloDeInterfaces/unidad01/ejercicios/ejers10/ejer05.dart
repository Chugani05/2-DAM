// Esperar múltiples futuros con `Future.wait`

Future<String> tarea1() async {
  await Future.delayed(Duration(seconds: 1));
  return "Tarea 1";
}

Future<String> tarea2() async {
  await Future.delayed(Duration(seconds: 2));
  return "Tarea 2";
}

Future<String> tarea3() async {
  await Future.delayed(Duration(seconds: 3));
  return "Tarea 3";
}

void main() async {
  List<String> resultados = await Future.wait([
    tarea1(),
    tarea2(),
    tarea3(),
  ]);
  print("Resultados: $resultados");
}