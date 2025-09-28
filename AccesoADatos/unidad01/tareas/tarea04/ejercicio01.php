<?php
function generateResultsFile(String $originFilename, String $targetFilename):bool {
    $lines = file($originFilename);

    $stream = fopen($targetFilename, "w");

    foreach ($lines as $line) {
        $line = trim($line);
        $parts = explode(",", $line);
        $num1 = (int)$parts[0];
        $num2 = (int)$parts[1];
        $ops = $parts[2];

        $result = calculateOperation($num1, $num2, $ops);

        fwrite($stream, "$line,$result\n");
    }

    return fclose($stream);
}

function calculateOperation(int $num1, int $num2, String $ops): int|String {
    switch ($ops) {
        case 'suma':
            return $num1 + $num2;
        case 'resta':
            return $num1 - $num2;
        case 'producto':
            return $num1 * $num2;
        case 'division':
            if ($num2 == 0) {
                return 'ERROR';
            }
            return $num1 / $num2;
        default:
            return 'resultado';
    }
}

$originFilename = "files/ops.csv";
$targetFilename = "files/resultado.csv";
generateResultsFile($originFilename, $targetFilename);
?>