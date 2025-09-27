<?php
function addFood(String $filename): bool  {
    $file = fopen($filename,"a");
    $foods = readline("Insert your favorite food: ");
    fwrite($file, "$foods\n");
    return fclose( $file);
}

function countValues(String $filename): array {
    $values = array_count_values(file($filename));
    arsort($values);
    return $values;
}

$filename = "files/foods.txt";
addFood($filename);

foreach (countValues($filename) as $food => $ranking) {
    echo trim($food) . ": $ranking\n";
}
?>