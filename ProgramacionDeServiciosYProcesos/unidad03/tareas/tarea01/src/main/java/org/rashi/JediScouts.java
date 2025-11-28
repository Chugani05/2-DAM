package org.rashi;

public class JediScouts {
    atomic boolean pistaEncontrada = false
    atomic String ganador = null

    runnable Jedi(nombre, planeta):
        Sleep(RandomInt(400, 1500))
        if not pistaEncontrada:
            pistaEncontrada = true
            ganador = nombre
            print(nombre + " halló una pista en " + planeta + ". Fin de búsqueda.")

    procedure main():
        t1 = Thread.start(Jedi("Kenobi", "Tatooine"))
        t2 = Thread.start(Jedi("Skywalker", "Dagobah"))
        t1.join(); t2.join()
}
