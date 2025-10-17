# Cuestionario sobre paralelismo: Isolate

<div align="center">
    <img src="../../../../extras/vinyl.gif" alt="vinyl" width="80%">
</div>

## Tabla de contenidos
- [CÁLCULO EN PARALELO](#sensor-de-humedad)
- [STREAM + ISOLATE: GENERAR Y PROCESAR DATOS](#contador-de-segundos)

## CÁLCULO EN PARALELO

- Crea un programa que calcule la suma de una lista de números usando un **isolate**.
- El isolate debe recibir una lista de enteros y devolver la suma total al programa principal.
- El programa principal debe mostrar el resultado con el mensaje: ✅ `Suma total: X`
- Usa `Isolate.spawn()` para crear el isolate.

```dart
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
```

## STREAM + ISOLATE: GENERAR Y PROCESAR DATOS

- Crea un isolate que genere números aleatorios entre 1 y 100 cada 500 ms.
- El isolate enviará cada número al proceso principal mediante su `SendPort`.
- En el programa principal, recibe los datos como un `Stream` y muéstralos con el formato: 🔢 `Valor recibido: X`
- Después de recibir 10 valores, el programa debe mostrar ✅ `Transmisión finalizada`. y cerrar todo.

```dart
import 'dart:async';
import 'dart:isolate';
import 'dart:math';

void main() async {
  final receivePort = ReceivePort();

  await Isolate.spawn(generarNumeros, receivePort.sendPort);

  final stream = receivePort.asBroadcastStream();
  int count = 0;

  late StreamSubscription subscription;

  subscription = stream.listen((valor) {
    count++;
    print('🔢 Valor recibido: $valor');

    if (count >= 10) {
      print('✅ Transmisión finalizada.');
      subscription.cancel();
      receivePort.close();
    }
  });
}

void generarNumeros(SendPort sendPort) {
  final random = Random();
  int enviados = 0;

  Timer.periodic(Duration(milliseconds: 500), (timer) {
    enviados++;
    sendPort.send(random.nextInt(100) + 1);

    if (enviados >= 10) {
      timer.cancel();
    }
  });
}
```
