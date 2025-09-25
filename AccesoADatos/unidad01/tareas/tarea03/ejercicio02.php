<?php
$file = fopen("Files/numeros.txt", "w");
fwrite($file, "Hola mundo");
fclose($file);
?>