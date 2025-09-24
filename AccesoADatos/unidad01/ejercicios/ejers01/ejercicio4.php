<?php
$array = [5, 2, 9];
function calculateStadistic($array): array {
    $min = min($array);
    $max = max($array);
    $sum = array_sum($array);
    $avg = $sum / count($array);
    return [$min, $max, $sum, $avg];
}

$result = calculateStadistic($array);
echo implode(", ", $result);
?>