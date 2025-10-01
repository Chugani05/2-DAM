// Cola de tareas con Splaytreeset

import 'dart:collection';

void main() {
  SplayTreeSet<int> numbers = SplayTreeSet();

  numbers.addAll([5, 3, 9, 1, 4]);

  print('Sorted numbers: $numbers');

  numbers.remove(3);

  print('Final set: $numbers');
}