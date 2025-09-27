<?php
function writeNames(String $filename, array $names): bool {
    $file = fopen($filename, "w");
    
    foreach ($names as $name) {
        fwrite($file, "$name\n");
    }
    return fclose($file);
}

function showNames(String $filename): bool {
    if (!$file = fopen($filename, "r")) {
        return false;
    }

    $counter = 1;
    while (($line = fgets($file)) !== false) {
        echo "{$counter}. " . $line;
        $counter++;
    }
    return fclose($file);
}

$names = ["RJ", "Peter", "Eve", "Sage", "Milo"];
$filename = "files/names.txt";
writeNames($filename, $names);
showNames($filename);
?>