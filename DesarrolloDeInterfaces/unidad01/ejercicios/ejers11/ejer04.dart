// Manejo de errores en streams

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