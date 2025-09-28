<?php
/**
 * Extraer informacion de un archivo.
 *
 * @param  string $filename
 * @return bool
 */
function getInformation(String $filename): bool|String {
    return strtolower(file_get_contents($filename));
}

/**
 * Contar las palabras de la informacion.
 *
 * @param  string $text
 * @return array
 */
function getWords(String $text): array {
    preg_match_all("/\p{L}+/u", $text, $matches);
   return $matches[0]; 
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
 * @param  mixed $filename
 * @param  mixed $frequencies
 * @return bool
 */
function save(String $filename, array $frequencies): bool {
    $stream = fopen($filename, "w");
    fwrite($stream, "palabra,frecuencia\n");
    foreach ($frequencies as $key => $value) {
        fwrite($stream, "$key,$value\n");
    }
    return fclose($stream);
}

$originfilename = "files/text.txt";
$targetfilename = "files/statics.csv";
$text = getInformation($originfilename);
$words = getWords($text);
$frequencies = getFrequencies($words);
save($targetfilename, $frequencies);
?>