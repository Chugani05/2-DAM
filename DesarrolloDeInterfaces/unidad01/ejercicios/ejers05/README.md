# Ejercicios de tipos de clases en Dart

<div align=center>
    <img src="../../../../extras/vinyl.gif" alt="vinyl" width="80%">
</div>

## Contenidos
- [Ejercicio con getter](#ejercicio-con-getter)
- [Ejercicio con setter](#ejercicio-con-setter)
- [Ejercicio con extends](#ejercicio-con-extends)
- [Ejercicio con clase abstracta](#ejercicio-con-clase-abstracta)
- [Ejercicio con interfaz](#ejercicio-con-interfaz)
- [Ejercicio con mixin](#ejercicio-con-mixin)
- [Ejercicio con clase const](#ejercicio-con-clase-const)

---

## 1. Ejercicio con getter

Crea una clase `Temperatura` que almacene una temperatura en grados Celsius.

- Usa un getter para calcular automáticamente el valor en grados Fahrenheit.
- En `main`, muestra la conversión de varias temperaturas.

```dart
class Temperatura {
  double celsius;

  Temperatura(this.celsius);

  double get fahrenheit => (celsius * 9 / 5) + 32;
}

void main() {
  var temp1 = Temperatura(0);
  var temp2 = Temperatura(25);
  var temp3 = Temperatura(100);

  print('Temperatura en Celsius: ${temp1.celsius}°F en Fahrenheit: ${temp1.fahrenheit}°');
  print('Temperatura en Celsius: ${temp2.celsius}°F en Fahrenheit: ${temp2.fahrenheit}°');
  print('Temperatura en Celsius: ${temp3.celsius}°F en Fahrenheit: ${temp3.fahrenheit}°');
}
```

---

## 2. Ejercicio con setter

Crea una clase `Contraseña` con:

- Un atributo privado `_valor`.
- Un setter que solo permita asignar contraseñas de al menos 8 caracteres.
- En `main`, prueba a asignar contraseñas válidas e inválidas y muestra mensajes en consola.

```dart
class Contrasenia {
  String _valor = '';

  set valor(String nuevaContrasenia) {
    if (nuevaContrasenia.length >= 8) {
      _valor = nuevaContrasenia;
      print('Contraseña guardada.');
    } else {
      print('Error: La contraseña debe tener al menos 8 caracteres.');
    }
  }

  String get valor => _valor;
}

void main() {
  var contra = Contrasenia();

  contra.valor = '1234567';
  contra.valor = '12345678';
  print('Contraseña actual: ${contra.valor}');
}
```

---

## 3. Ejercicio con extends

Crea una clase base `Empleado` con `nombre` y un método `trabajar()`.  
Luego crea una clase `Programador` que extienda `Empleado` y sobrescriba `trabajar()` para que imprima "Estoy programando en Dart".  
En `main`, crea un programador y haz que trabaje.

```dart
class Empleado {
  String nombre;

  Empleado(this.nombre);

  void trabajar() {
    print('$nombre está trabajando.');
  }
}

class Programador extends Empleado {
  Programador(String nombre) : super(nombre);

  @override
  void trabajar() {
    print('Estoy programando en Dart.');
  }
}

void main() {
  var prog = Programador('Juan');
  prog.trabajar();
}
```

---

## 4. Ejercicio con clase abstracta

Crea una clase abstracta `InstrumentoMusical` con un método abstracto `tocar()`.  
Crea dos clases concretas (`Guitarra` y `Piano`) que extiendan `InstrumentoMusical` y lo implementen.  
En `main`, crea una lista de instrumentos y haz que todos toquen.

```dart
abstract class InstrumentoMusical {
  void tocar();
}

class Guitarra extends InstrumentoMusical {
  @override
  void tocar() {
    print('Tocando la guitarra.');
  }
}

class Piano extends InstrumentoMusical {
  @override
  void tocar() {
    print('Tocando el piano.');
  }
}

void main() {
  List<InstrumentoMusical> instrumentos = [Guitarra(), Piano()];

  for (var instrumento in instrumentos) {
    instrumento.tocar();
  }
}
```

---

## 5. Ejercicio con interfaz

Define una clase `Exportable` con un método `exportar()`.  
Crea dos clases, `DocumentoPDF` y `ImagenPNG`, que implementen esa interfaz cada una con su propia versión de `exportar()`.  
En `main`, crea una lista de `Exportable` y exporta todos los elementos.

```dart
abstract class Exportable {
  void exportar();
}

class DocumentoPDF implements Exportable {
  @override
  void exportar() {
    print('Exportando documento en PDF...');
  }
}

class ImagenPNG implements Exportable {
  @override
  void exportar() {
    print('Exportando imagen en PNG...');
  }
}

void main() {
  List<Exportable> elementos = [DocumentoPDF(), ImagenPNG()];

  for (var elemento in elementos) {
    elemento.exportar();
  }
}
```

---

## 6. Ejercicio con mixin

Crea un `mixin` `Recargable` que tenga un método `recargar()`.  
Aplícalo a dos clases muy distintas: `Telefono` y `Linterna`.  
En `main`, crea ambos objetos y llama a su método `recargar()`.

```dart
mixin Recargable {
  void recargar() {
    print('Recargando...');
  }
}

class Telefono with Recargable {
  void usar() {
    print('Usando teléfono.');
  }
}

class Linterna with Recargable {
  void iluminar() {
    print('Iluminando con la linterna.');
  }
}

void main() {
  var telefono = Telefono();
  var linterna = Linterna();

  telefono.recargar();
  linterna.recargar();
}
```

---

## 7. Ejercicio con clase const

Crea una clase `ColorRGB` con atributos `r`, `g`, `b` (todos `final`).  
Haz un constructor `const`.  
En `main`, crea dos colores con los mismos valores y muestra si son idénticos con `identical()`.

```dart
class ColorRGB {
  final int r;
  final int g;
  final int b;

  const ColorRGB(this.r, this.g, this.b);
}

void main() {
  const color1 = ColorRGB(255, 0, 0);
  const color2 = ColorRGB(255, 0, 0);

  print('¿Son iguales? ${identical(color1, color2)}');
}
```
