# Tarea 01 - Conceptos básicos (introducción a php)

<div align=center>
    <img src="../../../../extras/vinyl.gif" alt="vinyl" width="80%">
</div>

## Contenido
- [Variables y Condicionales](#variables-y-condicionales)
- [Bucles (for, while, foreach)](#bucles-for-while-foreach)
- [Combinando Condicionales y Bucles](#combinando-condicionales-y-bucles)
- [Construcción de Algorítmicos](#construcción-de-algorítmicos)

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
    echo $counter. " ";
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
$sum = 0;

for ($i = 1; $i <= 50; $i++) {
    $sum += $i;
}

echo "The sum of the numbers from 1 to 50 is: $sum";
?>
```

**Output**
```
The sum of the numbers from 1 to 50 is: 1275
```

7. **Tabla de multiplicar**  
   Pide un número y genera su tabla de multiplicar del 1 al 10.

```php
<?php
$num = readline("Enter a number to get its table of multiplication: ");

for ($i = 1; $i <= 10; $i++) {
    $result = $num * $i;
    echo "$num x $i = $result\n";
}
?>
```

**Output**
```
Enter a number: 5
5 x 1 = 5
5 x 2 = 10
5 x 3 = 15
5 x 4 = 20
5 x 5 = 25
5 x 6 = 30
5 x 7 = 35
5 x 8 = 40
5 x 9 = 45
5 x 10 = 50
```

8. **Números pares**  
   Muestra todos los números pares entre 1 y 50.

```php
<?php
for ($i = 1; $i <= 50; $i++) {
    if ($i % 2 == 0) {
        echo $i . " ";
    }
}
?>
```

**Output**
```
2 4 6 8 10 12 14 16 18 20 22 24 26 28 30 32 34 36 38 40 42 44 46 48 50 
```

9. **Cuenta atrás**  
   Haz un bucle que cuente de 10 a 1 y luego muestre `"¡Fin!"`.

```php
<?php
for ($i = 10; $i >= 1; $i--) {
    echo $i. " ";
}
echo "¡Fin!";
?>
```

**Output**
```
10 9 8 7 6 5 4 3 2 1 ¡Fin!
```

10. **Factorial**  
    Calcula el factorial de un número introducido (ejemplo: `5! = 120`).

```php
<?php
$num = readline("Enter a number to calculate its factorial: ");

function factorialCalculator($num) {
    if ($num == 0) {
        return 1;
    }
    elseif ($num < 0) {
        return "The factorial is not defined for negative numbers";
    }
    else {
        $factorial = 1;
        for ($i = 1; $i <= $num; $i++) {
            $factorial *= $i;
        }
        return $factorial;
    }
}

$result = factorialCalculator($num);

echo "The factorial of $num is: $result";
?>
```

**Output**
```
Enter a number: 8
The factorial of 8 is: 40320
```


## Combinando Condicionales y Bucles

11. **Números primos**  
    Escribe un algoritmo que muestre los números primos entre 1 y 50.

```php
<?php
for ($i = 1; $i <= 50; $i++) {
    $isPrime = true;

    for ($j = 2; $j < $i; $j++) {
        if ($i % $j == 0) {
            $isPrime = false;
            break;
        }
    }
    
    if ($isPrime) {
        echo $i . " ";
    }
}
?>
```

**Output**
```
1 2 3 5 7 11 13 17 19 23 29 31 37 41 43 47
```

12. **Fibonacci**  
    Genera los primeros 20 términos de la secuencia de Fibonacci.

```php
<?php
function fibonacci($n) {
    $fibList = [0, 1];
    
    for ($i = 2; $i < $n; $i++) {
        $fibList[] = $fibList[$i - 1] + $fibList[$i - 2];
    }
    return $fibList;
}

$result = fibonacci(20);

foreach ($result as $value) {
    echo $value . " ";
}
?>
```

**Output**
```
0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584 4181
```

13. **Múltiplos de un número**  
    Pide un número `n` y muestra sus múltiplos hasta 100.

```php
<?php
$counter = 1;
$n = readline("Insert a number: ");

while ($counter <= 100) {
    echo $n * $counter . " ";
    $counter++;
}
?>
```

**Output**
```
5 10 15 20 25 30 35 40 45 50 55 60 65 70 75 80 85 90 95 100 105 110 115 120 125 130 135 140 145 150 155 160 165 170 175 180 185 190 195 200 205 210 215 220 225 230 235 240 245 250 255 260 265 270 275 280 285 290 295 300 305 310 315 320 325 330 335 340 345 350 355 360 365 370 375 380 385 390 395 400 405 410 415 420 425 430 435 440 445 450 455 460 465 470 475 480 485 490 495 500
```

14. **Suma de pares e impares**  
    Calcula la suma de los números pares e impares entre 1 y 100 por separado.

```php
<?php
$counter = 1;
$even = 0;
$odd = 0;

while ($counter <= 100) {
    if ($counter % 2 == 0) {
        $even += $counter;
    } else {
        $odd += $counter;
    }
    $counter++;
}
echo "The sum of odd numbers is $odd\n";
echo "The sum of even numbers is $even";
?>
```

**Output**
```
The sum of odd numbers is 2500
The sum of even numbers is 2550
```

15. **Adivinar número**  
    Genera un número aleatorio entre 1 y 20.  
    Pide al usuario que lo adivine y usa un bucle con condicionales para dar pistas: `"Mayor"` o `"Menor"`.  

```php
<?php
$random_num = rand(1, 20);

echo "Welcome to guess the number.\n";
echo "The secret number is between 1 and 20.\n";

while (true) {
    $input = readline("Insert number: ");

    if (!is_numeric($input)) {
        echo "Please enter a valid number.\n";
        continue;
    }
    $user_num = (int)$input;

    if ($user_num == $random_num) {
        echo "Congratulations! You've guessed the number.\n";
        break;
    } elseif ($user_num < $random_num) {
        echo "The number you are looking for is higher.\n";
    } else {
        echo "The number you are looking for is lower.\n";
    }
}
?>
```

**Output**
```
Welcome to guess the number.
The secret number is between 1 and 20.
Insert number: 15
The number you are looking for is lower.
Insert number: 9
The number you are looking for is lower.
Insert number: 4
The number you are looking for is higher.
Insert number: 6
The number you are looking for is higher.
Insert number: 8
The number you are looking for is lower.
Insert number: 7
Congratulations! You've guessed the number.
```


## Construcción de Algorítmicos

16. **Número perfecto**  
    Comprueba si un número es perfecto (la suma de sus divisores propios es igual al número).

```php
<?php
$num = readline("Enter a number to see if its perfect: ");
$sum = 1;

for ($i = 2; $i < $num; $i++) {
    if ($num % $i == 0) {
        $sum += $i;
    }
}

if ($sum == $num) {
    echo "$num is a perfect number";
} else {
    echo "$num is not a perfect number";
}
?>
```

**Output**
```
Enter a number to see if its perfect: 6
6 is a perfect number
```

17. **Invertir número**  
    Escribe un algoritmo que invierta los dígitos de un número (ejemplo: `123 → 321`).

```php
<?php
$num = readline("Enter a number to invert: ");

function numberInverter(int $num): int {
    $string_num = (string) $num;
    $inverted_num = strrev($string_num);
    return (int) $inverted_num;
}

$result = numberInverter($num);
echo "$num inverted is: $result";
?>
```

**Output**
```
Enter a number: 12345
12345 inverted is: 54321
```

18. **Palíndromo**  
    Comprueba si una palabra almacenada en una variable es palíndroma.

```php
<?php
$word = "Aibohphobia";

$lowered_word = strtolower($word);
$inverted_word = strrev($lowered_word);

if ($lowered_word == $inverted_word) {
    echo "$word is a palindrome";
} else {
    echo "$word isnt a palindrome";
}
?>
```

**Output**
```
Aibohphobia is a palindrome
```

19. **Máximo común divisor (MCD)**  
    Escribe un algoritmo que calcule el MCD de dos números.

```php
<?php
$num1 = readline("Insert a number: ");
$num2 = readline("Insert another number: ");

function calculate_gcd(int $a, int $b): int {
    if ($b === 0) {
        return $a;
    }
    return calculate_gcd($b, $a % $b);
}

$gcd = calculate_gcd($num1, $num2);

echo "The GCD of $num1 and $num2 is: $gcd";
?>
```

**Output**
```
Insert a number: 8
Insert another number: 12
The GCD of 8 and 12 is: 4
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
$counter = 1;
$n = readline("Insert a number: ");

while ($counter <= $n) {
    echo str_repeat("*", $counter) . "\n";
    $counter++;
}
?>
```

**Output**
```
Insert a number: 9
*
**
***
****
*****
******
*******
********
*********
```