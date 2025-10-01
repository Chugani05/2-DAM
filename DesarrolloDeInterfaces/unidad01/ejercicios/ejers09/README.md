# Ejercicios avanzados de manejo de errores en Dart

<div align="center">
    <img src="../../../../extras/vinyl.gif" alt="vinyl" width="80%">
</div>

## Contenidos
- [Conversor de números con validación](#conversor-de-números-con-validación)
- [Suma de lista segura](#suma-de-lista-segura)
- [Multiplicación con dos tipos de errores](#multiplicación-con-dos-tipos-de-errores)
- [Reintentos en conexión simulada](#reintentos-en-conexión-simulada)
- [Cargar datos con *.catchError()*](#cargar-datos-con-catcherror)

---

## Conversor de números con validación

Crea una función `toIntSeguro(String valor)` que:

- Intente convertir el valor a entero con `int.parse`.
- Si el valor no es válido, lance una `FormatException` con el mensaje `"Valor inválido: $valor"`.
- En `main`, prueba con `["123", "abc", "45"]` y atrápalo con `try/catch`.

```dart
int toIntSeguro(String valor) {
  try {
    return int.parse(valor);
  } catch (e) {
    throw FormatException("Valor inválido: $valor");
  }
}

void main() {
  List<String> valores = ["123", "abc", "45"];

  for (var valor in valores) {
    try {
      int numero = toIntSeguro(valor);
      print("Conversión exitosa: $valor -> $numero");
    } on FormatException catch (e) {
      print("Error: ${e.message}");
    }
  }
}
```

---

## Suma de lista segura

Crea una función `sumarLista(List<dynamic> datos)` que:

- Recorra la lista y sume solo los valores enteros.
- Si encuentra algo que no sea entero, lance una excepción propia `ElementoNoEnteroException`.
- Maneja el error en `main` mostrando qué elemento causó el problema.

Ejemplo de entrada: `[10, 20, "hola", 5]`.

```dart
class ElementoNoEnteroException implements Exception {
  final dynamic elemento;
  ElementoNoEnteroException(this.elemento);

  @override
  String toString() => 'Elemento no entero: $elemento';
}

int sumarLista(List<dynamic> datos) {
  int suma = 0;
  for (var elemento in datos) {
    if (elemento is int) {
      suma += elemento;
    } else {
      throw ElementoNoEnteroException(elemento);
    }
  }
  return suma;
}

void main() {
  List<dynamic> datos = [10, 20, "hola", 5];

  try {
    int resultado = sumarLista(datos);
    print("Suma total: $resultado");
  } on ElementoNoEnteroException catch (e) {
    print("Error: $e");
  }
}
```

---

## Multiplicación con dos tipos de errores

Crea una función `multiplicar(int? a, int? b)` que:

- Lance un `ArgumentError` si alguno es `null`.
- Lance una excepción genérica si alguno es negativo.
- Maneja ambos casos en `main` con bloques `on ArgumentError` y `catch`.

```dart
int multiplicar(int? a, int? b) {
  if (a == null || b == null) {
    throw ArgumentError("Los argumentos no pueden ser nulos");
  }
  if (a < 0 || b < 0) {
    throw Exception("Los números no pueden ser negativos");
  }
  return a * b;
}

void main() {
  try {
    print(multiplicar(5, 3));
    print(multiplicar(null, 2));
    print(multiplicar(4, -2));
  } on ArgumentError catch (e) {
    print("ArgumentError: ${e.message}");
  } catch (e) {
    print("Error: $e");
  }
}
```

---

## Reintentos en conexión simulada

Crea una función `conectar()` que:

- Use `Random()` para simular que a veces lanza una `Exception("Fallo de red")`.
- Intenta conectarse hasta 3 veces.
- Si tras 3 intentos sigue fallando, lanza una `Exception("Conexión fallida tras 3 intentos")`.
- Maneja el error en `main`.

```dart
import 'dart:math';

Future<void> conectar() async {
  final random = Random();
  if (random.nextBool()) {
    throw Exception("Fallo de red");
  }
}

Future<void> intentarConectar() async {
  int intentos = 0;
  const maxIntentos = 3;

  while (intentos < maxIntentos) {
    try {
      await conectar();
      print("Conexión exitosa");
      return;
    } catch (e) {
      intentos++;
      print("Intento ${intentos}: Error - $e");
      if (intentos >= maxIntentos) {
        throw Exception("Conexión fallida tras $intentos intentos");
      }
    }
  }
}

void main() async {
  try {
    await intentarConectar();
  } catch (e) {
    print("Error final: $e");
  }
}
```

---

## Cargar datos con `.catchError()`

Crea una función `Future<String> cargarArchivo(String nombre)` que:

- Si el nombre es `"config.txt"`, devuelva `"Archivo cargado"`.
- En otro caso, lance una excepción `"Archivo no encontrado"`.
- En `main`, llama a `cargarArchivo("datos.txt")` y maneja el error con `.catchError()` en lugar de `try/catch`.

```dart
Future<String> cargarArchivo(String nombre) {
  if (nombre == "config.txt") {
    return Future.value("Archivo cargado");
  } else {
    return Future.error("Archivo no encontrado");
  }
}

void main() {
  cargarArchivo("datos.txt").then((mensaje) {
    print(mensaje);
  }).catchError((e) {
    print("Error: $e");
  });
}
```