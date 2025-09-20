# Ejercicios

## VARIABLES Y TIPOS BÁSICOS

1) Declara una variable edad como `int` y otra altura como `double`. Imprime ambos valores en una sola frase.

```dart
void main() {
  int age = 20;
  double height = 1.60;
  print('I am $age years old and my height is $height cm');
}

#OUTPUT: I am 20 years old and my height is 1.60 cm
```

2) Sabiendo que el área de un círculo es `A=πr2`.

    Escribe un programa que calcule el área de un círculo. Como no podemos pedir un input al usuario, inicializa `r` a un valor cualquiera. 

```dart
void main() {
  const PI = 3.14;
  num radius = 5;
  num area = PI * radius * radius;
  
  print("Area = $area");
}

#OUTPUT: Area = 78.5
```

## NULL SAFETY Y OPERADORES I

1) Declara una variable `String? apellido = null;`.

    Imprime `apellido` usando `??` para que muestre `"Sin apellido"` si es null. Ahora usa `!` y comprueba qué ocurre.

```dart
void main() {
  String? surname = null;
  print(surname ?? "No surname");
}

#OUTPUT: No surname
```

## NULL SAFETY Y OPERADORES II

1) Declara `String? saludo = "hola";`.
Convierte saludo a mayúsculas de tres formas distintas:
   
   a) Con `!`
   
   b) Con `??` y un valor alternativo
   
   c) Con un `if (saludo != null)`

```dart
void main() {
  String? greeting = 'Hello';
  print(greeting!.toUpperCase());

#OUTPUT: HELLO


  greeting = null;
  print(greeting ?? 'HI');

#OUTPUT: HI
  

  greeting = 'Greetings';
  if (greeting != null) {
    print(greeting.toUpperCase());
  }

#OUTPUT: GREETINGS
}
```

## LIST Y SET

1) Crea una `List<String>` con tres frutas.

    - Añade una fruta repetida y muestra la lista.
    - Convierte esa lista a un `Set` y muestra el resultado.

```dart
void main() {
  List<String>fruits = ['strawberries', 'blueberries', 'raspberries', 'strawberries', 'blackberries'];
  print(fruits);

#OUTPUT: [strawberries, blueberries, raspberries, strawberries, blackberries]
  

  Set<String>fruitsSet = fruits.toSet();
  print(fruitsSet);

#OUTPUT: {strawberries, blueberries, raspberries, blackberries}
}
```

## MAP

1) Crea un `Map<String, int>` con nombres como claves y edades como valores.

    - Muestra todas las claves.
    - Muestra todos los valores.
    - Accede a la edad de un nombre concreto y muéstrala.

```dart
void main() {
  Map<String, int> people = {
    "Ana": 25,
    "Luis": 30,
    "Maria": 22,
    "Pedro": 28
  };

  print("Keys (names):");
  for (var name in people.keys) {
    print(name);
  }

  print("");

  print("Values (ages):");
  for (var age in people.values) {
    print(age);
  }

  print("");

  String searchedName = "Maria";
  if (people.containsKey(searchedName)) {
    print("The age of $searchedName is: ${people[searchedName]}");
  } else {
    print("$searchedName is not in the list.");
  }
}
```

## ENUM

1) Declara un `enum` llamado `Estado` con valores: `pendiente`, `enProceso`, `completado`.

    - Crea una variable `tarea` con el valor `Estado.enProceso`.
    - Imprime el nombre y el índice de `tarea`.
    - Cambia el estado a `completado` y muéstralo.

```dart
enum Status { pending, inProgress, completed }

void main() {
  Status task = Status.inProgress;

  print("Task state: ${task.name}");
  print("Index: ${task.index}");

  task = Status.completed;
  print("New task state: ${task.name}");
}
```

## CONVERSIONES

1) Convierte un número entero en cadena (`int → String`) y luego vuelve a entero (`String → int`).

    Convierte una cadena `"3.14"` a `double` y suma 1.

    Convierte una lista `[1,2,3,2]` en un `Set` y después vuelve a lista.

```dart
void main() {
  int number = 42;
  String numberStr = number.toString();
  int numberAgain = int.parse(numberStr);
  print("Original: $number, As String: $numberStr, Back to int: $numberAgain");

  print("");

  String piStr = "3.14";
  double pi = double.parse(piStr);
  double result = pi + 1;
  print("3.14 + 1 = $result");

  print("");

  List<int> numbers = [1, 2, 3, 2];
  Set<int> numberSet = numbers.toSet();
  List<int> uniqueList = numberSet.toList();
  print("Original list: $numbers");
  print("As Set (unique): $numberSet");
  print("Back to List: $uniqueList");
}
```