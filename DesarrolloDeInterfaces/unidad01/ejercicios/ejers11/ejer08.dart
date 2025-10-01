// Isolate con lista de nombres

import 'dart:isolate';

void main() async {
  final receivePort = ReceivePort();

  await Isolate.spawn(transformNames, [receivePort.sendPort, ['ana', 'juan', 'maria']]);

  final result = await receivePort.first;
  print('Nombres en mayúsculas: $result');
}

void transformNames(List<dynamic> args) {
  SendPort sendPort = args[0];
  List<String> names = args[1];

  final upperNames = names.map((n) => n.toUpperCase()).toList();
  sendPort.send(upperNames);
}