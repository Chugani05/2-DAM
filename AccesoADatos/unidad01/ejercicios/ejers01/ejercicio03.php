<?php
$n = 12021203;
function removeDuplicated(int $n): int  {
    $array = str_split(strval($n));
    $uniques = array_unique($array);
    $strNum = implode($uniques);
    return (int)$strNum;
}

echo removeDuplicated($n);
?>