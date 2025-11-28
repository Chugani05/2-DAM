public class PokemonBattleTest {
    
    test BatallaPokemon_debeHaberGanador():
    capturarSalida()
    juego = new BatallaPokemon()
    juego.main()
    salida = obtenerSalida()
    assert( salida.contains("ha ganado la batalla!") )
    assert( juego.juegoTerminado == true )
    assert( juego.hpPikachu <= 0 or juego.hpCharmander <= 0 )
}
