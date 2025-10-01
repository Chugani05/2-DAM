// Suma grande con isolate

import 'dart:isolate';

void main() async {
  final receivePort = ReceivePort();

  await Isolate.spawn(suma, receivePort.sendPort);

  final result = await receivePort.first;
  print('Resultado recibido: $result');
}

void suma(SendPort sendPort) {
  int total = 0;
  for (int i = 1; i <= 1000000; i++) {
    total += i;
  }
  sendPort.send(total);
}