<?php
function getLines(String $filename): bool {
    if (!$file = fopen($filename, "r")) {
        return false;
    }

    $line = fgets($file);
    $counter = 1;
    if ($line !== false) {
        echo $line;
    }
    return fclose($file);
}

$filename = "files/jokes.txt";
getLines($filename)
?>