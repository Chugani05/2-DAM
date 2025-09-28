<?php
function addLog(String $filename): bool {
    $stream = fopen($filename,"a");
    $date = date_format(date_create(), "Y-m-d H:i");
    $log = readline("Write your entry: ");
    fwrite($stream, "[$date] $log\n");
    return fclose( $stream );
}

$filename = "files/diary.txt";
addLog($filename);
echo file_get_contents($filename);
?>