public class ThorHulkForceTest {

    test FuerzaThorHulk_terminaPorTiempo_yDeclaraResultado():
    capturarSalida()
    f = new FuerzaThorHulk()
    f.main()
    salida = obtenerSalida()
    assert( salida.contains("¡Tiempo!") )
    assert( salida.contains("gana") or salida.contains("Empate") )
}
