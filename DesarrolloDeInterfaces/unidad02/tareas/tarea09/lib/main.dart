import 'package:flutter/material.dart';
import 'dart:math';
import 'dart:async';

void main() {
  runApp(const BotonSaltarinApp());
}

class BotonSaltarinApp extends StatelessWidget {
  const BotonSaltarinApp({super.key});

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      debugShowCheckedModeBanner: false,
      home: JuegoBotonSaltarin(),
    );
  }
}

// ---------------- CONTROLADOR ----------------

class GameController {
  int _puntos = 0;
  int _tiempo = 15;

  double _top = 100;
  double _left = 100;

  final Random _random = Random();

  // Para controlar si el juego ha terminado
  bool _tiempoTerminado = false;

  // Para controlar si el jugador ha ganado
  bool _haGanado = false;

  // Getter para puntos
  int get puntos => _puntos;

  // Getter para tiempo
  int get tiempo => _tiempo;

  // Getter para posición
  double get top => _top;
  double get left => _left;

  // Getter para estado de tiempo terminado
  bool get tiempoTerminado => _tiempoTerminado;

  // Getter para estado de ganar
  bool get haGanado => _haGanado;

  // Método para mover el botón a una posición aleatoria
  void moverBoton() {
    _top = _random.nextDouble() * 500; // altura del lienzo
    _left = _random.nextDouble() * 900; // ancho del lienzo
  }

  // Método para disminuir tiempo
  void reducirTiempo() {
    if (_tiempo > 0) {
      _tiempo--;
      if (_tiempo == 0) {
        _tiempoTerminado = true;
      }
    }
  }

  // Método para sumar puntos
  void sumarPunto() {
    _puntos++;
    // Puedes definir cuántos puntos se necesitan para ganar
    if (_puntos >= 10) {
      _haGanado = true;
    }
  }

  // Método para reiniciar el juego (opcional)
  void reiniciar() {
    _puntos = 0;
    _tiempo = 15;
    _tiempoTerminado = false;
    _haGanado = false;
    moverBoton();
  }
}

// --------------- WIDGET PRINCIPAL ----------------

class JuegoBotonSaltarin extends StatefulWidget {
  const JuegoBotonSaltarin({super.key});

  @override
  State<JuegoBotonSaltarin> createState() => _JuegoSaltarinState();
}

class _JuegoSaltarinState extends State<JuegoBotonSaltarin> {
  final GameController game = GameController();
  late Timer timer;

  @override
  void initState() {
    super.initState();

    // Iniciar el Timer para que reduzca el tiempo cada segundo
    timer = Timer.periodic(const Duration(seconds: 1), (Timer t) {
      if (!game.tiempoTerminado && !game.haGanado) {
        setState(() {
          game.reducirTiempo();

          if (game.tiempoTerminado || game.haGanado) {
            t.cancel();
          }
        });
      }
    });

    // Posicionar inicialmente el botón
    game.moverBoton();
  }

  void pulsarBoton() {
    if (game.tiempoTerminado || game.haGanado) return;

    setState(() {
      game.sumarPunto();
      game.moverBoton();
    });
  }

  @override
  void dispose() {
    timer.cancel();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    // Mensajes para cuando termina el juego o gana
    String mensaje = '';
    if (game.tiempoTerminado) {
      mensaje = '¡Se acabó el tiempo!';
    } else if (game.haGanado) {
      mensaje = '¡Ganaste!';
    }

    return Scaffold(
      appBar: AppBar(title: const Text('Botón saltarín')),
      body: Stack(
        children: [
          // Información del juego
          Positioned(
            top: 30,
            left: 20,
            child: Text(
              'Tiempo: ${game.tiempo}  |  Puntos: ${game.puntos}',
              style: const TextStyle(
                fontSize: 18,
                fontWeight: FontWeight.bold,
              ),
            ),
          ),

          // Botón en movimiento
          Positioned(
            top: game.top,
            left: game.left,
            child: ElevatedButton(
              onPressed: (game.tiempoTerminado || game.haGanado)
                  ? null
                  : pulsarBoton,
              child: const Text('¡Púlsame!'),
            ),
          ),

          // Mostrar mensaje cuando termina o gana
          if (game.tiempoTerminado || game.haGanado)
            Center(
                child: Text(
                  mensaje,
                  style: const TextStyle(
                    fontSize: 24,
                    fontWeight: FontWeight.bold,
                    color: Colors.black,
                  ),
                  textAlign: TextAlign.center,
                ),
              ),

          // Botón para reiniciar el juego
          Positioned(
            bottom: 20,
            right: 20,
            child: ElevatedButton(
              onPressed: () {
                setState(() {
                  game.reiniciar();
                  // Reiniciar el temporizador
                  timer.cancel();
                  timer = Timer.periodic(const Duration(seconds: 1), (Timer t) {
                    if (!game.tiempoTerminado && !game.haGanado) {
                      setState(() {
                        game.reducirTiempo();

                        if (game.tiempoTerminado || game.haGanado) {
                          t.cancel();
                        }
                      });
                    }
                  });
                });
              },
              child: const Text('Reiniciar'),
            ),
          ),
        ],
      ),
    );
  }
}