<?php
function getRandomWord(String $filename): string {
    $words = file($filename);
    $randomIndex = array_rand($words);
    return trim($words[$randomIndex]);
}

function getIndexes(int $lenght): array {
    $index1 = random_int(0, $lenght - 1);
    do {
        $index2 = random_int(0, $lenght - 1);
    } while ($index1 == $index2);

    return [$index1, $index2];
}

function maskWord(String $word): String {
    $lenght = strlen($word);

    $indexes = getIndexes($lenght);

    $letter1 = substr($word, $indexes[0], 1);
    $letter2 = substr($word, $indexes[1], 1);

    $display = str_repeat("-", $lenght);
    $display = substr_replace($display, $letter1, $indexes[0], 1);
    $display = substr_replace($display, $letter2, $indexes[1], 1);

    return $display;
}

function guessWord(String $word) {
    $display = maskWord($word);
    echo "$display\n";

    do {
        $guessedWord = strtolower(trim(readline("Guess the fruit: ")));
        if ($word != $guessedWord) {
            echo "Try again\n";
        }
    } while ($word != $guessedWord);
    echo "Correct, you won\n";
}

$filename = "files/words.txt";
$word = getRandomWord($filename);
guessWord($word);
?>