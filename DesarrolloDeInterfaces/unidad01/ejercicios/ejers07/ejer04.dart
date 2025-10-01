// Cola de tareas con Queue

import 'dart:collection';

void main() {
  Queue<String> tasks = ListQueue.from([
    "Wash dishes",
    "Go shopping",
    "Study"
  ]);

  String currentTask = tasks.removeFirst();
  print('Attended task: $currentTask');

  tasks.addLast("Walk the dog");

  print('Remaining tasks: $tasks');
}