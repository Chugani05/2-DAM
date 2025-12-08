import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Estabilizador de energía',
      theme: ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: const EstabilizadorPage(),
    );
  }
}

class EstabilizadorPage extends StatefulWidget {
  const EstabilizadorPage({super.key});

  @override
  State<EstabilizadorPage> createState() => _EstabilizadorPageState();
}

class _EstabilizadorPageState extends State<EstabilizadorPage> {

  double energia = 50;

  void subirEnergia() {
    setState(() {
      energia += 10;
      if (energia > 100) {
        energia = 100;
      }
    });
  }

  void bajarEnergia() {
    setState(() {
      energia -= 10;
      if (energia < 0) {
        energia = 0;
      }
    });
  }

  @override
  Widget build(BuildContext context) {

    return Scaffold(
      appBar: AppBar(title: const Text('Estabilizador de energía')),

      body: Padding(
        padding: const EdgeInsets.all(20),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [

            Text(
              'Energía: ${energia.toInt()}%',
              style: const TextStyle(fontSize: 22),
            ),

            const SizedBox(height: 20),

            LinearProgressIndicator(
              value: energia / 100,
              minHeight: 20,
            ),

            const SizedBox(height: 30),

            Row(
              mainAxisAlignment: MainAxisAlignment.spaceEvenly,
              children: [

                ElevatedButton(
                  onPressed: bajarEnergia,
                  child: const Text('-10'),
                ),

                ElevatedButton(
                  onPressed: subirEnergia,
                  child: const Text('+10'),
                ),

              ],
            ),

            const SizedBox(height: 30),

            // Opcional: mensaje si llega exactamente a 100%
            if (energia == 100)
              Text(
                '¡Nivel de energía estabilizado al 100%!',
                style: TextStyle(
                  fontSize: 18,
                  color: Colors.green,
                  fontWeight: FontWeight.bold,
                ),
              ),

          ],
        ),
      ),
    );
  }
}