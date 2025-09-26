<?php
$file = "files/origin.txt";
file_put_contents($file, "Este es un mensaje proporcionado por el archivo original.");
echo file_get_contents($file) . "\n";

$newfile = "files/copy.txt";
copy($file, $newfile);
echo file_get_contents($newfile) . "\n";
?>