// Transformaciones de stream de números

import 'dart:async';

void main() {
  final numeros = Stream<int>.fromIterable([1, 2, 3, 4, 5]);

  numeros
      .where((n) => n.isEven)
      .map((n) => n * 10)
      .listen((n) => print(n));
}