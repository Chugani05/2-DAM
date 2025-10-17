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
