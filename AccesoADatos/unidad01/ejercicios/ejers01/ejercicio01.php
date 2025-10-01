<?php
$n = 15;
$a = 3;
$b = 5;
 
function fizzBuzz(int $n, int $a, int $b): array {
    $array = [];
    for ($i = 1; $i <= $n; $i++) {
        if ($i % $a == 0 && $i % $b == 0) {
            array_push($array, 'FizzBuzz');
        } else if ($i % $a == 0) {
            array_push($array, 'Fizz');
        } else if ($i % $b == 0) {
            array_push($array, 'Buzz');
        } else {
            array_push($array, $i);
        }
    }
    return $array;
}


echo implode(", ", fizzBuzz($n, $a, $b));
?>
