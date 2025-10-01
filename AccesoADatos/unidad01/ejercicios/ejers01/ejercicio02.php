<?php
function pyramid(int $n): void {
    $horizontalSize = $n * 2 - 1;
    for ($i = 1; $i <= $n; $i += 2) {
        $line = str_repeat(" ", $horizontalSize / 2 - $i);
        $line .= str_repeat("*", $i);
        $line .= str_repeat(" ", $horizontalSize / 2 - $i);
        echo $line . "\n";
    }
}

pyramid(5);
?>