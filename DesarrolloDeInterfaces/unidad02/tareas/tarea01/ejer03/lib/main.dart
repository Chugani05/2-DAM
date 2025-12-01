import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

void main() {
  runApp(
    ChangeNotifierProvider(
      create: (_) => VolumenProvider(),
      child: MyApp(),
    ),
  );
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Control de Volumen',
      home: ControlVolumenScreen(),
    );
  }
}

class VolumenProvider extends ChangeNotifier {
  double _volumen = 50;

  double get volumen => _volumen;

  set volumen(double nuevoVolumen) {
    if (_volumen != nuevoVolumen) {
      _volumen = nuevoVolumen;
      notifyListeners();
    }
  }
}

class ControlVolumenScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    final volumenProvider = context.watch<VolumenProvider>();
    final volumen = volumenProvider.volumen;

    IconData getIcon() {
      if (volumen == 0) {
        return Icons.volume_off;
      } else if (volumen < 50) {
        return Icons.volume_down;
      } else {
        return Icons.volume_up;
      }
    }

    return Scaffold(
      appBar: AppBar(
        title: Text('Control de Volumen'),
      ),
      body: Center(
        child: Padding(
          padding: const EdgeInsets.all(20.0),
          child: Column(
            mainAxisSize: MainAxisSize.min,
            children: [
              Text(
                'Volumen: ${volumen.round()}%',
                style: TextStyle(
                  fontSize: 20,
                  fontWeight: FontWeight.bold,
                ),
              ),
              SizedBox(height: 10),
              Icon(
                getIcon(),
                size: 100,
              ),
              SizedBox(height: 30),
              Slider(
                min: 0,
                max: 100,
                divisions: 100,
                value: volumen,
                label: '${volumen.round()}%',
                onChanged: (nuevoValor) {
                  context.read<VolumenProvider>().volumen = nuevoValor;
                },
              ),
            ],
          ),
        ),
      ),
    );
  }
}