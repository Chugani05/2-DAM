# Ejercicios

## CONTROL DE FLUJO

1) Tienes una lista de números [3, -1, 5, -7, 8]. **¡IMPORTANTE!** A priori no conoces el número de elementos de la lista. Recórrela e imprímelos.

```dart
void main() {
    List<int>numbersList = [3, -1, 5, -7, 8];

    // for
    for (int num in numbersList) {
        print(num);
    }

    // foreach
    numbersList.forEach(print);
}
```

2) Tienes una lista con los nombres de los días de la semana. Imprime un "Empezando la semana", si el día es lunes, "Casi finde", si viernes o "Terminando la semana" si es domingo, y un mensaje genérico para los demás.

```dart
void main() {
  List<String>daysWeek = ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturdayt", "Sunday"];
  
  for(String day in daysWeek) {
    switch (day) {
        case "Monday":
            print("$day: Starting the week");
            break;
        case "Friday":
            print("$day: Almost weekend");
            break;
        case "Sunday":
            print("$day: Ending the week");
            break;
        default:
            print("$day: Any other day of the week");
            break;
    }
  }
}
```

3) Escribe un programa que cuente del 10 al 1 y luego muestre “¡Despegue!”. 

    El bucle debe ejecutarse al menos una vez.

```dart
void main() {
  int counter = 10;

  do {
        print(counter);
    counter--;
  } while (counter > 0);
  print("Launch!!");
}
```

4) Dada una lista de números desde el 1 hasta el 10. 

    Recórrela e imprime solo los números pares.

```dart
void main() {
    List<int>numbersList = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
    
    print("Par numbers of the list: ");
    for (int num in numbersList) {
        print(num);
    }
}
```

5) Declara una lista con 5 contraseñas candidatas: ["abc123", "flutter123", "qwerty", "hola123", "clave"] 

    Recórrela e imprime **“Correcta”** si aparece `"flutter123"`. Si aparece, deja de recorrer la lista.

```dart
void main() {
    List<String>passwordsList = ["abc123", "flutter123", "qwerty", "hola123", "clave"];

    for (String password in passwordsList) {
        if (password == "flutter123");
        print("Correct");
        break;
    }
}
```

6) Dada una lista de frutas (manzana, pera, uva, plátano y tómate), muéstralas todas en mayúsculas, pero sáltate la fruta "pera". 

    El resultado tiene que ser el siguiente: 

    - MANZANA 
    - UVA 
    - PLÁTANO

```dart
void main() {
    List<String>fruitsList = ["manzana", "pera", "uva", "plátano", "tómate"];

    for (String fruit in fruitsList) {
        if (fruit == "pera" || fruit == "tómate") {
          continue;
        }
    print(fruit.toUpperCase());
    }
}
```

7) Declara una variable edad.
    - Si es menor de 12 → imprime “niño”.
    - Si está entre 12 y 17 → “adolescente”.
    - Si está entre 18 y 64 → “adulto”.
    - Si es 65 o más → “senior”.

    Resuélvelo de dos maneras: usando if-else y switch.

```dart
```

8) Tienes una lista de enteros [4, 6, -2, 7, -5, 10].
Suma todos los números positivos e imprime el resultado.
Ignora los negativos.

```dart
```

9) Genera los primeros 20 números de la secuencia de Fibonacci y muéstralos en pantalla.

```dart
void main() {
    List<int> fibonacciSequence = generateFibonacci(20);
    print(fibonacciSequence);
}

    List<int> generateFibonacci(int n) {
        if (n <= 0) {
            return [];
        } else if (n == 1) {
            return [0];
    }

    List<int> sequence = [0, 1];
        for (int i = 2; i < n; i++) {
            int nextNumber = sequence[i - 1] + sequence[i - 2];
            sequence.add(nextNumber);
        }
        return sequence;
    }
```

10) Escribe un programa que lea una nota (0–10) y muestre:

    - “Suspenso” si es menor de 5
    - “Aprobado” si está entre 5 y 6
    - “Notable” si está entre 7 y 8
    - “Sobresaliente” si es 9 o 10

```dart
```