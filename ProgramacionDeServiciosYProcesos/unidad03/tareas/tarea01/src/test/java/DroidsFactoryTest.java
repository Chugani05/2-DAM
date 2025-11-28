public class DroidsFactoryTest {

    test FabricaDroidsNoSeActivaAntesDeEnsamblaryCuentaCorrecta():
    capturarSalida()
    fab = new FabricaDroids()
    fab.main()
    salida = obtenerSalida()
    for k in 1..fab.N:
        idxE = salida.indexOf("Ensamblado Droid-" + k)
        idxA = salida.indexOf("Activado Droid-" + k)
        assert( idxE != -1 and idxA != -1 and idxE < idxA )
    assert( fab.activados == fab.N )
}
