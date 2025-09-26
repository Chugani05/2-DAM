<?php
$json_url = "files/data.json";
$json = file_get_contents($json_url);
$data = json_decode($json);
foreach ($data as $person) {
    echo "$person->name is $person->age old.\n";
}
?>