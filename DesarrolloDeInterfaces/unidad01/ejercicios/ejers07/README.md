# Ejercicios de colecciones en Dart

<div align="center">
    <img src="../../../../extras/vinyl.gif" alt="vinyl" width="80%">
</div>

## Contenidos
- [Lista de notas](#list--lista-de-notas)
- [Correos únicos](#set--correos-únicos)
- [Diccionario de productos](#map--diccionario-de-productos)
- [Cola de tareas con *Queue*](#queue--cola-de-tareas)
- [Cola de tareas con *Splaytreeset*](#splaytreeset--cola-de-tareas)

---

## List – Lista de notas

Crea una lista con las notas de 5 alumnos.

- Añade una nueva nota al final.
- Muestra la primera y la última nota.
- Calcula la media de todas las notas.

Usa `first`, `last`, `reduce` y `length`.

```dart
void main() {
  List<double> grades = [7.5, 8.0, 6.5, 9.0, 7.0];
  grades.add(8.5);

  print('First grade: ${grades.first}');
  print('Last grade: ${grades.last}');

  double average = grades.reduce((a, b) => a + b) / grades.length;
  print('Average grade: $average');
}
```

---

## Set – Correos únicos

Crea un conjunto (`Set`) con correos electrónicos:

```dart
["ana@mail.com", "luis@mail.com", "ana@mail.com", "pedro@mail.com"]
```

- Imprime el conjunto para comprobar que no hay duplicados.
- Añade un correo nuevo.
- Comprueba si `"luis@mail.com"` está en el set.

Usa `add` y `contains`.

```dart
void main() {
  Set<String> emails = {
    "ana@mail.com",
    "luis@mail.com",
    "ana@mail.com",
    "pedro@mail.com"
  };
  
  print('Emails: $emails');
  
  emails.add("maria@mail.com");
  print('After adding a new email: $emails');
  
  bool containsLuis = emails.contains("luis@mail.com");
  print('Contains luis@mail.com? $containsLuis');
}
```

---

## Map – Diccionario de productos

Crea un mapa (`Map`) donde las claves sean nombres de productos y los valores sean sus precios:

```dart
{"pan": 1.0, "leche": 1.5, "huevos": 2.0}
```

- Muestra el precio de la leche.
- Añade `"café": 3.0`.
- Recorre el mapa e imprime `"producto → precio"`.

Usa `forEach`.

```dart
void main() {
  Map<String, double> products = {
    "bread": 1.0,
    "milk": 1.5,
    "eggs": 2.0
  };

  print('Price of milk: ${products["milk"]}');

  products["coffee"] = 3.0;

  products.forEach((product, price) {
    print('$product → $price');
  });
}
```

---

## Queue – Cola de tareas

Usa una cola (`Queue`) para representar tareas pendientes:

- Empieza con `["Lavar platos", "Hacer compra", "Estudiar"]`.
- Atiende (quita) la primera tarea y muéstrala.
- Añade una nueva tarea `"Pasear perro"`.
- Muestra todas las tareas restantes.

Usa `addAll` y `removeFirst`.

```dart
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
```

---

## SplayTreeSet – Cola de tareas

Crea un `SplayTreeSet` de enteros.

- Añade los números `5, 3, 9, 1, 4`.
- Imprime el conjunto y verifica que están ordenados automáticamente.
- Elimina el número `3`.
- Imprime el conjunto final.

Usa `addAll` y `remove`.

```dart
import 'dart:collection';

void main() {
  SplayTreeSet<int> numbers = SplayTreeSet();

  numbers.addAll([5, 3, 9, 1, 4]);

  print('Sorted numbers: $numbers');

  numbers.remove(3);

  print('Final set: $numbers');
}
```