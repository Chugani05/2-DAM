import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Personalización de botones',
      theme: ThemeData(
        useMaterial3: true,
        elevatedButtonTheme: ElevatedButtonThemeData(
          style: ButtonStyle(
            backgroundColor: WidgetStateProperty.all(Colors.deepPurple),
            foregroundColor: WidgetStateProperty.all(Colors.white),
            padding: WidgetStateProperty.all(const EdgeInsets.symmetric(
              vertical: 16,
              horizontal: 32,
            )),
            textStyle: WidgetStateProperty.all(const TextStyle(
              fontSize: 18,
            )),
            shape: WidgetStateProperty.all(
              RoundedRectangleBorder(
                borderRadius: BorderRadius.circular(25),
              ),
            ),
          ),
        ),
      ),
      home: const HomePage(),
    );
  }
}

class HomePage extends StatelessWidget {
  const HomePage({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Botones Elevados Personalizados'),
      ),
      body: Center(
        child: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            ElevatedButton(
              onPressed: () {},
              child: const Text('Botón'),
            ),
          ],
        ),
      ),
    );
  }
}