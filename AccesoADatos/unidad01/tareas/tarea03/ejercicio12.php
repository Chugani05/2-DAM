<?php
function writeSongs(String $filename, array $songs): bool {
    $file = fopen($filename,"w");

    foreach ($songs as $song) {
        fwrite($file, "$song\n");
    }

    return fclose($file);
}

$songs = ["Ma Meilleure Ennemie", "To Ashes and Blood", "Come Play", "Renagede", "Sucker", "Remember Me"];
$filename = "files/songs.txt";
writeSongs($filename, $songs);

$line = file($filename);
$randomIndex = array_rand($line);
echo $line[$randomIndex];
?>