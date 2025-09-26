<?php
$file = fopen("files/5table.txt", "w");

for ($i = 1; $i <= 10; $i++) {
    $result = 5 * $i;
    fwrite ($file, "5 x $i = $result\n");
}

fclose(stream: $file);

foreach (file("files/5table.txt") as $line) {
    print $line;
}
?>