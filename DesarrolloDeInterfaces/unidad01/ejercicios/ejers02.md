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
```

## ENUM

1) Declara un `enum` llamado `Estado` con valores: `pendiente`, `enProceso`, `completado`.

    - Crea una variable `tarea` con el valor `Estado.enProceso`.

    - Imprime el nombre y el índice de `tarea`.

    - Cambia el estado a `completado` y muéstralo.

```dart
```

## CONVERSIONES

1) Convierte un número entero en cadena (`int → String`) y luego vuelve a entero (`String → int`).

    Convierte una cadena `"3.14"` a `double` y suma 1.

    Convierte una lista `[1,2,3,2]` en un `Set` y después vuelve a lista.

```dart
```