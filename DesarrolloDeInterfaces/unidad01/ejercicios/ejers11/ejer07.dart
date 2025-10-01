// Factorial en un isolate

import 'dart:isolate';

void main() async {
  final receivePort = ReceivePort();

  await Isolate.spawn(factorialIsolate, [receivePort.sendPort, 5]);

  final result = await receivePort.first;
  print('Factorial: $result');
}

void factorialIsolate(List<dynamic> args) {
  SendPort sendPort = args[0];
  int n = args[1];

  int factorial(int num) => num <= 1 ? 1 : num * factorial(num - 1);

  sendPort.send(factorial(n));
}