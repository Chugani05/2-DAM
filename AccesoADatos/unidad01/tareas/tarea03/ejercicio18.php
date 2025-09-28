<?php
function addTweet(String $filename): bool {
    $stream = fopen($filename,"a");
    $date = date_format(date_create(), "Y-m-d H:i");
    $tweet = readline("Write your tweet: ");
    fwrite($stream, "[$date] $tweet\n");
    return fclose( $stream );
}

$filename = "files/tweets.txt";
addTweet($filename);

$tweets = file($filename);
print_r (array_reverse(array_slice( $tweets,-5)));
?>