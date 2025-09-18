# Tarea 01 - Ejecución y comprensión de procesos en linux.

## Conceptos básicos (teoría)

1. Define qué es un **proceso** y en qué se diferencia de un **programa**.  
2. Explica qué es el **kernel** y su papel en la gestión de procesos.  
3. ¿Qué son **PID** y **PPID**? Explica con un ejemplo.  
4. Describe qué es un **cambio de contexto** y por qué es costoso.  
5. Explica qué es un **PCB (Process Control Block)** y qué información almacena.  
6. Diferencia entre **proceso padre** y **proceso hijo**.  
7. Explica qué ocurre cuando un proceso queda **huérfano** en Linux.  
8. ¿Qué es un proceso **zombie**? Da un ejemplo de cómo puede ocurrir.  
9. Diferencia entre **concurrencia** y **paralelismo**.  
10. Explica qué es un **hilo (thread)** y en qué se diferencia de un proceso.  


## Práctica con comandos en Linux

11. Usa echo $$ para mostrar el PID del proceso actual.

```bash

```

12. Usa echo $PPID para mostrar el PID del proceso padre.

```bash

```

13. Ejecuta pidof systemd y explica el resultado.

```bash

```

14. Abre un programa gráfico (ejemplo: gedit) y usa pidof para obtener sus PID.

```bash

```

15. Ejecuta ps -e y explica qué significan sus columnas.

```bash

```

16. Ejecuta ps -f y observa la relación entre procesos padre e hijo.

```bash

```

17. Usa ps -axf o pstree para mostrar el árbol de procesos y dibújalo.

```bash

```

18. Ejecuta top o htop y localiza el proceso con mayor uso de CPU.

```bash

```

19. Ejecuta sleep 100 en segundo plano y busca su PID con ps.

```bash

```

20. Finaliza un proceso con kill <PID> y comprueba con ps que ya no está.

```bash

```


## Procesos y jerarquía

21. Identifica el **PID del proceso init/systemd** y explica su función.

```bash

```

22. Explica qué ocurre con el **PPID** de un proceso hijo si su padre termina antes.

```bash

```

23. Ejecuta un programa que genere varios procesos hijos y observa sus PIDs con `ps`.

```bash

```

24. Haz que un proceso quede en **estado suspendido** con `Ctrl+Z` y réanúdalo con `fg`.

```bash

```

25. Lanza un proceso en **segundo plano** con `&` y obsérvalo con `jobs`.

```bash

```

26. Explica la diferencia entre los estados de un proceso: **Running, Sleeping, Zombie, Stopped**.

```bash

```

27. Usa `ps -eo pid,ppid,stat,cmd` para mostrar los estados de varios procesos.

```bash

```

28. Ejecuta `watch -n 1 ps -e` y observa cómo cambian los procesos en tiempo real.

```bash

```

29. Explica la diferencia entre ejecutar un proceso con `&` y con `nohup`.

```bash

```

30. Usa `ulimit -a` para ver los límites de recursos de procesos en tu sistema.

```bash

```