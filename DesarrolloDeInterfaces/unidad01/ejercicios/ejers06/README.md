
# Retos de cifrado

<div align="center">
    <img src="../../../../extras/vinyl.gifgif" alt="vinyl" width="80%">
</div>

## Contenidos
- [Cifrado ASCII Shift (+1)](#cifrado-ascii-shift-1)
- [Cifrado César](#cifrado-césar)
- [Cifrado Morse](#cifrado-morse)

---

## Cifrado ASCII Shift (+1)

Programa en Dart un descodificador que reste 1 a cada número y reconstruya el mensaje original.

Luego responde a la siguiente pregunta:

**¿Cuál es el mensaje original?**

```text
Que la fuerza te acompañe
```

Pistas:
- Cada carácter del mensaje original se convirtió a su código ASCII y luego se le sumó +1.
- Usa `String.fromCharCode()`, `split()` y `map()`.

Mensaje secreto: `82 118 102 33 109 98 33 103 118 102 115 123 98 33 117 102 33 98 100 112 110 113 98 242 102`

```dart
String decodeAscii(String code) {
  List<String> parts = code.split(' ');
  String result = parts.map((n) => String.fromCharCode(int.parse(n) - 1)).join('');
  
  return result;
}

void main() {
  print(decodeAscii("82 118 102 33 109 98 33 103 118 102 115 123 98 33 117 102 33 98 100 112 110 113 98 242 102"));
}
```

---

## Cifrado César

Programa en Dart un descodificador que revierta el proceso y recupere el mensaje original.

Luego responde a la siguiente pregunta:

**¿Cuál es el mensaje original?**

```text

```

Pistas:
- El mensaje original se ha codificado desplazando cada letra 3 posiciones hacia adelante en el alfabeto (sin desplazamiento circular).
- Utiliza el método `String.codeUnits` para obtener una lista de enteros (`List<int>`) de los códigos UTF-16 de cada carácter.
- Usa el método `map()` para convertir cada elemento de la colección.
- Usa `String.fromCharCodes()` para convertir una lista de enteros en una cadena de caracteres.

Mensaje secreto: `Zlqjduglxp#Ohylrvd`

```dart

```

---

## Cifrado Morse

Programa en Dart un descodificador que transforme el mensaje en texto legible.

Luego responde a la siguiente pregunta:

**¿Cuál es el mensaje original?**

```text

```

Pistas:
- El mensaje se transformó usando código Morse.
- Cada letra es una secuencia de `.` y `-`.
- Las letras están separadas por espacios.
- El símbolo `/` representa un espacio en blanco.
- La secuencia `--..--` es la coma.
- Usa un `Map` para crear un diccionario Morse y otro inverso.
- Usa el método `split()` de un `String` para obtener una lista de `String`.
- Usa el método `map()` de una `List` para recorrer la lista.
- Usa el método `join()` para unir los caracteres en una sola cadena.

Mensaje secreto: `- --- -.-. / - --- -.-. / - --- -.-. --..-- / .--. . -. -. -.--`

Si necesitas ayuda con los códigos Dart, puedo asistirte en crear los ejemplos específicos.

```dart

```