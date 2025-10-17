# Cuestionario sobre asincronía: Stream

<div align="center">
    <img src="../../../../extras/vinyl.gif" alt="vinyl" width="80%">
</div>

## Tabla de contenidos
- [CONTADOR DE SEGUNDOS](#contador-de-segundos)
- [SENSOR DE HUMEDAD](#sensor-de-humedad)
- [LECTURA DE ARCHIVO LÍNEA A LÍNEA](#lectura-de-archivo-línea-a-línea)

## CONTADOR DE SEGUNDOS

- Crea un programa que use un `Stream` para contar los segundos desde 1 hasta 10.
- Muestra cada valor con el formato: ⏱️ `Segundo: X`
- Cuando llegue a 10, muestra ✅ Contador finalizado.
- Usa `Stream.periodic()` y `take(10)` para limitar las emisiones.
- No utilices bucles `for` ni `sleep()` que bloqueen la ejecución.

```dart
void main() async {
  final stream = Stream.periodic(
    Duration(seconds: 1),
    (contador) => contador + 1,
  ).take(10);

  await for (var segundo in stream) {
    print('⏱️ Segundo: $segundo');
  }

  print('✅ Contador finalizado.');
}
```

## SENSOR DE HUMEDAD

- Crea un programa que use un `StreamController` para simular lecturas de humedad cada segundo.
- Cada lectura será un número aleatorio entre `0` y `100`.
- Si la lectura es menor de `30%`, muestra 💧 **Humedad baja**.
- Si es mayor de `70%`, muestra 🌊 **Humedad alta**.
- En cualquier otro caso, muestra ✅ **Humedad normal**.
- El stream debe emitir **15 lecturas** y después cerrarse.
- Cuando se cierre, imprime 🔚 `Fin de la monitorización.`

```dart
import 'dart:async';
import 'dart:math';

void main() async {
  final controller = StreamController<int>();
  final random = Random();
  int count = 0;

  controller.stream.listen(
    (humedad) {
      if (humedad < 30) {
        print('💧 Humedad baja ($humedad%)');
      } else if (humedad > 70) {
        print('🌊 Humedad alta ($humedad%)');
      } else {
        print('✅ Humedad normal ($humedad%)');
      }
    },
    onDone: () => print('🔚 Fin de la monitorización.'),
  );

  Timer.periodic(Duration(seconds: 1), (timer) {
    if (count >= 15) {
      controller.close();
      timer.cancel();
    } else {
      final lectura = random.nextInt(101);
      controller.add(lectura);
      count++;
    }
  });
}
```

## LECTURA DE ARCHIVO LÍNEA A LÍNEA

- Crea un archivo llamado `poema.txt` con varias líneas de texto.
- Escribe un programa en Dart que lea ese archivo línea a línea usando un `Stream`.
- Muestra cada línea precedida por su número, por ejemplo: 1️⃣ `En un lugar de la Mancha...`
- Cuando termine de leer, muestra el mensaje ✅ `Lectura finalizada.`
- Usa `File.openRead()` junto con `utf8.decoder` y `LineSplitter()`.

```dart
import 'dart:io';
import 'dart:convert';

Future<void> main() async {
  final file = File('poema.txt');

  if (!await file.exists()) {
    print('❌ El archivo poema.txt no existe.');
    return;
  }

  int lineNumber = 1;

  final lines = file
      .openRead()
      .transform(utf8.decoder)
      .transform(LineSplitter());

  await for (var line in lines) {
    print('$lineNumber️⃣ $line');
    lineNumber++;
  }

  print('✅ Lectura finalizada.');
}
```