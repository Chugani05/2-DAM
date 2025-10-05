# Cuestionario fill the gap

<div align="center">
    <img src="../../../../extras/vinyl.gif" alt="vinyl" width="80%">
</div>

1. Tipos en Dart

```dart
String nombre = "Ana";
int edad = 20;
double altura = 1.75;
```

2. Tipos de datos básicos

```dart
List<String> frutas = ["pera", "uva", "pera"];
Set<String> frutasUnicas = frutas.toSet();  // Quita duplicados
print(frutasUnicas); // debería mostrar {pera, uva}
```

3. Conversiones entre tipos

```dart
String texto = "123";
int numero = int.parse(texto);  // convierte el texto a entero

double pi = 3.14159;
String redondeado = pi.toStringAsFixed(2); // "3.14"
```

4. Control de flujo

```dart
int contador = 0;
do {
  print("Intento $contador");
  contador++;
} while (contador < 3);
```

5. Funciones

```dart
// Completa la función para que devuelva el doble de un número
int doblar(int x) {
  return x * 2;
}

void main() {
  print(doblar(4)); // 8
}
```

6. Clases y objetos

```dart
class Persona {
  String nombre;
  int edad;

  // Constructor
  Persona (this.nombre, this.edad);
}

void main() {
  var p = Persona("Ana", 30);
  print(p.nombre); // debería mostrar Ana
}
```

7. Colecciones

```dart
Map<String, int> puntuaciones = {"Ana": 10, "Luis": 15};
print(puntuaciones.keys); // muestra las claves
print(puntuaciones.values); // muestra los valores
```

8. Iterables

```dart
var nombres = ["ana", "luis", "maria"];

// Convierte cada nombre a mayúsculas
var nombresMayus = nombres.map((n) => n.toUpperCase)();

// Convierte el Iterable en lista
var listaFinal = nombresMayus.toList();

print(listaFinal); // [ANA, LUIS, MARIA]
```

9. Manejo de errores

```dart
void dividir(int a, int b) {
  if (b == 0) {
    throw Exception("No se puede dividir entre cero");
  }
  print(a / b);
}

void main() {
  try {
    dividir(10, 0);
  } catch (e) {
    print("Error: $e");
  }
}
```

10. Asincronía

```dart
Future<String> cargarDatos() async {
  await Future.delayed(Duration(seconds: 1));
  return "Datos cargados";
}

void main() async {
  print("Cargando...");
  var resultado = await cargarDatos();
  print(resultado);
}
```