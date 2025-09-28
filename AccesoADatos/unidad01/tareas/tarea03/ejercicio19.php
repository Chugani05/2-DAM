<?php
function getRandomWord(String $filename): String {
    $word = file($filename);
    $randomIndex = array_rand($word);
    return trim($word[$randomIndex]);
}

function replacePlaceholder() {
    $phrase = file_get_contents("files/template.txt");

    $animal = getRandomWord("files/animals.txt");
    $place = getRandomWord("files/places.txt");
    $food = getRandomWord("files/foods.txt");

    $phrase = preg_replace("/\[animal\]/", $animal, $phrase);
    $phrase = preg_replace("/\[lugar\]/", $place, $phrase);
    $phrase = preg_replace("/\[comida\]/", $food, $phrase);

    echo "$phrase\n";
}

replacePlaceholder()
?>