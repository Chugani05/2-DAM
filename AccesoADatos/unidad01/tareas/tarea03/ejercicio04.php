<?php
$names = ["RJ", "Peter", "Eve", "Sage", "Milo"];

$file = fopen("files/names.txt", "w");
foreach ($names as $name) {
        fwrite($file, "$name\n");
    }
    fclose($file);

$file = fopen("files/names.txt", "r");
if ($file) {
    $counter = 1;
    while (($line = fgets($file)) !== false) {
        echo "{$counter}. " . $line;
        $counter++;
    }
    fclose($file);
}
?>