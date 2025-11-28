package org.rashi;

public class PokemonBattle {
    atomic boolean juegoTerminado = false
    int hpPikachu = 100
    int hpCharmander = 100
    String turno = "Pikachu"        // alternancia estricta
    mutex m
    cond turnoCambio

    procedure atacar(atacante, ref hpObjetivo):
        daño = RandomInt(5, 20)
        hpObjetivo = hpObjetivo - daño
        print(atacante + " ataca con " + daño + " de daño. HP rival: " + hpObjetivo)
        if hpObjetivo <= 0 and not juegoTerminado:
            juegoTerminado = true
            print(atacante + " ha ganado la batalla!")
        Sleep(RandomInt(200, 600))

    runnable HiloPikachu:
        while not juegoTerminado:
            lock(m)
            while turno != "Pikachu" and not juegoTerminado:
                wait(turnoCambio, m)
            if juegoTerminado: unlock(m); break
            atacar("Pikachu", hpCharmander)
            turno = "Charmander"
            signal(turnoCambio)
            unlock(m)

    runnable HiloCharmander:
        while not juegoTerminado:
            lock(m)
            while turno != "Charmander" and not juegoTerminado:
                wait(turnoCambio, m)
            if juegoTerminado: unlock(m); break
            atacar("Charmander", hpPikachu)
            turno = "Pikachu"
            signal(turnoCambio)
            unlock(m)

    procedure main():
        t1 = Thread.start(HiloPikachu)
        t2 = Thread.start(HiloCharmander)
        t1.join(); t2.join()
}
