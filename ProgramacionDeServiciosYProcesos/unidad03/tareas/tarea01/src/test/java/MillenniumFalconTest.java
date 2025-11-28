public class MillenniumFalconTest {

    test MilleniumFalcon_finalizaConEscapeODestruccion():
    capturarSalida()
    m = new MilleniumFalcon()
    m.main()
    salida = obtenerSalida()
    assert( salida.contains("se destruye") xor salida.contains("escapan") )
}
