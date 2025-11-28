package org.rashi;

public class ThorHulkForce {
    durationMS = 5000
    atomic boolean tiempoTerminado = false
    atomic int totalThor = 0
    atomic int totalHulk = 0

    runnable Temporizador:
        Sleep(durationMS)
        tiempoTerminado = true
        print("¡Tiempo!")

    runnable Thor:
        while not tiempoTerminado:
            peso = RandomInt(5, 20)
            totalThor += peso
            Sleep(RandomInt(50, 120))

    runnable Hulk:
        while not tiempoTerminado:
            peso = RandomInt(5, 20)
            totalHulk += peso
            Sleep(RandomInt(50, 120))

    procedure main():
        t0 = Thread.start(Temporizador)
        t1 = Thread.start(Thor)
        t2 = Thread.start(Hulk)
        t0.join(); t1.join(); t2.join()
        if totalThor > totalHulk:
            print("Thor gana con " + totalThor + " vs " + totalHulk)
        else if totalHulk > totalThor:
            print("Hulk gana con " + totalHulk + " vs " + totalThor)
        else:
            print("Empate: " + totalThor)
}
