# Ejercicios de constructores en Dart

<div align=center>
    <img src="../../../../extras/vinyl.gif" alt="vinyl" width="80%">
</div>

## Contenidos
- [Constructor normal](#constructor-normal)
- [Constructor nombrado](#constructor-nombrado)
- [Constructor con inicialización](#constructor-con-inicialización)
- [Constructor con parámetros nombrados](#constructor-con-parametros-nombrados)
- [Constructor const](#constructor-const)
- [Constructor con redirección](#constructor-con-redirección)
- [Constructor de fábrica](#constructor-de-fabrica)

---

## 1. Constructor normal

Crea una clase `Pelicula` con atributos `titulo` y `anio`.

- Usa un constructor normal que reciba ambos atributos.
- En `main`, crea una película y muestra sus datos.

```dart
class Pelicula {
  String titulo;
  int anio;

  Pelicula(this.titulo, this.anio);
}

void main() {
  Pelicula peli = Pelicula('Purple Hearts', 2022);
  print('Película: ${peli.titulo}, Año: ${peli.anio}');
}
```

---

## 2. Constructor nombrado

Crea una clase `Tarea` con atributos `descripcion` y `completada`.

- Usa un constructor normal.
- Añade un constructor nombrado `incompleta` que solo reciba la descripción y ponga `completada = false`.
- En `main`, crea una tarea con cada constructor y muestra su estado.

```dart
class Tarea {
  String descripcion;
  bool completada;

  Tarea(this.descripcion, this.completada);

  Tarea.incompleta(this.descripcion) : completada = false;
}

void main() {
  Tarea tarea1 = Tarea('Lavar los platos', true);
  Tarea tarea2 = Tarea.incompleta('Hacer la tarea');

  print('Tarea 1: ${tarea1.descripcion}, Completada: ${tarea1.completada}');
  print('Tarea 2: ${tarea2.descripcion}, Completada: ${tarea2.completada}');
}
```

---

## 3. Constructor con inicialización (:)

Crea una clase `Circulo` con atributos `radio` y `area`.

- Usa un constructor que inicialice `area` usando la sintaxis `:`.
- En `main`, crea un círculo y muestra su área.

```dart
class Circulo {
  double radio;
  double area;

  Circulo(this.radio) : area = 3.1416 * radio * radio;
}

void main() {
  Circulo c = Circulo(5);
  print('Radio: ${c.radio}, Área: ${c.area}');
}
```

---

## 4. Constructor con parámetros nombrados ({})

Crea una clase `Mensaje` con atributos `texto` y `prioridad`.

- Usa un constructor con parámetros nombrados, donde `texto` sea obligatorio y `prioridad` tenga valor por defecto `"normal"`.
- En `main`, crea un mensaje con y sin especificar la prioridad.

```dart
class Mensaje {
  String texto;
  String prioridad;

  Mensaje({required this.texto, this.prioridad = 'normal'});
}

void main() {
  Mensaje m1 = Mensaje(texto: 'Revisar informe');
  Mensaje m2 = Mensaje(texto: 'Pagar el alquiler', prioridad: 'alto');

  print('Mensaje 1: ${m1.texto}, Prioridad: ${m1.prioridad}');
  print('Mensaje 2: ${m2.texto}, Prioridad: ${m2.prioridad}');
}
```

---

## 5. Constructor const

Crea una clase `Moneda` con atributos `codigo` y `simbolo` (ambos `final`).

- Usa un constructor `const`.
- En `main`, crea dos monedas iguales (`USD`, `$`) y muestra si son idénticas con `identical()`.

```dart
class Moneda {
  final String codigo;
  final String simbolo;

  const Moneda(this.codigo, this.simbolo);
}

void main() {
  const moneda1 = Moneda('USD', '\$');
  const moneda2 = Moneda('USD', '\$');

  print('¿Son iguales? ${identical(moneda1, moneda2)}');
}
```

---

## 6. Constructor con redirección

Crea una clase `Alumno` con atributos `nombre` y `nota`.

- Usa un constructor normal.
- Añade un constructor redirigido `Alumno.aprobado(nombre)` que ponga la nota en 5.
- En `main`, crea un alumno con cada constructor y muestra sus datos.

```dart
class Alumno {
  String nombre;
  double nota;

  Alumno(this.nombre, this.nota);

  Alumno.aprobado(this.nombre) : nota = 5.0;
}

void main() {
  Alumno alumno1 = Alumno('Carlos', 8.5);
  Alumno alumno2 = Alumno.aprobado('Ana');

  print('Alumno 1: ${alumno1.nombre}, Nota: ${alumno1.nota}');
  print('Alumno 2: ${alumno2.nombre}, Nota: ${alumno2.nota}');
}
```

---

## 7. Constructor de fábrica (factory)

Crea una clase `Sesion` que solo permita tener una única sesión activa.

- Usa un constructor privado `_interna`.
- Usa un constructor `factory` que devuelva siempre la misma instancia.
- En `main`, crea dos sesiones y muestra si son idénticas.

```dart
class Sesion {
  static final Sesion _instancia = Sesion._interna();

  factory Sesion() {
    return _instancia;
  }

  Sesion._interna();

  void info() {
    print('Sesión activa');
  }
}

void main() {
  Sesion s1 = Sesion();
  Sesion s2 = Sesion();

  print('¿Son iguales? ${identical(s1, s2)}');
}
```
