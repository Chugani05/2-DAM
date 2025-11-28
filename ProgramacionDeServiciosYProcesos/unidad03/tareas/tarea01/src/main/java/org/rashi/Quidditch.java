package org.rashi;

public class Quidditch {
    atomic boolean snitchAtrapada = false
    int puntosEquipoA = 0
    int puntosEquipoB = 0
    mutex m

    runnable CazadorA:
        while not snitchAtrapada:
            Sleep(RandomInt(200, 500))
            g = RandomInt(0,1) * 10
            if g > 0:
                lock(m); puntosEquipoA += g; unlock(m)
                print("Equipo A anota 10. Total A=" + puntosEquipoA)

    runnable CazadorB:
        while not snitchAtrapada:
            Sleep(RandomInt(200, 500))
            g = RandomInt(0,1) * 10
            if g > 0:
                lock(m); puntosEquipoB += g; unlock(m)
                print("Equipo B anota 10. Total B=" + puntosEquipoB)

    runnable Buscador:
        while not snitchAtrapada:
            Sleep(RandomInt(300, 700))
            if RandomInt(1,100) <= 15:
                snitchAtrapada = true
                print("¡Snitch dorada atrapada!")

    procedure main():
        t1 = Thread.start(CazadorA)
        t2 = Thread.start(CazadorB)
        t3 = Thread.start(Buscador)
        t1.join(); t2.join(); t3.join()
        print("Marcador final: A=" + puntosEquipoA + " B=" + puntosEquipoB)
}
