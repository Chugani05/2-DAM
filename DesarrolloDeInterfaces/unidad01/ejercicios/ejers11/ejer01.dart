// Stream de sensores de temperatura

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