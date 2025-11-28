import org.rashi.Quidditch;

public class QuidditchTest {

    test Quidditch_terminaCuandoSnitchAtrapada():
    capturarSalida()
    q = new Quidditch()
    q.main()
    salida = obtenerSalida()
    assert( salida.contains("¡Snitch dorada atrapada!") )
    assert( salida.contains("Marcador final:") )
}
