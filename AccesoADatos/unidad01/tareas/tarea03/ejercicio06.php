<?php
$file = "files/phrase.txt";
file_put_contents($file, "Vive el momento y no lo desaproveches.");
$phrase = file_get_contents($file);
echo $phrase ."\n";

$invertedPhrase = strrev($phrase);

$newfile = "files/inverted_phrase.txt";
file_put_contents($newfile, $invertedPhrase);
echo file_get_contents($newfile) . "\n";
?>