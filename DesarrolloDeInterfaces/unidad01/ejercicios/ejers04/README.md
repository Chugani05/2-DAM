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

```

---

## 2. Constructor nombrado

Crea una clase `Tarea` con atributos `descripcion` y `completada`.

- Usa un constructor normal.
- Añade un constructor nombrado `incompleta` que solo reciba la descripción y ponga `completada = false`.
- En `main`, crea una tarea con cada constructor y muestra su estado.

```dart

```

---

## 3. Constructor con inicialización (:)

Crea una clase `Circulo` con atributos `radio` y `area`.

- Usa un constructor que inicialice `area` usando la sintaxis `:`.
- En `main`, crea un círculo y muestra su área.

```dart

```

---

## 4. Constructor con parámetros nombrados ({})

Crea una clase `Mensaje` con atributos `texto` y `prioridad`.

- Usa un constructor con parámetros nombrados, donde `texto` sea obligatorio y `prioridad` tenga valor por defecto `"normal"`.
- En `main`, crea un mensaje con y sin especificar la prioridad.

```dart

```

---

## 5. Constructor const

Crea una clase `Moneda` con atributos `codigo` y `simbolo` (ambos `final`).

- Usa un constructor `const`.
- En `main`, crea dos monedas iguales (`USD`, `$`) y muestra si son idénticas con `identical()`.

```dart

```

---

## 6. Constructor con redirección

Crea una clase `Alumno` con atributos `nombre` y `nota`.

- Usa un constructor normal.
- Añade un constructor redirigido `Alumno.aprobado(nombre)` que ponga la nota en 5.
- En `main`, crea un alumno con cada constructor y muestra sus datos.

```dart

```

---

## 7. Constructor de fábrica (factory)

Crea una clase `Sesion` que solo permita tener una única sesión activa.

- Usa un constructor privado `_interna`.
- Usa un constructor `factory` que devuelva siempre la misma instancia.
- En `main`, crea dos sesiones y muestra si son idénticas.

```dart

```
