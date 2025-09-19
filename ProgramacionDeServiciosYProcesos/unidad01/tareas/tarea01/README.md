# Tarea 01 - Ejecución y comprensión de procesos en linux.

<div align=center>
    <img src="../../../../extras/vinyl.gif" alt="vinyl" width="80%">
</div>

## Contenido
- [Conceptos básicos (teoría)](#conceptos-básicos-teoría)
- [Práctica con comandos en Linux](#práctica-con-comandos-en-linux)
- [Procesos y jerarquía](#procesos-y-jerarquía)

## Conceptos básicos (teoría)

1. Define qué es un **proceso** y en qué se diferencia de un **programa**.

Un **proceso** es la ejecución de un programa y se considera una entidad activa porque realiza las acciones espeficadas en ese programa.

Básicamente, el **programa** y el **proceso** están relacionados, pero no son lo mismo. El **programa** es un código guardado en un disco duro para una fase previa del proceso. El **proceso** es un evento de ese programa en ejecución.

[Source](https://www.profesionalreview.com/2020/06/20/cual-es-la-diferencia-entre-un-programa-y-un-proceso/)

2. Explica qué es el **kernel** y su papel en la gestión de procesos.

El **kernel**, o núcleo, es el componente fundamental y central de un sistema operativo, actuando como un puente entre el hardware y el software para gestionar los recursos del sistema de manera eficiente y segura. Su papel en la **gestión de procesos** incluye la creación, terminación y cambio de estado de los procesos, la asignación del procesador (CPU) a cada uno de ellos, el control del acceso a la memoria y la coordinación de las interacciones con los dispositivos de hardware.

[Source](https://www.eaeprogramas.es/blog/negocio/tecnologia/que-es-el-kernel-cual-es-su-trabajo-y-como-funciona#:~:text=El%20Kernel%2C%20tambi%C3%A9n%20conocido%20como,el%20procesamiento%20de%20datos%20f%C3%ADsicos.)

3. ¿Qué son **PID** y **PPID**? Explica con un ejemplo.

El **PID** (Process ID), es un identificador numérico único asignado a cada proceso en ejecución en un sistema operativo.

El **PPID** (Parent Process ID) es el PID del proceso que lo inició. Todos los procesos tienen un padre, salvo el proceso 0. Este último es un pseudo-proceso que representa el inicio del sistema y que inicia al PID 1.

> Imagina una obra de teatro. Cada actor tiene un número en su vestuario que lo identifica en el escenario (ese es el PID). Pero cada actor pertenece a un grupo dirigido por un director, y ese director también tiene un número (ese es el PPID). Así, si el actor con PID 1203 está en escena, y su director tiene el número 456, entonces el PPID de ese actor es 456.

[Source PID](https://www.lenovo.com/es/es/glossary/what-is-pid/?orgRef=https%253A%252F%252Fwww.google.com%252F) ||
[Source PPID](https://blog.carreralinux.com.ar/2018/04/informacion-sobre-procesos-resumen-datos/)

4. Describe qué es un **cambio de contexto** y por qué es costoso.

El **cambio de contexto** es la alternancia sucesiva de la atención entre varias tareas diferentes no relacionadas entre sí a lo largo de la jornada laboral.

El **coste** real del cambio de contexto puede variar en función de factores como el sistema operativo específico, la arquitectura de hardware y el número de procesos que se cambian. Diferentes estudios y experimentos han proporcionado estimaciones de los costes de la conmutación de contexto, que van desde unos pocos segundos a decenas de microsegundos.

[Source](https://clickup.com/es-ES/blog/56983/cambio-de-contexto)

5. Explica qué es un **PCB (Process Control Block)** y qué información almacena.

El **bloque de control de proceso** (*Process Control Block*, PCB) es la estructura de datos central y más importante de un sistema operativo. Cada bloque de control de proceso contiene toda la información de un proceso que necesita un sistema operativo para su control. Estos bloques son leídos y/o modificados por casi todos los módulos de un sistema operativo, incluyendo aquellos que tienen que ver con la planificación, la asignación de recursos, el tratamiento de interrupciones y el análisis y supervisión del rendimiento. Puede decirse que el conjunto de los bloques de control de procesos definen el estado del sistema operativo.

[Source](https://lsi.vc.ehu.eus/pablogn/docencia/manuales/SO/TemasSOuJaen/DEFINICIONYCONTROLDEPROCESO/3Descripciondeunproceso.htm)

6. Diferencia entre **proceso padre** y **proceso hijo**.

Los procesos existen en jerarquías de padre-hijo. Un proceso iniciado por un programa o mandato es un **proceso padre**; un **proceso hijo** es el producto del proceso padre. Este hereda casi la totalidad del entorno de su padre (variables, etc.), pero sólo puede modificar su entorno, y no el del padre.

Un proceso padre puede tener varios procesos hijo, pero un proceso hijo sólo puede tener un padre.

[Source](https://www.ibm.com/docs/es/aix/7.2.0?topic=processes-) ||
[Source](https://www.investigacion.frc.utn.edu.ar/labsis/publicaciones/apunte_linux/mp.html#:~:text=COMANDO%20ps&text=Un%20proceso%20que%20crea%20a,y%20no%20el%20del%20padre.)

7. Explica qué ocurre cuando un proceso queda **huérfano** en Linux.

El kernel sabe que no va a recibir una llamada `wait`, así que en su lugar convierte a estos procesos en "huérfanos" y los pone bajo el cuidado de `init` (recuerda, la madre de todos los procesos). `init` eventualmente realizará la llamada al sistema `wait` para estos huérfanos para que puedan morir.

[Source](https://labex.io/es/lesson/process-termination)

8. ¿Qué es un proceso **zombie**? Da un ejemplo de cómo puede ocurrir.

Un **proceso zombie** es un proceso finalizado que ya no se ejecuta pero que sigue reconociéndose en la tabla de procesos (en otras palabras, tiene un número PID). Ya no se asigna espacio del sistema a dicho proceso. Los procesos zombie han sido cerrados y siguen existiendo en la tabla de procesos hasta que muere el proceso padre o se apaga el sistema y se reinicia. Los procesos zombie se muestran como <defunct> cuando se listan mediante el mandato `ps`.

> Un **proceso zombie** se puede imaginar como un caballero que fue enviado por su rey (el proceso padre) a cumplir una misión. El caballero cumple con la tarea y regresa al castillo, pero al llegar nadie le abre la puerta ni lo recibe oficialmente. Como no puede desaparecer hasta ser reconocido, queda vagando en la entrada del castillo sin hacer nada, sin luchar ni comer, pero ocupando espacio en la puerta. De la misma manera, un proceso zombie en un sistema ya terminó su trabajo, pero permanece en la tabla de procesos porque su padre aún no ha recogido su estado de salida.

[Source](https://www.ibm.com/docs/es/aix/7.2.0?topic=processes-)

9. Diferencia entre **concurrencia** y **paralelismo**.

La **concurrencia** se refiere a la capacidad de un sistema para ejecutar múltiples tareas que se solapan en el tiempo. En cambio, el **paralelismo** se refiere a la ejecución de múltiples procesos en distintos núcleos de un procesador, permitiendo un verdadero procesamiento simultáneo.

[Source](https://www.luisllamas.es/asincronia-concurrencia-paralelismo/)

10. Explica qué es un **hilo (thread)** y en qué se diferencia de un proceso.

Un **thread** es la unidad más pequeña a la cual un procesador puede asignar tiempo. Los threads poseerán la secuencia más pequeña de instrucciones a ejecutar. Los threads se crean, ejecutan y mueren dentro de los procesos, siendo capaces de compartir información entre ellos. 

En cambio, un **proceso** no es más que la instancia de un programa, el cual es creado y controlado por el sistema operativo. Los procesos son entidades independientes y no pueden compartir información entre ellos. Para que un proceso pueda ser ejecutado es necesario que este posea por lo menos un thread.

[Source](https://codigofacilito.com/articulos/threads-procesos)


## Práctica con comandos en Linux

1. Usa echo $$ para mostrar el PID del proceso actual.

```bash
2166
```

2. Usa echo $PPID para mostrar el PID del proceso padre.

```bash
2163
```

3. Ejecuta pidof systemd y explica el resultado.

```bash
1468
```

La ID del proceso del programa del conjunto de servicios, demonios y el sistema *systemd*, en ejecución, es 1468

4. Abre un programa gráfico (ejemplo: gedit) y usa pidof para obtener sus PID.

```bash
48224
```

5. Ejecuta ps -e y explica qué significan sus columnas.

```bash
    PID TTY          TIME CMD
      1 ?        00:00:07 systemd
      2 ?        00:00:00 kthreadd
      3 ?        00:00:00 pool_workqueue_release
      4 ?        00:00:00 kworker/R-rcu_gp
      5 ?        00:00:00 kworker/R-sync_wq
```

El comando `ps -e` en Linux lista todos los procesos del sistema, y la información se presenta típicamente en varias columnas:

- PID (Identificador del Proceso)
- TTY (terminal asociada)
- TIME (tiempo total de CPU que el proceso ha consumido)
- CMD (el nombre del comando que inició el proceso).

6. Ejecuta ps -f y observa la relación entre procesos padre e hijo.

```bash
UID          PID    PPID  C STIME TTY          TIME CMD
chugani     2166    2163  0 wrz18 pts/0    00:00:00 /bin/bash
chugani    46674    2166  0 02:09 pts/0    00:00:00 man pidof
chugani    46688   46674  0 02:09 pts/0    00:00:00 pager
chugani    49821    2166  0 02:21 pts/0    00:00:00 ps -f
```

Lo que se ve en la salida de *ps -f* es la jerarquía de procesos a partir de los identificadores:

- El proceso **2166 (`/bin/bash`)** corresponde a la terminal. Su padre (2163) probablemente sea el proceso de la terminal gráfico o de la sesión de login.
- Desde ese **bash** lancé el comando **`man pidof` (46674)**.
- Ese comando **`man`** no muestra el texto directamente, sino que abre otro proceso, el **`pager` (46688)**.

7. Usa ps -axf o pstree para mostrar el árbol de procesos y dibújalo.

<details>
    <summary>Answer</summary>

```bash
systemd─┬─ModemManager───3*[{ModemManager}]
        ├─NetworkManager───3*[{NetworkManager}]
        ├─3*[VBoxClient───VBoxClient───3*[{VBoxClient}]]
        ├─VBoxClient───VBoxClient───4*[{VBoxClient}]
        ├─VBoxDRMClient───5*[{VBoxDRMClient}]
        ├─VBoxService───8*[{VBoxService}]
        ├─accounts-daemon───3*[{accounts-daemon}]
        ├─avahi-daemon───avahi-daemon
        ├─containerd───8*[{containerd}]
        ├─cron
        ├─cups-browsed───3*[{cups-browsed}]
        ├─cupsd
        ├─dbus-daemon
        ├─dockerd───9*[{dockerd}]
        ├─fwupd───5*[{fwupd}]
        ├─2*[kerneloops]
        ├─polkitd───3*[{polkitd}]
        ├─redis-server───6*[{redis-server}]
        ├─rsyslogd───3*[{rsyslogd}]
        ├─rtkit-daemon───2*[{rtkit-daemon}]
        ├─sddm─┬─Xorg───{Xorg}
        │      ├─sddm-helper───lxqt-session─┬─agent───3*[{agent}]
        │      │                            ├─applet.py
        │      │                            ├─at-spi-bus-laun─┬─dbus-+
        │      │                            │                 └─4*[{a+
        │      │                            ├─at-spi2-registr───3*[{a+
        │      │                            ├─blueman-applet───4*[{bl+
        │      │                            ├─chrome_crashpad───2*[{c+
        │      │                            ├─code─┬─code───code───13+
        │      │                            │      ├─code───code───co+
        │      │                            │      ├─code───6*[{code}+
        │      │                            │      ├─code─┬─2*[bash]
        │      │                            │      │      └─17*[{code+
        │      │                            │      ├─code─┬─3*[code──+++
        │      │                            │      │      └─15*[{code+
        │      │                            │      ├─code───15*[{code+
        │      │                            │      ├─code───17*[{code+
        │      │                            │      └─39*[{code}]
        │      │                            ├─lubuntu-update───2*[{lu+
        │      │                            ├─lxqt-globalkeys───3*[{l+
        │      │                            ├─lxqt-notificati───2*[{l+
        │      │                            ├─lxqt-panel───8*[{lxqt-p+
        │      │                            ├─lxqt-policykit-───5*[{l+
        │      │                            ├─lxqt-powermanag───7*[{l+
        │      │                            ├─lxqt-runner───2*[{lxqt-+
        │      │                            ├─nm-tray───2*[{nm-tray}]
        │      │                            ├─openbox───{openbox}
        │      │                            ├─pcmanfm-qt───5*[{pcmanf+
        │      │                            ├─picom
        │      │                            ├─qlipper───2*[{qlipper}]
        │      │                            ├─qterminal─┬─bash─┬─man─+++
        │      │                            │           │      │     +++
        │      │                            │           │      ├─pstr+
        │      │                            │           │      └─2*[t+
        │      │                            │           └─2*[{qtermin+
        │      │                            ├─ssh-agent
        │      │                            ├─xscreensaver───xscreens+
        │      │                            └─3*[{lxqt-session}]
        │      └─{sddm}
        ├─snapd───11*[{snapd}]
        ├─switcheroo-cont───3*[{switcheroo-cont}]
        ├─systemd─┬─(sd-pam)
        │         ├─dbus-daemon
        │         ├─gvfs-afc-volume───4*[{gvfs-afc-volume}]
        │         ├─gvfs-goa-volume───3*[{gvfs-goa-volume}]
        │         ├─gvfs-gphoto2-vo───3*[{gvfs-gphoto2-vo}]
        │         ├─gvfs-mtp-volume───3*[{gvfs-mtp-volume}]
        │         ├─gvfs-udisks2-vo───4*[{gvfs-udisks2-vo}]
        │         ├─gvfsd─┬─gvfsd-trash───4*[{gvfsd-trash}]
        │         │       └─3*[{gvfsd}]
        │         ├─gvfsd-fuse───6*[{gvfsd-fuse}]
        │         ├─obexd
        │         ├─2*[pipewire───2*[{pipewire}]]
        │         ├─pipewire-pulse───2*[{pipewire-pulse}]
        │         ├─sh───xdg-desktop-por───2*[{xdg-desktop-por}]
        │         ├─snap───8*[{snap}]
        │         ├─wireplumber───5*[{wireplumber}]
        │         ├─xdg-desktop-por───6*[{xdg-desktop-por}]
        │         ├─xdg-desktop-por───4*[{xdg-desktop-por}]
        │         ├─xdg-desktop-por───2*[{xdg-desktop-por}]
        │         ├─xdg-document-po─┬─fusermount3
        │         │                 └─6*[{xdg-document-po}]
        │         └─xdg-permission-───3*[{xdg-permission-}]
        ├─systemd-journal
        ├─systemd-logind
        ├─systemd-resolve
        ├─systemd-timesyn───{systemd-timesyn}
        ├─systemd-udevd
        ├─udisksd───5*[{udisksd}]
        ├─unattended-upgr───{unattended-upgr}
        ├─upowerd───3*[{upowerd}]
        └─wpa_supplicant
```
</details>

8. Ejecuta top o htop y localiza el proceso con mayor uso de CPU.

```bash
    PID USER      PR  NI    VIRT    RES    SHR S  %CPU  %MEM 
   1889 chugani   20   0   21436   6400   6144 S  20,0   0,2 
```

9. Ejecuta sleep 100 en segundo plano y busca su PID con ps.

```bash
chugani@chugani-virtualbox:~$ sleep 100 &
[1] 56115

chugani@chugani-virtualbox:~$ ps
    PID TTY          TIME CMD
  53953 pts/0    00:00:00 bash
  56115 pts/0    00:00:00 sleep
  56132 pts/0    00:00:00 ps

```

10. Finaliza un proceso con kill <PID> y comprueba con ps que ya no está.

```bash
chugani@chugani-virtualbox:~$ xeyes &
[1] 55288

chugani@chugani-virtualbox:~$ ps -f
UID          PID    PPID  C STIME TTY          TIME CMD
chugani    53953   53950  0 02:38 pts/0    00:00:00 /bin/bash
chugani    55288   53953  0 02:42 pts/0    00:00:00 xeyes
chugani    55347   53953 99 02:42 pts/0    00:00:00 ps -f

chugani@chugani-virtualbox:~$ kill 55288

chugani@chugani-virtualbox:~$ ps -f
UID          PID    PPID  C STIME TTY          TIME CMD
chugani    53953   53950  0 02:38 pts/0    00:00:00 /bin/bash
chugani    55423   53953  0 02:42 pts/0    00:00:00 ps -f
[1]+  Terminated              xeyes

```


## Procesos y jerarquía

1. Identifica el **PID del proceso init/systemd** y explica su función.

```bash
chugani@chugani-virtualbox:~$ ps -e
UID        PID TTY          TIME CMD
chugani      1 ?        00:00:01 systemd
```

El proceso con PID 1,`systemd`, es el encargado de arrancar y gestionar todo el sistema cuando encendemos un ordenador. Su función principal es iniciar los servicios necesarios y mantener el sistema en funcionamiento de manera ordenada.

2. Explica qué ocurre con el **PPID** de un proceso hijo si su padre termina antes.

```bash
chugani@chugani-virtualbox:~$ ps -f
UID          PID    PPID  C STIME TTY          TIME CMD
chugani     2166    2163  0 wrz18 pts/0    00:00:00 /bin/bash
chugani    46977    2166  0 02:10 pts/0    00:00:00 man systemd
chugani    46986   46977  0 02:10 pts/0    00:00:00 pager

chugani@chugani-virtualbox:~$ kill 46977

chugani@chugani-virtualbox:~$ ps -f
UID          PID    PPID  C STIME TTY          TIME CMD
chugani     2166    2163  0 wrz18 pts/0    00:00:00 /bin/bash
```

Cuando el proceso padre termina, sus procesos hijos se convierten en huérfanos. Los procesos huérfanos son adoptados por el proceso init (PID 1) o por otro proceso adoptador del sistema. Si el proceso hijo ya ha terminado (como en mi caso), simplemente desaparece y no hay más interacción con su PPID anterior.


3. Ejecuta un programa que genere varios procesos hijos y observa sus PIDs con `ps`.

```bash
chugani@chugani-virtualbox:~$ ps -f
UID          PID    PPID  C STIME TTY          TIME CMD
chugani    25791   25517  0 15:02 pts/3    00:00:00 bash
chugani    89071   25791  0 16:33 pts/3    00:00:00 xeyes
chugani    89226   25791  0 16:34 pts/3    00:00:00 top
chugani    90660   25791  0 16:36 pts/3    00:00:00 ps -f
```

Desde una terminal de bash (proceso padre), ejecutamos varios procesos, estos pasan a ser procesos hijos del proceso bash. Esto se puede mirar usando `ps -f`, si nos fijamos en el **PPID(25791)** de los procesos del segundo al cuarto, veremos que es igual al **PID(25791)** del primer proceso.

4. Haz que un proceso quede en **estado suspendido** con `Ctrl+Z` y réanúdalo con `fg`.

```bash
chugani@chugani-virtualbox:~$ sleep 30
^Z
[1]+  Detenido                sleep 30

chugani@chugani-virtualbox:~$ fg
sleep 30
```

5. Lanza un proceso en **segundo plano** con `&` y obsérvalo con `jobs`.

```bash
chugani@chugani-virtualbox:~$ xeyes &
[1] 27372

chugani@chugani-virtualbox:~$ jobs
[1]+  Ejecutando              xeyes &
```

Con el comando `jobs`, puedes listar los trabajos en segundo plano y ver su estado, en este caso vemos q `xeyes`sigue en ejecución.

6. Explica la diferencia entre los estados de un proceso: **Running, Sleeping, Zombie, Stopped**.

- Running (R) : Procesos que están en ejecución.
- Sleeping (S) : Procesos que están esperando su turno para ejecutarse.
Waiting (D) : Procesos esperando a que se finalice alguna operación de Entrada/Salida.
- Zombie (Z) : Procesos que han terminado pero que siguen apareciendo en la tabla de procesos. Se pueden deber a errores de programación y pueden ser el síntoma de un sistema lento o que provoca problemas.
- Stopped (T): Procesos que han sido detenidos, generalmente por una señal enviada por el usuario o por el sistema, por ejemplo, mediante el comando `kill -STOP` o al suspender un proceso con `Ctrl+Z`. Estos procesos están en pausa y no ejecutan instrucciones hasta que se reanuden.

7. Usa `ps -eo pid,ppid,stat,cmd` para mostrar los estados de varios procesos.

```bash
chugani@chugani-virtualbox:~$ ps -eo pid,ppid,stat,cmd
UID        PID    PPID STAT CMD
chugani      1       0 Ss   /sbin/init splash
chugani      2       0 S    [kthreadd]
chugani      3       2 S    [pool_workqueue_release]
chugani      4       2 I<   [kworker/R-rcu_g]
chugani      5       2 I<   [kworker/R-rcu_p]
```

8. Ejecuta `watch -n 1 ps -e` y observa cómo cambian los procesos en tiempo real.

`watch -n 1` ejecuta repetidamente un comando cada 1 segundo, `ps -e` muestra todos los procesos en ejecución en el sistema.


9. Explica la diferencia entre ejecutar un proceso con `&` y con `nohup`.

Un proceso con `&` lo pone en segundo plano, permitiendo el uso de la terminal, pero el proceso termina al cerrar la sesión. En cambio, `nohup` hace que un proceso ignore la señal de hangup (SIGHUP), permitiéndole continuar ejecutándose incluso después de cerrar la terminal o la sesión, y redirige su salida a un archivo `nohup.out` por defecto

10. Usa `ulimit -a` para ver los límites de recursos de procesos en tu sistema.

```bash
real-time non-blocking time  (microseconds, -R) unlimited
core file size              (blocks, -c) 0
data seg size               (kbytes, -d) unlimited
scheduling priority                 (-e) 0
file size                   (blocks, -f) unlimited
pending signals                     (-i) 125404
max locked memory           (kbytes, -l) 4026016
max memory size             (kbytes, -m) unlimited
open files                          (-n) 1024
pipe size                (512 bytes, -p) 8
POSIX message queues         (bytes, -q) 819200
real-time priority                  (-r) 0
stack size                  (kbytes, -s) 8192
cpu time                   (seconds, -t) unlimited
max user processes                  (-u) 125404
virtual memory              (kbytes, -v) unlimited
file locks                          (-x) unlimited
```