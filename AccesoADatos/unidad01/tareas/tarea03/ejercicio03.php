<?php
$filename = "files/text.txt";
file_put_contents($filename, "Una frase super larga para hacer el conteo de palabras.");
echo str_word_count(file_get_contents($filename));
?>