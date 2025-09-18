# Tarea 01 - Conceptos básicos (introducción a php)

## Variables y Condicionales

1. **Mayor de dos números**  
   Pide dos números y muestra cuál es mayor o si son iguales.

```php
<?php

$number1 = readline("Enter a number: ");
$number2 = readline("Enter another number: ");

$result = "Both numbers are the same ($number1 and $number2)";
if ($number1 > $number2) {
    $result = "The number $number1 is bigger than $number2";
}
if ($number1 < $number2) {
    $result = "The number $number2 is bigger than $number1";
}
echo $result

?>
```

**Output**
```
Enter a number: 48
Enter another number: 37
The number 48 is bigger than 37 
```

2. **Edad permitida**  
   Pide la edad de una persona y muestra:  
   - `"Eres menor de edad"` si es < 18.  
   - `"Eres mayor de edad"` si es ≥ 18.

```php
<?php

$age = readline("Enter your age: ");

$result = "You are an adult"
if ($age < 18) {
    $result = "You are a minor";
}
echo $result

?>
```

**Output**
```
Enter your age: 20
You are an adult
```

3. **Positivo, negativo o cero**  
   Comprueba si un número almacenado en una variable es positivo, negativo o cero.  

```php
<?php

$number = -32;

$result = "The number is negative";
if ($number > 0) {
    $result = "The number is positive";
} 
if ($number == 0) {
    $result = "The number is zero";
}
echo $result

?>
```

**Output**
```
The number is negative
```

4. **Nota final**  
   Pide la nota de un alumno y muestra:  
   - `"Suspenso"` (< 5), `"Aprobado"` (5–6), `"Notable"` (7–8), `"Sobresaliente"` (9–10).  

```php
<?php

$mark = readline("Enter your mark: ");

$result = "Fail"
if ($mark == 5 || $mark == 6) {
    $result = "Approved"
}
if ($mark == 7 || $mark == 8) {
    $result = "Remarkable"
}
if ($mark == 9 || $mark == 10) {
    $result = "Outstanding"
}
echo $result

?>
```

**Output**
```
Enter your mark: 7
Remarkable
```


## Bucles (for, while, foreach)

5. **Contar del 1 al 100**  
   Muestra los números del 1 al 100 en pantalla.

```php
<?php
$counter = 1;

while ($counter <= 100) {
    echo "$counter ";
    $counter++;
}

?>
```

**Output**
```
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 100 
```

6. **Suma acumulada**  
   Calcula la suma de los números del 1 al 50 usando un bucle.

```php
<?php

?>
```

**Output**
```

```

7. **Tabla de multiplicar**  
   Pide un número y genera su tabla de multiplicar del 1 al 10.

```php
<?php

?>
```

**Output**
```

```

8. **Números pares**  
   Muestra todos los números pares entre 1 y 50.

```php
<?php

?>
```

**Output**
```

```

9. **Cuenta atrás**  
   Haz un bucle que cuente de 10 a 1 y luego muestre `"¡Fin!"`.

```php
<?php

?>
```

**Output**
```

```

10. **Factorial**  
    Calcula el factorial de un número introducido (ejemplo: `5! = 120`).

```php
<?php

?>
```

**Output**
```

```


## Combinando Condicionales y Bucles

11. **Números primos**  
    Escribe un algoritmo que muestre los números primos entre 1 y 50.

```php
<?php

?>
```

**Output**
```

```

12. **Fibonacci**  
    Genera los primeros 20 términos de la secuencia de Fibonacci.

```php
<?php

?>
```

**Output**
```

```

13. **Múltiplos de un número**  
    Pide un número `n` y muestra sus múltiplos hasta 100.

```php
<?php

?>
```

**Output**
```

```

14. **Suma de pares e impares**  
    Calcula la suma de los números pares e impares entre 1 y 100 por separado.

```php
<?php

?>
```

**Output**
```

```

15. **Adivinar número**  
    Genera un número aleatorio entre 1 y 20.  
    Pide al usuario que lo adivine y usa un bucle con condicionales para dar pistas: `"Mayor"` o `"Menor"`.  

```php
<?php

?>
```

**Output**
```

```


## Construcción de Algorítmicos

16. **Número perfecto**  
    Comprueba si un número es perfecto (la suma de sus divisores propios es igual al número).

```php
<?php

?>
```

**Output**
```

```

17. **Invertir número**  
    Escribe un algoritmo que invierta los dígitos de un número (ejemplo: `123 → 321`).

```php
<?php

?>
```

**Output**
```

```

18. **Palíndromo**  
    Comprueba si una palabra almacenada en una variable es palíndroma.

```php
<?php

?>
```

**Output**
```

```

19. **Máximo común divisor (MCD)**  
    Escribe un algoritmo que calcule el MCD de dos números.

```php
<?php

?>
```

**Output**
```

```

20. **Triángulo de asteriscos**  
    Muestra en pantalla un triángulo de altura `n` usando `*`.  
    Ejemplo con `n = 5`:  
    ```
    *
    **
    ***
    ****
    *****
    ```

```php
<?php

?>
```

**Output**
```

```