<?php
function generateTables(String $filename, int $multiplicand, int $limit = 10): bool {
    $file = fopen($filename, "w");

    for ($i = 1; $i <= $limit; $i++) {
        $result = $multiplicand * $i;
        fwrite ($file, "$multiplicand x $i = $result\n");
    }

    return fclose($file);
}

$filename = "files/5table.txt";
generateTables($filename, 5);
foreach (file($filename) as $line) {
    print $line;
}
?>