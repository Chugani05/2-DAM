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

```

---

## 2. Ejercicio con setter

Crea una clase `Contraseña` con:

- Un atributo privado `_valor`.
- Un setter que solo permita asignar contraseñas de al menos 8 caracteres.
- En `main`, prueba a asignar contraseñas válidas e inválidas y muestra mensajes en consola.

```dart

```

---

## 3. Ejercicio con extends

Crea una clase base `Empleado` con `nombre` y un método `trabajar()`.  
Luego crea una clase `Programador` que extienda `Empleado` y sobrescriba `trabajar()` para que imprima "Estoy programando en Dart".  
En `main`, crea un programador y haz que trabaje.

```dart

```

---

## 4. Ejercicio con clase abstracta

Crea una clase abstracta `InstrumentoMusical` con un método abstracto `tocar()`.  
Crea dos clases concretas (`Guitarra` y `Piano`) que extiendan `InstrumentoMusical` y lo implementen.  
En `main`, crea una lista de instrumentos y haz que todos toquen.

```dart

```

---

## 5. Ejercicio con interfaz

Define una clase `Exportable` con un método `exportar()`.  
Crea dos clases, `DocumentoPDF` y `ImagenPNG`, que implementen esa interfaz cada una con su propia versión de `exportar()`.  
En `main`, crea una lista de `Exportable` y exporta todos los elementos.

```dart

```

---

## 6. Ejercicio con mixin

Crea un `mixin` `Recargable` que tenga un método `recargar()`.  
Aplícalo a dos clases muy distintas: `Telefono` y `Linterna`.  
En `main`, crea ambos objetos y llama a su método `recargar()`.

```dart

```

---

## 7. Ejercicio con clase const

Crea una clase `ColorRGB` con atributos `r`, `g`, `b` (todos `final`).  
Haz un constructor `const`.  
En `main`, crea dos colores con los mismos valores y muestra si son idénticos con `identical()`.

```dart

```
