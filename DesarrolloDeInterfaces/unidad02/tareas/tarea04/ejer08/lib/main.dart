import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Tema tipográfico personalizado',
      home: const Material3Page(seedColor: Colors.blue),
    );
  }
}

class Material3Page extends StatelessWidget {
  final Color seedColor;

  const Material3Page({super.key, required this.seedColor});

  @override
  Widget build(BuildContext context) {
    final ColorScheme colorScheme = ColorScheme.fromSeed(seedColor: seedColor);

    final TextTheme customTextTheme = TextTheme(
      headlineMedium: const TextStyle(
        fontSize: 30,
        fontWeight: FontWeight.bold,
      ),
      bodyLarge: const TextStyle(
        fontSize: 18,
        fontWeight: FontWeight.normal,
      ),
    );

    final ThemeData theme = ThemeData(
      colorScheme: colorScheme,
      useMaterial3: true,
      textTheme: customTextTheme,
    );

    return Theme(
      data: theme,
      child: Scaffold(
        appBar: AppBar(
          title: const Text('Tema tipográfico con colores distintos'),
        ),
        body: Center(
          child: Padding(
            padding: const EdgeInsets.all(16.0),
            child: Column(
              mainAxisSize: MainAxisSize.min,
              children: [
                Text(
                  'Este es un título grande',
                  style: Theme.of(context).textTheme.headlineMedium!.copyWith(color: Colors.blue),
                ),
                const SizedBox(height: 20),
                Text(
                  'Este es un texto de cuerpo principal con estilo y color diferentes.',
                  style: Theme.of(context).textTheme.bodyLarge!.copyWith(color: Colors.green),
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}