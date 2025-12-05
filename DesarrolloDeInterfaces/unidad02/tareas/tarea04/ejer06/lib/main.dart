import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Paleta oscura con seedColor',
      home: const Material3Page(seedColor: Colors.blue),
    );
  }
}

class Material3Page extends StatelessWidget {
  final Color seedColor;

  const Material3Page({super.key, required this.seedColor});

  @override
  Widget build(BuildContext context) {
    final ColorScheme colorScheme = ColorScheme.fromSeed(
      seedColor: Colors.blue,
      brightness: Brightness.dark,
    );
    final ThemeData theme = ThemeData(
      colorScheme: colorScheme,
      useMaterial3: true,
    );

    return Theme(
      data: theme,
      child: Scaffold(
        appBar: AppBar(
          title: const Text('Paleta oscura con seedColor'),
        ),
        body: Center(
          child: Padding(
            padding: const EdgeInsets.all(16.0),
            child: Column(
              mainAxisSize: MainAxisSize.min,
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Text(
                  'Este es un texto usando el color primario.',
                  style: TextStyle(
                    fontSize: 20,
                    color: colorScheme.primary,
                  ),
                  textAlign: TextAlign.center,
                ),
                const SizedBox(height: 10),
                Icon(
                  Icons.star,
                  size: 40,
                  color: colorScheme.primary,
                ),
                const SizedBox(height: 10),
                ElevatedButton(
                  onPressed: () {},
                  child: const Text('Enviar'),
                ),
              ],
            ),
          ),
        ),
        floatingActionButton: FloatingActionButton(
          onPressed: () {
          },
          child: const Icon(Icons.add),
        ),
      ),
    );
  }
}