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
