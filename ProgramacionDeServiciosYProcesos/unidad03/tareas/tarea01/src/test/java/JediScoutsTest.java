public class JediScoutsTest {

    test ExploradoresJediUnSoloGanador():
    capturarSalida()
    e = new ExploradoresJedi()
    e.main()
    salida = obtenerSalida()
    assert( e.pistaEncontrada == true )
    assert( salida.count("halló una pista") == 1 )
}
