<?php
$filename = "files/excuses.txt";
$line = file($filename);
$randomLine = array_rand($line);
echo $line[$randomLine];
?>