public class WizardsBattleTest {

    test BatallaMagos_debeHaberGanadorYTerminar():
    capturarSalida()
    b = new BatallaMagos()
    b.main()
    salida = obtenerSalida()
    assert( salida.contains("gana la batalla mágica.") )
    assert( b.combateTerminado == true )
    assert( b.energiaGandalf <= 0 or b.energiaSaruman <= 0 )
}
