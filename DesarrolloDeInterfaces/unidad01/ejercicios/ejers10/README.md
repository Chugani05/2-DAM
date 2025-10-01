# Ejercicios de asincronía (parte 1)

**Ejercicios de Future, async/await, then, catchError y try/catch**

<div align="center">
    <img src="../../../../extras/vinyl.gif" alt="vinyl" width="80%">
</div>

## Contenidos
- [Future básico con retraso](#future-básico-con-retraso)
- [then() encadenados](#then-encadenados)
- [Manejo de errores con catchError](#manejo-de-errores-con-catcherror)
- [try/catch con async/await](#trycatch-con-asyncawait)
- [Esperar múltiples futuros con Future.wait](#esperar-múltiples-futuros-con-futurewait)
- [Future.any con el primero que termine](#futureany-con-el-primero-que- termine)
- [finally con async/await](#finally-con-asyncawait)
- [Uso de async/await en bucle](#uso-de-asyncawait-en-bucle)

---

## Future básico con retraso

Crea una función `Future<String> holaFuture()` que:
- Espere 2 segundos con `Future.delayed`.
- Devuelva el texto `"Hola desde el futuro"`.

En `main`, llama a esa función usando `async/await` e imprime el resultado.

```dart
Future<String> holaFuture() async {
  await Future.delayed(Duration(seconds: 2));
  return "Hola desde el futuro";
}

void main() async {
  String saludo = await holaFuture();
  print(saludo);
}
```

---

## then() encadenados

Crea un `Future<int>` que devuelva el número 5.
- Encadena `.then()` para multiplicarlo por 2.  
- Encadena otro `.then()` para sumarle 10.  
- Imprime el resultado final (`20`).

```dart
void main() {
  Future<int>.value(5)
      .then((valor) => valor * 2)
      .then((valor) => valor + 10)
      .then((resultado) => print("Resultado final: $resultado"));
}
```

---

## Manejo de errores con catchError

Crea una función que devuelva un `Future` y siempre lance una excepción `"Error en la carga"`.  
- Llama a la función y maneja el error con `.catchError()`, imprimiendo `"❌ Error atrapado: ..."`.

```dart
Future<void> fallo() async {
  throw Exception("Error en la carga");
}

void main() {
  fallo().catchError((error) {
    print("❌ Error atrapado: $error");
  });
}
```

---

## try/catch con async/await

Crea una función `Future<int> dividir(int a, int b)` que:
- Si `b == 0`, lance una excepción.
- Si no, devuelva la división entera.

En `main`, llama a la función con `dividir(10, 0)` usando `async/await` y maneja el error con `try/catch`.

```dart
Future<int> dividir(int a, int b) async {
  if (b == 0) {
    throw Exception("División por cero");
  }
  return a ~/ b;
}

void main() async {
  try {
    int resultado = await dividir(10, 0);
    print("Resultado: $resultado");
  } catch (e) {
    print("Error: $e");
  }
}
```

---

## Esperar múltiples futuros con `Future.wait`

Crea tres funciones:
- `Future<String> tarea1()` que espere 1s y devuelva `"Tarea 1"`.
- `Future<String> tarea2()` que espere 2s y devuelva `"Tarea 2"`.
- `Future<String> tarea3()` que espere 3s y devuelva `"Tarea 3"`.

En `main`, espera a que terminen todas usando `Future.wait` y muestra la lista de resultados.

```dart
Future<String> tarea1() async {
  await Future.delayed(Duration(seconds: 1));
  return "Tarea 1";
}

Future<String> tarea2() async {
  await Future.delayed(Duration(seconds: 2));
  return "Tarea 2";
}

Future<String> tarea3() async {
  await Future.delayed(Duration(seconds: 3));
  return "Tarea 3";
}

void main() async {
  List<String> resultados = await Future.wait([
    tarea1(),
    tarea2(),
    tarea3(),
  ]);
  print("Resultados: $resultados");
}
```

---

## `Future.any` con el primero que termine

Crea dos funciones:
- Una que espere 2 segundos y devuelva `"Lenta"`.
- Otra que espere 1 segundo y devuelva `"Rápida"`.

En `main`, usa `Future.any` para mostrar el primer resultado que llegue.

```dart
Future<String> lenta() async {
  await Future.delayed(Duration(seconds: 2));
  return "Lenta";
}

Future<String> rapida() async {
  await Future.delayed(Duration(seconds: 1));
  return "Rápida";
}

void main() async {
  String primero = await Future.any([lenta(), rapida()]);
  print("Primero: $primero");
}
```

---

## finally con async/await

Crea una función `Future<void> cargarArchivo()` que espere 1 segundo y luego lance una excepción `"Archivo no encontrado"`.  
- En `main`, llama a la función dentro de un bloque `try/catch/finally`.  
- El `finally` debe imprimir `"Proceso terminado"`, ocurra o no error.

```dart
Future<void> cargarArchivo() async {
  await Future.delayed(Duration(seconds: 1));
  throw Exception("Archivo no encontrado");
}

void main() async {
  try {
    await cargarArchivo();
  } catch (e) {
    print("Error: $e");
  } finally {
    print("Proceso terminado");
  }
}
```

---

## Uso de async/await en bucle

Crea una lista de 3 URLs simuladas: `["url1", "url2", "url3"]`.  
- Por cada URL, espera 1 segundo y luego imprime `"Descargada <url>"`.  
- Hazlo con un `for` y `await` dentro.

```dart
void main() async {
  List<String> urls = ["url1", "url2", "url3"];

  for (String url in urls) {
    await Future.delayed(Duration(seconds: 1));
    print("Descargada $url");
  }
}
```