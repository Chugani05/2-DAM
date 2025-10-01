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

```

---

## Suma de lista segura

Crea una función `sumarLista(List<dynamic> datos)` que:

- Recorra la lista y sume solo los valores enteros.
- Si encuentra algo que no sea entero, lance una excepción propia `ElementoNoEnteroException`.
- Maneja el error en `main` mostrando qué elemento causó el problema.

Ejemplo de entrada: `[10, 20, "hola", 5]`.

```dart

```

---

## Multiplicación con dos tipos de errores

Crea una función `multiplicar(int? a, int? b)` que:

- Lance un `ArgumentError` si alguno es `null`.
- Lance una excepción genérica si alguno es negativo.
- Maneja ambos casos en `main` con bloques `on ArgumentError` y `catch`.

```dart

```

---

## Reintentos en conexión simulada

Crea una función `conectar()` que:

- Use `Random()` para simular que a veces lanza una `Exception("Fallo de red")`.
- Intenta conectarse hasta 3 veces.
- Si tras 3 intentos sigue fallando, lanza una `Exception("Conexión fallida tras 3 intentos")`.
- Maneja el error en `main`.

```dart

```

---

## Cargar datos con `.catchError()`

Crea una función `Future<String> cargarArchivo(String nombre)` que:

- Si el nombre es `"config.txt"`, devuelva `"Archivo cargado"`.
- En otro caso, lance una excepción `"Archivo no encontrado"`.
- En `main`, llama a `cargarArchivo("datos.txt")` y maneja el error con `.catchError()` en lugar de `try/catch`.

```dart

```