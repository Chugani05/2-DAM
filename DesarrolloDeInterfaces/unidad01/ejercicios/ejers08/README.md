# Ejercicios básicos de manejo de errores en Dart

<div align="center">
    <img src="../../../../extras/vinyl.gif" alt="vinyl" width="80%">
</div>

## Contenidos
- [División por cero](#división-por-cero)
- [Índice fuera de rango](#índice-fuera-de-rango)
- [Formato inválido](#formato-inválido)
- [Uso de finally](#uso-de-finally)
- [Excepción personalizada](#excepción-personalizada)
- [Async y manejo de errores](#async-y-manejo-de-errores)

---

## División por cero

```dart
void dividir(int a, int b) {
  // TODO: Si b es 0, lanza una excepción con throw
  if (b == 0) {
    throw Exception("División por cero");
  }
  print(a / b);
}

void main() {
  try {
    dividir(10, 0);
  } 
  // TODO: Atrapa la excepción y muestra "Error: división por cero"
  catch (e) {
    print("Error: $e");
  }
}
```

---

## Índice fuera de rango

```dart
void main() {
  var lista = [1, 2, 3];

  try {
    print(lista[5]); // ❌ Esto da error
  } 
  // TODO: Usa on RangeError para capturar este error en específico
  on RangeError catch (e) {
    print("Error: índice fuera de rango");
  }
}
```

---

## Formato inválido

```dart
void main() {
  try {
    var numero = int.parse("abc"); // ❌ Esto da FormatException
    print(numero);
  } 
  // TODO: Usa on FormatException y muestra un mensaje claro
  on FormatException catch (e) {
    print("Error: formato inválido");
  }
}
```

---

## Uso de finally

```dart
void abrirArchivo() {
  print("📂 Archivo abierto");
  throw Exception("Error al leer archivo");
}

void main() {
  try {
    abrirArchivo();
  } 
  // TODO: Captura el error
  catch (e) {
    print("Error: $e");
  } 
  // TODO: Añade un bloque finally que muestre "📕 Archivo cerrado"
  finally {
    print("📕 Archivo cerrado");
  }
}
```

---

## Excepción personalizada

```dart
// TODO: Crea una clase DivisionPorCeroException que implemente Exception
//       y sobrescriba toString() para mostrar "🚫 División prohibida"

class DivisionPorCeroException implements Exception {
  @override
  String toString() => "🚫 División prohibida";
}

void dividir(int a, int b) {
  // TODO: Lanza tu excepción personalizada si b == 0
  if (b == 0) {
    throw DivisionPorCeroException();
  }
  print(a / b);
}

void main() {
  try {
    dividir(8, 0);
  } 
  // TODO: Atrapa tu excepción personalizada y muéstrala
  catch (e) {
    print(e);
  }
}
```

---

## Async y manejo de errores

```dart
Future<void> cargarDatos() async {
  await Future.delayed(Duration(seconds: 1));
  // TODO: Lanza una excepción aquí simulando un fallo de conexión
  throw Exception("Fallo de conexión");
}

void main() async {
  try {
    await cargarDatos();
  } 
  // TODO: Atrapa el error y muestra "Error: no se pudieron cargar los datos"
  catch (e) {
    print("Error: no se pudieron cargar los datos");
  }
}
```