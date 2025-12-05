import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    const ColorScheme customColorScheme = ColorScheme(
      brightness: Brightness.light,
      primary: Color(0xFF0455BF),
      onPrimary: Color(0xFFFFFFFF),
      secondary: Color(0xFF1A1A1A),
      onSecondary: Color(0xFFFFFFFF),
      surface: Color(0xFFF7F7F7),
      onSurface: Color(0xFF1A1A1A),
      error: Color(0xFFD6001C),
      onError: Color(0xFFFFFFFF),
    );

    final ThemeData theme = ThemeData(
      colorScheme: customColorScheme,
    );

    return MaterialApp(
      title: 'Paleta personalizada',
      theme: theme,
      home: const HomePage(),
    );
  }
}

class HomePage extends StatelessWidget {
  const HomePage({super.key});

  @override
  Widget build(BuildContext context) {
    final colorScheme = Theme.of(context).colorScheme;

    return Scaffold(
      appBar: AppBar(
        title: const Text('Aplicación con paleta personalizada'),
      ),
      body: Center(
        child: Padding(
          padding: const EdgeInsets.all(16.0),
          child: Column(
            mainAxisSize: MainAxisSize.min,
            children: [
              Text(
                'Este es un texto con la paleta corporativa.',
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
                style: ElevatedButton.styleFrom(
                  backgroundColor: colorScheme.onPrimary,
                  foregroundColor: colorScheme.primary,
                ),
                onPressed: () {},
                child: const Text('Enviar'),
              ),
            ],
          ),
        ),
      ),
      floatingActionButton: FloatingActionButton(
        backgroundColor: colorScheme.primary,
        onPressed: () {
        },
        child: const Icon(Icons.add),
      ),
    );
  }
}