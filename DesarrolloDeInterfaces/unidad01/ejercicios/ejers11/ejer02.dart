// Stream broadcast de mensajes de chat

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