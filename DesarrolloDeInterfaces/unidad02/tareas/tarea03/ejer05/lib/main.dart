import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

void main() {
  runApp(
    ChangeNotifierProvider(
      create: (_) => ContadorProvider(),
      child: MyApp(),
    ),
  );
}

class ContadorProvider extends ChangeNotifier {
  int _contador = 0;

  int get contador => _contador;

  void incrementar() {
    _contador++;
    notifyListeners();
  }

  void decrementar() {
    _contador--;
    notifyListeners();
  }

  void reiniciar() {
    _contador = 0;
    notifyListeners();
  }
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Contador Compartido',
      initialRoute: '/',
      routes: {
        '/': (_) => PantallaA(),
        '/b': (_) => PantallaB(),
      },
    );
  }
}

class PantallaA extends StatelessWidget {
  const PantallaA({super.key});

  @override
  Widget build(BuildContext context) {
    final contador = context.watch<ContadorProvider>();

    return Scaffold(
      appBar: AppBar(title: Text('Pantalla A')),
      body: Center(
        child: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            Text('Contador: ${contador.contador}', style: TextStyle(fontSize: 24)),
            Row(
              mainAxisSize: MainAxisSize.min,
              children: [
                ElevatedButton(
                  onPressed: () => context.read<ContadorProvider>().decrementar(),
                  child: Text('-'),
                ),
                SizedBox(width: 10),
                ElevatedButton(
                  onPressed: () => context.read<ContadorProvider>().incrementar(),
                  child: Text('+'),
                ),
              ],
            ),
            SizedBox(height: 20),
            ElevatedButton(
              onPressed: () => Navigator.pushNamed(context, '/b'),
              child: Text('Ir a Pantalla B'),
            ),
          ],
        ),
      ),
    );
  }
}

class PantallaB extends StatelessWidget {
  const PantallaB({super.key});

  @override
  Widget build(BuildContext context) {
    final contador = context.watch<ContadorProvider>();

    return Scaffold(
      appBar: AppBar(title: Text('Pantalla B')),
      body: Center(
        child: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            Text('Valor actual del contador:', style: TextStyle(fontSize: 18)),
            Text('${contador.contador}', style: TextStyle(fontSize: 48, fontWeight: FontWeight.bold)),
            SizedBox(height: 20),
            ElevatedButton(
              onPressed: () => context.read<ContadorProvider>().reiniciar(),
              child: Text('Reiniciar contador'),
            ),
            SizedBox(height: 20),
            ElevatedButton(
              onPressed: () => Navigator.pop(context),
              child: Text('Volver a Pantalla A'),
            ),
          ],
        ),
      ),
    );
  }
}