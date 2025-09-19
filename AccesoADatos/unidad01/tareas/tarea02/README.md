# Tarea 02 - Creación y uso de elementos funciones en php

<div align=center>
    <img src="../../../../extras/vinyl.gif" alt="vinyl" width="80%">
</div>


## Contenido
- [Número capicúa (palíndromo numérico)](#número-capicúa-palíndromo-numérico)
- [Escalera de asteriscos](#escalera-de-asteriscos)
- [Suma de dígitos](#suma-de-dígitos)
- [Número secreto (múltiplos de 3 o 5)](#número-secreto-múltiplos-de-3-o-5)
- [Secuencia de Collatz](#secuencia-de-collatz)


## Número capicúa (palíndromo numérico)

Implementa una función __esCapicua(int $n): bool__ que determine si un número entero positivo es capicúa.

- Un número es capicúa si se lee igual de izquierda a derecha que de derecha a izquierda.

> Ejemplo: `12321` → `true`

```php
<?php
$num = readline("Insert a number to check if its capicua: ")

function isCapicua(int $n): bool {
    $inverted_n = strrev(strval($n));
    return $n == $inverted_n
}

if (isCapicua($num)) {
    echo "true\n";
} else {
    echo "false\n";
}
?>
```

**Output**
```
Insert a number to check if its capicua: 12321
true
```

## Escalera de asteriscos

Implementa una función __montañaAsteriscos(int $n, $m): void__ que imprima una escalera de asteriscos de altura `N`y el tamaño M.

- La primera fila contiene 1 asterisco, la segunda 2, y así hasta `N`, `M` veces.

> Ejemplo con entrada `4,2`:

```text
*.     *
**.   **
***  ***
********
```

```php
<?php

?>
```

**Output**
```

```

## Suma de dígitos

Implementa una función __sumaDigitos(int $n): int__ que calcule la suma de los dígitos de un número entero positivo.

- Descompón el número en dígitos y súmalos.

> Ejemplo: `2025` → `9` (2+0+2+5)

```php
<?php
$num = readline("Insert a number to calculate the sum of the digits: ");

function sumDigits(int $n): int {
    $sum = 0;
    $str_num = (strval($n));
    $arr_num = str_split($str_num);


    foreach ($arr_num as $n) {
        $sum += (int)$n;
    }
    return $sum;
}

$result = sumDigits($num);
echo "The sum of the digits of the number $num is: $result";
?>
```

**Output**
```
Insert a number to calculate the sum of the digits: 2025
The sum of the digits of the number 2025 is: 9
```

## Número secreto (múltiplos de 3 o 5)

Implementa una función __multiplosTresOCinco(int $n): array__ que devuelva todos los múltiplos de 3 o 5 menores que `N`.

- Además, calcula la suma de dichos múltiplos.

> Ejemplo con entrada `10`:

```code
3, 5, 6, 9
Suma = 23
```

```php
<?php
$num = readline("Insert a number to calculate the sum of the digits: ");
$sum = 0;

function multiplesThreeOrFive(int $n): array {
    $multiples = [];

    for ($i = 1; $i < $n; $i++ ) {
         if ($i % 3 == 0 || $i % 5 == 0) {
            array_push($multiples, $i);
         }
    }
   return $multiples;
}

$multiples = multiplesThreeOrFive($num);
$sum = array_sum($multiples);

echo "Multiples: " . (implode(",", $multiples)) . "\n";
echo "Sum = $sum";
?>
```

**Output**
```
Insert a number to calculate the sum of the digits: 10
Multiples: 3,5,6,9
Sum = 23
```

## Secuencia de Collatz

Implementa una función __secuenciaCollatz(int $n): array__ que genere la secuencia de Collatz a partir de un entero positivo.

- Si el número es par → dividir entre 2.  
- Si es impar → multiplicar por 3 y sumar 1.  
- Repetir hasta llegar a 1.

> Ejemplo con entrada `6`:

```code
6 → 3 → 10 → 5 → 16 → 8 → 4 → 2 → 1
```

```php
<?php

?>
```

**Output**
```

```