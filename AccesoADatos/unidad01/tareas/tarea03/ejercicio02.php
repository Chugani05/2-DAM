<?php
$file = fopen("files/numbers.txt", "w");

for ($i = 1; $i <= 10; $i++) {
    fwrite($file, "$i\n");
}

fclose(stream: $file);

foreach (file("files/numbers.txt") as $num) {
    print $num;
}
?>