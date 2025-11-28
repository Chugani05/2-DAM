package org.rashi;

public class Tardis {
    atomic boolean destinoAlcanzado = false
    atomic String eraGanadora = null

    runnable Viaje(era):
        tiempo = RandomInt(500, 2000)
        Sleep(tiempo)
        if not destinoAlcanzado:
            destinoAlcanzado = true
            eraGanadora = era
            print("La TARDIS llegó primero a " + era)

    procedure main():
        eras = ["Roma Antigua", "Futuro Lejano", "Era Victoriana", "Año 3000"]
        hilos = []
        for e in eras: hilos.add(Thread.start(Viaje(e)))
        for t in hilos: t.join()
}

