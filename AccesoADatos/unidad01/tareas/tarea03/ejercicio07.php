<?php
$filename = "files/numeric_data.txt";
file_put_contents($filename, "10,20,30,40,50");
$values = explode(",", file_get_contents($filename));
$sum = array_sum($values);
echo "The sum of " . implode(" + ", $values) . " is $sum"; 
?>