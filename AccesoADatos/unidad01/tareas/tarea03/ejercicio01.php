<?php
$filename = "files/data.txt";
file_put_contents($filename, "Hola Mundo desde PHP");
echo file_get_contents($filename);
?>