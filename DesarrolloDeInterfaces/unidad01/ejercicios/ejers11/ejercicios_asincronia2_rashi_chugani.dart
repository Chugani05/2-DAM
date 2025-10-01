// ============================
// Ejercicio 1
// ============================

import 'dart:async';

void main() async {
  final temperatureStream = Stream<int>.periodic(
    Duration(milliseconds: 500),
    (count) => 20 + count,
  ).take(5);

  await for (var temp in temperatureStream) {
    print('Temperatura: $temp°C');
    if (temp > 22) {
      print('⚠️ ¡Temperatura alta!');
    }
  }

  print('✅ Sensor apagado');
}


// ============================
// Ejercicio 2
// ============================

import 'dart:async';

void main() {
  final chatController = StreamController<String>.broadcast();

  chatController.add("Hola");
  chatController.add("¿Cómo estás?");
  chatController.add("Adiós");

  chatController.stream.listen((msg) {
    print('Suscriptor 1 recibe: $msg');
  });

  chatController.stream.listen((msg) {
    print('Suscriptor 2 recibe: $msg');
  });

  Future.delayed(Duration(seconds: 1), () {
    chatController.close();
  });
}


// ============================
// Ejercicio 3
// ============================

import 'dart:async';

void main() {
  final numeros = Stream<int>.fromIterable([1, 2, 3, 4, 5]);

  numeros
      .where((n) => n.isEven)
      .map((n) => n * 10)
      .listen((n) => print(n));
}


// ============================
// Ejercicio 4
// ============================

import 'dart:async';

void main() {
  final controller = StreamController<String>();

  controller.stream.listen(
    (data) => print('Recibido: $data'),
    onError: (error) => print('❌ Error detectado: $error'),
    onDone: () => print('Stream cerrado'),
  );

  controller.add('dato1');
  controller.add('dato2');
  controller.addError('fallo de red');
  controller.add('dato3');

  Future.delayed(Duration(seconds: 1), () => controller.close());
}


// ============================
// Ejercicio 5
// ============================

import 'dart:async';

void main() {
  int contador = 1;
  final stream = Stream.periodic(Duration(seconds: 1), (count) => 'tick $count');

  late StreamSubscription subscription;

  subscription = stream.listen((tick) {
    print(tick);
    if (++contador > 3) {
      subscription.cancel();
      print('Suspensión automática después de 3 ticks');
    }
  });
}


// ============================
// Ejercicio 6
// ============================

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


// ============================
// Ejercicio 7
// ============================

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


// ============================
// Ejercicio 8
// ============================

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


// ============================
// Ejercicio 9
// ============================

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


// ============================
// Ejercicio 10
// ============================


