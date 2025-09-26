# Tarea 03 - Uso de elementos funciones y archivos en php

<div align=center>
    <img src="../../../../extras/vinyl.gif" alt="vinyl" width="80%">
</div>

## Contenido
- [Hola fichero (crear y leer)](#1-hola-fichero-crear-y-leer)
- [Guardar números en un fichero](#2-guardar-números-en-un-fichero)
- [Contar palabras en un fichero](#3-contar-palabras-en-un-fichero)
- [Escribir y leer array en fichero](#4-escribir-y-leer-array-en-fichero)
- [Copiar contenido de un fichero a otro](#5-copiar-contenido-de-un-fichero-a-otro)
- [Invertir el contenido de un fichero](#6-invertir-el-contenido-de-un-fichero)
- [Calcular suma desde fichero](#7-calcular-suma-desde-fichero)
- [Crear fichero de multiplicaciones](#8-crear-fichero-de-multiplicaciones)
- [Registrar entradas de usuario](#9-registrar-entradas-de-usuario)
- [Leer JSON desde fichero](#10-leer-json-desde-fichero)
- [Diario personal secreto](#11-diario-personal-secreto)
- [Ranking de videojuegos](#12-ranking-de-videojuegos)
- [Canción aleatoria](#13-canción-aleatoria)
- [Generador de excusas divertidas](#14-generador-de-excusas-divertidas)
- [Lista de chistes (rotativos)](#15-lista-de-chistes-rotativos)
- [Adivina la palabra](#16-adivina-la-palabra)
- [Generador de nombres para superhéroes](#17-generador-de-nombres-para-superhéroes)
- [Encuesta de comidas favoritas](#18-encuesta-de-comidas-favoritas)
- [Simulador de tweets](#19-simulador-de-tweets)
- [Historias locas (Mad Libs)](#20-historias-locas-mad-libs)


### 1) Hola fichero (crear y leer)

**Enunciado:** Crea un fichero `datos.txt` con el texto *"Hola Mundo desde PHP"* y, a continuación, léelo y muestra su contenido por pantalla.  
**Funciones/Comandos sugeridos:** `file_put_contents`, `file_get_contents`  

**Ejemplo de fichero generado:**

```code
datos.txt
Hola Mundo desde PHP
```

**Solución**

```php
<?php
$filename = "files/data.txt";
file_put_contents($filename, "Hola Mundo desde PHP");
echo file_get_contents($filename);
?>
```

---

### 2) Guardar números en un fichero

**Enunciado:** Almacena en `numeros.txt` los números del 1 al 10 (cada número en una línea). Luego léelo y muestra todos los números.  
**Funciones sugeridas:** `fopen`, `fwrite`, `fclose`, `file`  

**Ejemplo de fichero generado:**

```code
numeros.txt
1
2
3
...
10
```

**Solución**

```php
<?php
$file = fopen("files/numbers.txt", "w");

for ($i = 1; $i <= 10; $i++) {
    fwrite($file, "$i\n");
}

fclose($file);
foreach (file("files/numbers.txt") as $num) {
    print $num;
}
?>
```

---

### 3) Contar palabras en un fichero

**Enunciado:** Escribe un texto en `texto.txt`, luego haz que tu programa cuente cuántas palabras contiene ese archivo.  
**Funciones sugeridas:** `file_get_contents`, `str_word_count`  

**Ejemplo de fichero generado:**

```code
texto.txt
PHP es muy divertido y potente.
```

**Solución**

```php
<?php
$filename = "files/text.txt";
file_put_contents($filename, "Una frase super larga para hacer el conteo de palabras.");
echo str_word_count(file_get_contents($filename));
?>
```

---

### 4) Escribir y leer array en fichero

**Enunciado:** Guarda un array de nombres en `nombres.txt` (uno por línea). Después, léelo y muéstralos en lista numerada.  
**Funciones sugeridas:** `fopen`, `fwrite`, `fgets`  

**Ejemplo de fichero generado:**

```code
nombres.txt
Ana
Luis
Marta
Carlos
Julia
```

**Solución**

```php
<?php
$names = ["RJ", "Peter", "Eve", "Sage", "Milo"];

$file = fopen("files/names.txt", "w");
foreach ($names as $name) {
    fwrite($file, "$name\n");
}
fclose($file);

$file = fopen("files/names.txt", "r");
if ($file) {
    $counter = 1;
    while (($line = fgets($file)) !== false) {
        echo "{$counter}. " . $line;
        $counter++;
    }
    fclose($file);
}
?>
```

---

### 5) Copiar contenido de un fichero a otro

**Enunciado:** Copia el contenido de `origen.txt` en un archivo `copia.txt`.  
**Funciones sugeridas:** `copy`, `file_get_contents`, `file_put_contents`  

**Ejemplo de fichero inicial:**

```code
origen.txt
Este es el archivo original.
```

**Ejemplo de fichero resultante:**

```code
copia.txt
Este es el archivo original.
```

**Solución**

```php
<?php
$file = "files/origin.txt";
file_put_contents($file, "Este es un mensaje proporcionado por el archivo original.");
echo file_get_contents($file) . "\n";

$newfile = "files/copy.txt";
copy($file, $newfile);
echo file_get_contents($newfile) . "\n";
?>
```

---

### 6) Invertir el contenido de un fichero

**Enunciado:** Lee `frase.txt`, invierte el texto y guarda el resultado en `frase_invertida.txt`.  
**Funciones sugeridas:** `file_get_contents`, `strrev`, `file_put_contents`  

**Ejemplo de fichero inicial:**

```code
frase.txt
Hola PHP
```

**Ejemplo de fichero resultante:**

```code
frase_invertida.txt
PHP aloH
```

**Solución**

```php
<?php
$file = "files/phrase.txt";
file_put_contents($file, "Vive el momento y no lo desaproveches.");
$phrase = file_get_contents($file);
echo $phrase ."\n";

$invertedPhrase = strrev($phrase);

$newfile = "files/inverted_phrase.txt";
file_put_contents($newfile, $invertedPhrase);
echo file_get_contents($newfile) . "\n";
?>
```

---

### 7) Calcular suma desde fichero

**Enunciado:** Guarda números separados por comas en `datos_numericos.txt`. Léelos y calcula su suma.  
**Funciones sugeridas:** `file_get_contents`, `explode`, `array_sum`  

**Ejemplo de fichero:**

```code
datos_numericos.txt
10,20,30,40
```

**Solución**

```php
<?php
$filename = "files/numeric_data.txt";
file_put_contents($filename, "10,20,30,40,50");
$values = explode(",", file_get_contents($filename));
$sum = array_sum($values);
echo "The sum of " . implode(" + ", $values) . " is $sum"; 
?>
```

---

### 8) Crear fichero de multiplicaciones

**Enunciado:** Genera la tabla del 5 y guárdala en `tabla5.txt`. Luego muéstrala.  
**Funciones sugeridas:** `fopen`, `fwrite`, `file`  

**Ejemplo de fichero:**

```code
tabla5.txt
5 x 1 = 5
5 x 2 = 10
...
5 x 10 = 50
```

**Solución**

```php

```

---


### 9) Leer JSON desde fichero

**Enunciado:** Crea `datos.json` con información de personas (nombre y edad). Haz que el programa lo lea y muestre los datos.  
**Funciones sugeridas:** `file_get_contents`, `json_decode`  

**Ejemplo de fichero:**

```code
datos.json
[
  {"nombre": "Ana", "edad": 25},
  {"nombre": "Luis", "edad": 30}
]
```

**Solución**

```php
<?php
$json_url = "files/data.json";
$json = file_get_contents($json_url);
$data = json_decode($json);
foreach ($data as $person) {
    echo "$person->name is $person->age old.\n";
}
?>
```

---

### 10) Diario personal secreto

**Enunciado:** Guarda entradas con fecha y hora en `diario.txt`. Luego muéstralas todas.  

**Ejemplo de fichero:**

```code
diario.txt
[2025-09-24 10:00] Hoy aprendí PHP con ficheros 😄
[2025-09-24 12:00] Almorcé pizza mientras programaba.
```

**Solución**

```php

```

---

### 11) Ranking de videojuegos

**Enunciado:** Guarda juegos con puntuaciones en `ranking.txt`, ordénalos y muestra el top 3.  

**Ejemplo de fichero:**

```code
ranking.txt
Zelda: 10
Mario: 9
Sonic: 8
```

**Solución**

```php

```

---

### 12) Canción aleatoria

**Enunciado:** Guarda títulos en `canciones.txt` y muestra uno al azar.  

**Ejemplo de fichero:**

```code
canciones.txt
Hysteria
Bohemian Rhapsody
Africa
```

**Solución**

```php

```

---

### 13) Generador de excusas divertidas

**Enunciado:** Lee excusas desde `excusas.txt` y muestra una aleatoria.  

**Ejemplo de fichero:**

```code
excusas.txt
Mi perro se comió la tarea.
El Wi-Fi decidió tomarse el día libre.
Me abdujeron los marcianos.
```

**Solución**

```php
<?php
$filename = "files/excuses.txt";
$line = file($filename);
$randomLine = array_rand($line);
echo $line[$randomLine];
?>
```

---

### 14) Lista de chistes (rotativos)

**Enunciado:** Muestra un chiste distinto en cada ejecución desde `chistes.txt`.  

**Ejemplo de fichero:**

```code
chistes.txt
¿Sabes cuál es el colmo de un programador? Tener mala RAM-oria.
Ayer vi un bit triste… estaba des-bit-ido.
Yo no sudo, compilo.
```

**Solución**

```php

```

---

### 15) Adivina la palabra

**Enunciado:** Elige una palabra de `palabras.txt` y muestra solo 2 letras, el usuario debe adivinarla.  

**Ejemplo de fichero:**

```code
palabras.txt
manzana
platano
cereza
```

**Solución**

```php

```

---

### 16) Generador de nombres para superhéroes

**Enunciado:** Combina palabras de `adjetivos.txt` y `animales.txt`.  

**Ejemplo de ficheros:**

```code
adjetivos.txt
Increíble
Rápido
Misterioso
```

```code
animales.txt
Tigre
Águila
Lobo
```

**Solución**

```php

```

---

### 17) Encuesta de comidas favoritas

**Enunciado:** Guarda respuestas de usuarios en `comidas.txt` y genera ranking.  

**Ejemplo de fichero:**

```code
comidas.txt
pizza
sushi
pizza
pasta
```

**Solución**

```php

```

---

### 18) Simulador de tweets

**Enunciado:** Guarda tweets en `tweets.txt` con fecha y hora, muestra los últimos 5.  

**Ejemplo de fichero:**

```code
tweets.txt
[2025-09-24 09:30] Aprendiendo PHP con ejercicios divertidos #php
[2025-09-24 10:00] Otro día más programando 🚀
```

**Solución**

```php

```

---

### 19) Historias locas (Mad Libs)

**Enunciado:** Reemplaza placeholders en `plantilla.txt` con palabras aleatorias de otros ficheros.  

**Ejemplo de ficheros:**

```code
plantilla.txt
Un [animal] viajó a [lugar] para comer [comida].
```

```code
animales.txt
gato
dragón
perro
```

```code
lugares.txt
la Luna
Tokio
la playa
```

```code
comidas.txt
tacos
ramen
helado
```

**Solución**

```php

```