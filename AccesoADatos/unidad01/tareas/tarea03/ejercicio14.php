<?php
$filename = "files/jokes.txt";
$file = fopen($filename, "r");

if ($file !== false) {
    $line = fgets($file);
    $counter = 1;
    if ($line !== false) {
        echo $line;
    }
    fclose($file);
}
?>