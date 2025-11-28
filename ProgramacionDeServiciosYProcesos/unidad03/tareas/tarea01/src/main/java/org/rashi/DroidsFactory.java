package org.rashi;

import java.util.concurrent.BlockingQueue;

public class DroidsFactory {
    BlockingQueue<String> ensamblados = new BlockingQueue()
    int N = 10
    atomic int activados = 0

    runnable Ensamblador:
        for i in 1..N:
            Sleep(RandomInt(100, 300))
            d = "Droid-" + i
            print("Ensamblado " + d)
            ensamblados.put(d)

    runnable Activador:
        local int cuenta = 0
        while cuenta < N:
            d = ensamblados.take()
            print("Activado " + d)
            activados = activados + 1
            cuenta = cuenta + 1
            Sleep(RandomInt(50, 150))

    procedure main():
        tE = Thread.start(Ensamblador)
        tA = Thread.start(Activador)
        tE.join(); tA.join()
}
