// Isolate con múltiples mensajes

import 'dart:isolate';

void main() async {
  final receivePort = ReceivePort();

  await Isolate.spawn(isolateFunction, receivePort.sendPort);

  await for (var message in receivePort) {
    print('Mensaje recibido: $message');

    if (message == 'Fin') {
      receivePort.close();
      break;
    }
  }
}

void isolateFunction(SendPort sendPort) {
  sendPort.send('Inicio');
  sendPort.send('Procesando...');
  sendPort.send('Fin');
}