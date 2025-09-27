<?php
function addGame (String $filename, $games): bool {
    $file = fopen($filename,"w");

    foreach ($games as $game) {
        fwrite($file, "$game\n");
    }

    return fclose($file);
}

$games = ["Papers Please"=>6, "Inscryption"=>8, "Buckshot Roulette"=>7, "Stardew Valley"=>10];
$filename = "files/ranking.txt";
addGame($filename, $games);

arsort($games);
$topThreeRanking = array_slice($games, 0, 3);
print_r($topThreeRanking);
?>