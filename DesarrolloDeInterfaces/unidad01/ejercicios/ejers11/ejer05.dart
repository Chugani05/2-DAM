// Stream periódico con cancelación

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