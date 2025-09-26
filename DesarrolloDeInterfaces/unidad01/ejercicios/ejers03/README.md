# Ejercicios de funciones en Dart

<div align=center>
    <img src="../../../../extras/vinyl.gif" alt="vinyl" width="80%">
</div>

## Contenidos
- [Calcular y mostrar área de rectángulo](#1-calcular-y-mostrar-área-de-rectángulo)
- [Función con saludo y opción de apellido](#2-función-con-saludo-y-opción-de-apellido)
- [Encontrar el mayor de tres números](#3-encontrar-el-mayor-de-tres-números)
- [Sumar elementos de una lista](#4-sumar-elementos-de-una-lista)
- [Mensaje de presentación con edad opcional](#5-mensaje-de-presentación-con-edad-opcional)
- [Función operar con otra función](#6-función-operar-con-otra-función)
- [Mostrar nombres en mayúsculas con forEach](#7-mostrar-nombres-en-mayúsculas-con-foreach)
- [Generar lista de cuadrados (=>)](#8-generar-lista-de-cuadrados-=>)
- [Devolver una función closure](#9-devolver-una-función-closure)
- [Simulación de botón con callback](#10-simulación-de-botón-con-callback)

---

## 1. Calcular y mostrar área de rectángulo

Crea una función que calcule el área de un rectángulo a partir de su base y altura, y la muestre en consola.

```dart
void main() {
  double base = 5.0;
  double height = 10.0;
  
  double area = base * height;

  print('El área del rectángulo es: $area');
}
```

---

## 2. Función con saludo y opción de apellido

Haz una función que muestre en consola un saludo, pudiendo opcionalmente incluir un apellido.

```dart
void main() {
  void greet([String? lastName]) {
    print("Hola ${lastName ?? ""}.");
  }

  greet();
  greet("Chugani");
}
```

---

## 3. Encontrar el mayor de tres números

Define una función que devuelva el mayor de tres números enteros.

```dart
void main() {
  List<int>values = [7, 3, 9];

  int maxNumber(List<int>values) {
    int maxValue = values[0];
    for (var value in values) {
      if (value > maxValue) {
        maxValue = value;
      }      
    }

    return maxValue;
  }
  
  print(maxNumber(values));
}
```

---

## 4. Sumar elementos de una lista

Crea una función que reciba una lista de números y devuelva la suma de todos ellos.

```dart
void main() {
  List<int>values = [7, 13, 9, 24, 5];

  int sum = values.reduce((a, b) => a + b);
  print(sum);
}
```

---

## 5. Mensaje de presentación con edad opcional

Escribe una función que muestre en consola un mensaje de presentación con un nombre obligatorio y una edad opcional (por defecto 0).

```dart
void main() {
  void introduction(String name, [int? age = 0]) {
    print("Hello, my name is $name and I am ${age} years old.");
  }

  introduction("Rashi");
  introduction("Rashi", 20);
}
```

---

## 6. Función operar con otra función

Implementa una función `operar` que reciba dos números y otra función que defina la operación. Permite sumar, restar, multiplicar y dividir.

```dart
import 'dart:io';

void main() {
  String? getOperationType() {
    print("Choose the operation type");
    print("1. Addition");
    print("2. Subtraction");
    print("3. Multiplication");
    print("4. Division");
    return stdin.readLineSync();
  }

  void operate() {
    print("Enter the first value");
    num value1 = num.parse(stdin.readLineSync() ?? "0");
    print("Enter the second value");
    num value2 = num.parse(stdin.readLineSync() ?? "0");

    switch (getOperationType()) {
      case "1":
        print("The sum of $value1 + $value2 is ${value1 + value2}");
        break;
      case "2":
        print("The subtraction of $value1 - $value2 is ${value1 - value2}");
        break;
      case "3":
        print("The multiplication of $value1 x $value2 is ${value1 * value2}");
        break;
      case "4":
        print("The division of $value1 / $value2 is ${value1 / value2}");
        break;
      default:
        break;
    }
  }

  operate();
}
```

---

## 7. Mostrar nombres en mayúsculas con forEach

Dada una lista de nombres, usa una función anónima dentro de `forEach` para mostrar cada nombre en mayúsculas.

```dart
void main() {
  List<String>names = ["RashI", "Jesús", "nora", "EDdie", "Antón"];

  names.forEach((name) => print(name.toUpperCase()));
}
```

---

## 8. Generar lista de cuadrados (=>)

Escribe una función que genere una lista con los cuadrados de los primeros `n` números enteros, usando una función flecha (`=>`).

```dart
void main() {
  List generateSquares(n) {
    Function square = (number) => number * number;

    List<int>values = [];

    for (var i = 1; i <= n; i++) {
      values.add(square(i));
    }
  
    return values;
  }
  
  print(generateSquares(5));
}
```

---

## 9. Devolver una función closure

Crea una función que devuelva otra función (closure). La función devuelta debe multiplicar por un factor fijo el número que reciba.

```dart
void main() {
  Function multiplier(int factor) {
    return (int number) {
      return number * factor;
    };
  }

  var byThree = multiplier(3);
  print(byThree(5));
}
```

---

## 10. Simulación de botón con callback

Declara una función `onPressed` que recibe un callback sin parámetros y lo ejecuta. Luego llama a esa función pasándole una función anónima que imprima "Botón pulsado".

```dart
void main() {
  void onPressed(Function callback) {
    callback();
  }

  onPressed(() => print("Button pressed"));
}
```
