<?php
$filename = "files/adjectives.txt";
$line = file($filename);
$randomAdjective = array_rand($line);
$adjective = $line[$randomAdjective];

$filename = "files/animals.txt";
$line = file($filename);
$randomAnimal = array_rand($line);
$animal = $line[$randomAnimal];

echo "$adjective $animal"

?>