<?php
function getRandomWord(String $filename): String {
    $words = file($filename);
    $randomIndex = array_rand($words);
    return trim($words[$randomIndex]);
}

$adjective = getRandomWord("files/adjectives.txt");
$animal = getRandomWord("files/animals.txt");
echo "$adjective $animal"
?>