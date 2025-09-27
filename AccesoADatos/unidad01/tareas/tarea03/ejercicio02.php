<?php
function generateRange(String $filename, int $n = 10): bool {
    $file = fopen($filename, "w");
    
    for ($i = 1; $i <= $n; $i++) {
        fwrite($file, "$i\n");
    }
    return fclose($file);
}

$filename = "files/numbers.txt";
generateRange( $filename);
foreach (file($filename) as $num) {
    print $num;
}
?>