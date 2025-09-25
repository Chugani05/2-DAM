# Ejercicios - Variables

<div align=center>
    <img src="../../../../extras/vinyl.gif" alt="vinyl" width="80%">
</div>

1) Declara variables de tipo `int`, `double` y `num`. Convierte un `int` a `String` y parsea `'3.14'` a `double`.

```dart
void main() {
  int age = 25;
  double height = 1.75;
  num anyNumber = 42; // can hold int or double

  // int → String
  String ageStr = age.toString();
  print("Age as String: $ageStr");

  // String → double
  double pi = double.parse("3.14");
  print("Parsed double: $pi");
}
```

2) Crea un `String` multilínea con tus lenguajes favoritos y muestra su longitud. Usa interpolación para imprimirlos en una sola línea.

```dart
void main() {
  String languages = """
Dart
Flutter
Python
JavaScript
""";

  print("Multiline string length: ${languages.length}");

  // Interpolation in one line
  print("My favorite languages: $languages".replaceAll("\n", " ").trim());
}
```

3) Dada la lista `[1, 2, 3, 4, 5, 6]`, obtén una nueva lista con los números pares multiplicados por 10.

```dart
void main() {
  List<int> numbers = [1, 2, 3, 4, 5, 6];
  List<int> evensTimes10 = numbers.where((n) => n.isEven).map((n) => n * 10).toList();
  print(evensTimes10);
}
```

4) Con un `Set<String>` de tecnologías `{'dart', 'flutter', 'dart', 'firebase'}`, imprime el conjunto resultante y calcula su tamaño. Une con otro set `{'dart', 'grpc'}` y muestra intersección y diferencia.

```dart
void main() {
  Set<String> tech = {'dart', 'flutter', 'dart', 'firebase'};
  print("Original set: $tech"); // duplicates removed
  print("Set size: ${tech.length}");

  Set<String> other = {'dart', 'grpc'};
  print("Union: ${tech.union(other)}");
  print("Intersection: ${tech.intersection(other)}");
  print("Difference: ${tech.difference(other)}");
}
```

5) Define un `Map<String, Object>` para un usuario con `id`, `nombre` y `activo`. Agrega la clave `email`, cambia `activo` a `false` y recorre el mapa imprimiendo `clave => valor`.

```dart
void main() {
  Map<String, Object> user = {
    "id": 1,
    "name": "Alice",
    "active": true,
  };

  // Add new key
  user["email"] = "alice@example.com";

  // Update value
  user["active"] = false;

  // Iterate
  user.forEach((key, value) {
    print("$key => $value");
  });
}
```

6) Crea una función que reciba un `String?` nombre y devuelva `'Hola, anónimo'` si es `null` o vacío; en caso contrario, `'Hola, <nombre>'`. Usa `??` y `trim()`.

```dart
String greet(String? name) {
  String cleaned = name?.trim() ?? "";
  return cleaned.isEmpty ? "Hello, anonymous" : "Hello, $cleaned";
}

void main() {
  print(greet(null));
  print(greet(""));
  print(greet(" Alice "));
}
```

7) Define `const double iva = 0.21` y una lista de precios. Calcula una nueva lista con el precio final aplicando IVA y redondea a 2 decimales.

```dart
void main() {
  const double iva = 0.21;
  List<double> prices = [10.0, 20.5, 3.99];

  List<double> finalPrices = prices
      .map((p) => double.parse((p * (1 + iva)).toStringAsFixed(2)))
      .toList();

  print("Final prices with VAT: $finalPrices");
}
```

8) Declara un `enum Prioridad { baja, media, alta }` y una función que reciba una prioridad y devuelva el tiempo estimado en horas: `baja=8`, `media=4`, `alta=1`.

```dart
enum Priority { low, medium, high }

int estimateHours(Priority p) {
  switch (p) {
    case Priority.low:
      return 8;
    case Priority.medium:
      return 4;
    case Priority.high:
      return 1;
  }
}

void main() {
  print("Low priority: ${estimateHours(Priority.low)} hours");
  print("Medium priority: ${estimateHours(Priority.medium)} hours");
  print("High priority: ${estimateHours(Priority.high)} hours");
}
```