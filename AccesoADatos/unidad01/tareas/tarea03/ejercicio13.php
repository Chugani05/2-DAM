<?php
$filename = "files/excuses.txt";
$line = file($filename);
$randomIndex = array_rand($line);
echo $line[$randomIndex];
?>