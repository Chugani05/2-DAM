<?php
$message = "Necesito estudiar más!!";

function lettersCounter(string $text): array {
    $vocals = ["a", "e", "i", "o", "u", "á", "é", "í", "ó", "ú"];

    $vowelsCount = 0;
    $lettersCount = 0;

    foreach (mb_str_split(mb_strtolower($text, 'UTF-8')) as $char) {
        if (ctype_alpha($char)) {
            if (in_array($char, $vocals)) {
                $vowelsCount++;
            } else {
                $lettersCount++;
            }
        }
    }

    return ["vocales" => $vowelsCount, "letras" => $lettersCount];
}

print_r(lettersCounter($message));
?>