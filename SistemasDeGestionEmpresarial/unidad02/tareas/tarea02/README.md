# Instalación y configuración de Odoo

<div align=center>
    <img src="../../../../extras/vinyl.gif" alt="vinyl" width="80%">
</div>

## Instalación de Odoo

1. Descargamos ambos ficheros `docker-compose.yml` y los guardamos en su debida carpeta, deberia quedar una estructura parecida a la siguiente: 

```bash
Oddo
 ├── desarrollo
 │   ├── docker-compose.yml
 │
 └── produccion
     ├── docker-compose.yml
```

2. Desde dos terminal distintas accedemos a `Oddo/desarrollo` y `Oddo/produccion` y lanzamos el sigueinte comando:

```bash
docker compose up -d
```

3. Una vez hecho esto dentro de ambos archivos, ya hemos despregado oddo en entrorno produccion y desarrollo. Pra acceder usamos `localhost`.

**Desarrollo [localhost:8069](http://localhost:8069/)**
<div align=center>
    <img src="./imgs/desarrollo.png" alt="pagina principal de desarrollo de oddo" width="70%">
</div>

**Producción [localhost:8070](http://localhost:8070/)**
<div align=center>
    <img src="./imgs/produccion.png" alt="pagina principal de producción de oddo" width="70%">
</div>

## Accede a tu Odoo (producción o desarrollo).
<div align=center>
    <img src="./imgs/acceso.png" alt="accede a oddo" width="70%">
</div>

## Recorre el menú de aplicaciones y nota que puedes instalar módulos.
<div align=center>
    <img src="./imgs/menu.png" alt="recorre el menú" width="70%">
</div>

## Instala CRM y Contactos.
<div align=center>
    <img src="./imgs/instalar.png" alt="CRM y contactos" width="70%">
</div>

## Crea 3 clientes ficticios con datos básicos (nombre, email, teléfono).
<div align=center>
    <img src="./imgs/clients.png" alt="clientes" width="70%">
</div>

## Activa el modo desarrollador (en Ajustes) y mira cómo aparecen más opciones.

Vamos a ver un antes y un después de acticar el modo desarollador mediente un ejemplo:

**Before**
<div align=center>
    <img src="./imgs/before.png" alt="antes de activar modo desarrollador" width="70%">
</div>

**After**
<div align=center>
    <img src="./imgs/after.png" alt="despues de activar modo desarrollador" width="70%">
</div>