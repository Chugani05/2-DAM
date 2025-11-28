package org.rashi;

public class WizardsBattle {
    int energiaGandalf = 120
    int energiaSaruman = 120
    atomic boolean combateTerminado = false
    mutex m

    procedure lanzarHechizo(atacante, ref energiaRival):
        daño = RandomInt(8, 25)
        energiaRival = energiaRival - daño
        print(atacante + " lanza hechizo por " + daño + ". Energía rival: " + energiaRival)
        if energiaRival <= 0 and not combateTerminado:
            combateTerminado = true
            print(atacante + " gana la batalla mágica.")

    runnable Gandalf:
        while not combateTerminado:
            lock(m)
            if not combateTerminado: lanzarHechizo("Gandalf", energiaSaruman)
            unlock(m)
            Sleep(RandomInt(200, 600))

    runnable Saruman:
        while not combateTerminado:
            lock(m)
            if not combateTerminado: lanzarHechizo("Saruman", energiaGandalf)
            unlock(m)
            Sleep(RandomInt(200, 600))

    procedure main():
        t1 = Thread.start(Gandalf)
        t2 = Thread.start(Saruman)
        t1.join(); t2.join()
}
