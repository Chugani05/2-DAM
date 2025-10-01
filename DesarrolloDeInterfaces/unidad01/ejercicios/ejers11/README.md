# Ejercicios de asincronía (parte 2)

<div align="center">
    <img src="../../../../extras/vinyl.gif" alt="vinyl" width="80%">
</div>

## Contenidos
- [Ejercicios de Streams](#ejercicios-de-streams)
    - [Stream de sensores de temperatura](#stream-de-sensores-de-temperatura)
    - [Stream broadcast de mensajes de chat](#stream-broadcast-de-mensajes-de-chat)
    - [Transformaciones de stream de números](#transformaciones-de-stream-de-números)
    - [Manejo de errores en streams](#manejo-de-errores-en-streams)
    - [Stream periódico con cancelación](#stream-periódico-con-cancelación)
- [Ejercicios de Isolates](#ejercicios-de-isolates)
    - [Suma grande con isolate](#suma-grande-con-isolate)
    - [Factorial en un isolate](#factorial-en-un-isolate)
    - [Isolate con lista de nombres](#isolate-con-lista-de-nombres)
    - [Isolate con múltiples mensajes](#isolate-con-múltiples-mensajes)
    - [Uso de `compute` en Flutter](#uso-de-compute-en-flutter)

---

## Ejercicios de Streams

### Stream de sensores de temperatura

- Crea un `Stream<int>` que emita lecturas de temperatura cada medio segundo: `[20, 21, 22, 23, 24]`.
- Si la temperatura supera 22, imprime `"⚠️ ¡Temperatura alta!"`.
- Al terminar, imprime `"✅ Sensor apagado"`.

```dart
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
```

---

### Stream broadcast de mensajes de chat

- Simula un chat con un `StreamController.broadcast()`.
- Envía tres mensajes: `"Hola"`, `"¿Cómo estás?"`, `"Adiós"`.
- Suscríbete con dos oyentes distintos y comprueba que ambos reciben los mismos mensajes.

```dart
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
```

---

### Transformaciones de stream de números

- Crea un `Stream<int>` con los números del 1 al 5.
- Filtra solo los números pares (`where`).
- Transfórmalos multiplicándolos por 10 (`map`).
- Imprime el resultado.

```dart
import 'dart:async';

void main() {
  final numeros = Stream<int>.fromIterable([1, 2, 3, 4, 5]);

  numeros
      .where((n) => n.isEven)
      .map((n) => n * 10)
      .listen((n) => print(n));
}
```

---

### Manejo de errores en streams

- Crea un `StreamController<String>`.
- Emite `"dato1"`, `"dato2"`, luego un error `"fallo de red"`, y finalmente `"dato3"`.
- Suscríbete e imprime los datos normales con `"Recibido: ..."` pero los errores con `"❌ Error detectado: ..."`.
- Cuando se cierre, imprime `"Stream cerrado"`.

```dart
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
```

---

### Stream periódico con cancelación

- Crea un `Stream.periodic` que emita `"tick 1"`, `"tick 2"`, etc., cada segundo.
- Cancela la suscripción automáticamente después de recibir 3 ticks.

```dart
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
```

---

## Ejercicios de Isolates

### Suma grande con isolate

- Usa un `Isolate` para calcular la suma de los números del 1 al 1.000.000.
- El isolate devuelve el resultado.
- El `main` imprime `"Resultado recibido: ..."` al recibirlo.

```dart
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
```

---

### Factorial en un isolate

- Define una función que calcule el factorial de un número.
- Lanza un `isolate` que reciba un número (ejemplo 5).
- Devuelve el factorial (`120`).

```dart
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
```

---

### Isolate con lista de nombres

- Envía una lista de nombres a un `isolate`.
- El `isolate` convierte todos los nombres a mayúsculas.
- Devuelve la lista al `main`.

```dart
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
```

---

### Isolate con múltiples mensajes

- Crea un `isolate` que reciba un `SendPort`.
- Envía tres mensajes diferentes al `main`: `"Inicio"`, `"Procesando..."`, `"Fin"`.
- El `main` imprime cada mensaje según llega.

```dart
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
```

---

### Uso de `compute` en Flutter

- Imagina que tienes una función que convierte un texto grande a minúsculas.
- Simula cómo usarías `compute(miFuncion, texto)` en Flutter para no bloquear la UI.
- No hace falta código completo de Flutter, solo el patrón con `compute`.

```dart

```