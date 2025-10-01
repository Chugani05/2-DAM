
<?php
/**
 * Extraer informacion de un archivo.
 *
 * @param  string $filename
 * @return array
 */
function getData(String $filename): array|bool {
    return file($filename);
}

/**
 * Sacar las partes de la informacion.
 * @param  string $filename
 * @param  array $lines
 * @return void
 */
function getParts(String $filename, array $lines) {
    $stream = fopen($filename, "w");

    foreach ($lines as $line) {
        $line = trim($line);
        $parts = explode(" ", $line);
        $height = (int)$parts[0];
        $length = (int)$parts[1];
        $weth = (int)$parts[2];

        $result = generateFrame($height, $length, $weth);

        fwrite($stream, $result);
    }

    fclose($stream);
}


/**
 * Generar la salida (el marco).
 *
 * @param  int $height
 * @param  int $length
 * @param  int $weth
 * @return void
 */
function generateFrame(int $height, int $length, int $weth) {
    for ($i = 1; $i <= $height; $i++) {
        for ($j = 1; $j <= $length; $j++) {
            for ($k = 1; $k <= $weth; $k++) {
                echo str_repeat("*", $i);
                if ($j < $length) {
                    echo str_repeat("  ", $height - $i);
                }
                echo str_repeat("*", $k);
            }
            
        }
    }
}

$originFilename = "marco.txt";
$targetFilename = "salida.txt";
$lines = getData($originFilename);
getParts($targetFilename, $lines)
?>




