package org.rashi;

public class MillenniumFalcon {
    atomic boolean fin = false
    atomic boolean destruida = false
    int tiempoMisionMS = 4000
    long inicio

    atomic int velocidad = 0
    atomic int escudos = 100

    runnable HanSolo:
        while not fin:
            velocidad += RandomInt(5, 15)
            if RandomInt(1,100) <= 5:
                destruida = true; fin = true
                print("Fallo de hiperimpulsor. ¡La nave se destruye!")
            Sleep(150)
            if now() - inicio >= tiempoMisionMS: fin = true

    runnable Chewbacca:
        while not fin:
            escudos += RandomInt(-10, +5)
            if escudos <= 0:
                destruida = true; fin = true
                print("¡Escudos agotados! La nave se destruye!")
            Sleep(150)
            if now() - inicio >= tiempoMisionMS: fin = true

    procedure main():
        inicio = now()
        t1 = Thread.start(HanSolo)
        t2 = Thread.start(Chewbacca)
        t1.join(); t2.join()
        if not destruida:
            print("¡Han y Chewie escapan! Vel=" + velocidad + ", Escudos=" + escudos)
}
