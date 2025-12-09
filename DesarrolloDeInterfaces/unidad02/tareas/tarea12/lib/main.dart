import 'package:flutter/material.dart';
import 'dart:async';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Reactor Overload',
      home: ReactorOverloadPage(),
    );
  }
}

class ReactorOverloadPage extends StatefulWidget {
  const ReactorOverloadPage({super.key});

  @override
  State<ReactorOverloadPage> createState() => _ReactorOverloadPageState();
}

class _ReactorOverloadPageState extends State<ReactorOverloadPage> {
  double energia = 0;
  int segundos = 0;
  late Timer timer;
  bool gameOver = false;
  final int limiteSegundos = 60;

  @override
  void initState() {
    super.initState();

    timer = Timer.periodic(const Duration(seconds: 1), (timer) {
      if (gameOver) return;

      setState(() {
        energia += 10;
        segundos += 1;

        if (energia >= 100 || segundos >= limiteSegundos) {
          gameOver = true;
          timer.cancel();
        }
      });
    });
  }

  void descargar() {
    setState(() {
      energia -= 10;
      if (energia < 0) energia = 0;
    });
  }

  @override
  void dispose() {

    timer.cancel();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    String mensaje = '';
    if (gameOver) {
      if (energia >= 100) {
        mensaje = '¡Reactor explotó!';
      } else if (segundos >= limiteSegundos) {
        mensaje = '¡Tiempo límite alcanzado!';
      }
    }

    return Scaffold(
      appBar: AppBar(title: const Text('Reactor Overload')),
      body: Padding(
        padding: const EdgeInsets.all(20),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Text(
              'Nivel: ${energia.toInt()}%',
              style: const TextStyle(fontSize: 22),
            ),
            const SizedBox(height: 10),
            LinearProgressIndicator(
              value: energia / 100,
              minHeight: 20,
            ),
            const SizedBox(height: 10),
            Text('Tiempo: $segundos s'),
            const SizedBox(height: 10),
            if (gameOver)
              Text(
                mensaje,
                style: const TextStyle(
                  fontSize: 24,
                  fontWeight: FontWeight.bold,
                  color: Colors.red,
                ),
              ),
            const SizedBox(height: 30),
            ElevatedButton(
              onPressed: gameOver ? null : descargar,
              child: const Text('Descargar energía'),
            ),
            const SizedBox(height: 40),
            if (!gameOver)
              Text(
                'Mantén la energía estable durante $limiteSegundos segundos.',
                style: const TextStyle(fontSize: 16),
                textAlign: TextAlign.center,
              ),
          ],
        ),
      ),
    );
  }
}