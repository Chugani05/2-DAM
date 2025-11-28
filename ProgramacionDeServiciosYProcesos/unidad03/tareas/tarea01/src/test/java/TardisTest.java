public class TardisTest {

    test TardisExisteUnaEraGanadora():
    capturarSalida()
    t = new TARDIS()
    t.main()
    salida = obtenerSalida()
    assert( t.destinoAlcanzado == true )
    assert( t.eraGanadora != null )
    assert( salida.count("llegó primero") == 1 )
}
