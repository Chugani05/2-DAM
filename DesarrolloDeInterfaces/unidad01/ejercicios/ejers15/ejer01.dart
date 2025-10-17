import 'dart:isolate';

void main() async {
  final receivePort = ReceivePort();

  final numeros = [5, 10, 15, 20, 25];

  await Isolate.spawn(calcularSuma, [numeros, receivePort.sendPort]);

  final resultado = await receivePort.first;

  print('✅ Suma total: $resultado');

  receivePort.close();
}

void calcularSuma(List<dynamic> args) {
  final numeros = args[0] as List<int>;
  final sendPort = args[1] as SendPort;

  final suma = numeros.reduce((a, b) => a + b);

  sendPort.send(suma);
}
