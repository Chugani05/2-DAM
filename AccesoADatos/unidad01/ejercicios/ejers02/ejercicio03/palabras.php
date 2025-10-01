<?php
/**
 * Extraer informacion de un archivo.
 *
 * @param  string $filename
 * @return array
 */
function getInformation(String $filename): array {
    return file($filename);
}

/**
 * Contar las palabras totales de la informacion.
 *
 * @param  array $words
 * @return array
 */

function getTotalWords(array $words): int {
    return array_sum($words);
}

/**
 * Contar cuantas veces aparece cada palabra.
 *
 * @param  array $words
 * @return array
 */
function getFrequencies(array $words): array {
    return array_count_values($words);
}

/**
 * Guardar en un archivo de salida.
 *
 * @param  string $filename
 * @param  int $total
 * @param  array $frequencies
 * @return bool
 */
function save(String $filename, int $total, array $frequencies): bool {
    $stream = fopen($filename, "w");
    fwrite($stream, "Total: $total\n");

    fwrite($stream, "\nNumero de palabras:\n");
    foreach ($frequencies as $key => $value) {
        fwrite($stream, "$key: $value\n");
    }
    return fclose($stream);
}

$originfilename = "palabras.txt";
$targetfilename = "resultados.txt";
$words = getInformation($originfilename);
$total = getTotalWords($words);
$frequencies = getFrequencies($words);
save($targetfilename, $total, $frequencies);
?>