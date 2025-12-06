import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

void main() {
  runApp(
    ChangeNotifierProvider(
      create: (_) => ThemeNotifier(),
      child: const MyApp(),
    ),
  );
}

class ThemeNotifier extends ChangeNotifier {
  bool _isDark = false;

  bool get isDark => _isDark;

  void toggleTheme() {
    _isDark = !_isDark;
    notifyListeners();
  }
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    final isDark = context.watch<ThemeNotifier>().isDark;

    return MaterialApp(
      title: 'Tema claro/oscuro con Provider',
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        colorSchemeSeed: const Color(0xFF0455BF),
        brightness: Brightness.light,
        useMaterial3: true,
      ),
      darkTheme: ThemeData(
        colorSchemeSeed: const Color(0xFF0455BF),
        brightness: Brightness.dark,
        useMaterial3: true,
      ),
      themeMode: isDark ? ThemeMode.dark : ThemeMode.light,
      home: const HomePage(),
    );
  }
}

class HomePage extends StatelessWidget {
  const HomePage({super.key});

  @override
  Widget build(BuildContext context) {
    final themeNotifier = context.read<ThemeNotifier>();
    final isDark = context.watch<ThemeNotifier>().isDark;

    return Scaffold(
      appBar: AppBar(title: const Text('Home Page')),
      body: Center(
        child: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            ElevatedButton(
              onPressed: () => themeNotifier.toggleTheme(),
              child: const Text('Cambiar modo'),
            ),
            const SizedBox(height: 20),
            ElevatedButton(
              onPressed: () {
                Navigator.push(
                  context,
                  MaterialPageRoute(
                    builder: (context) => Pantalla2(),
                  ),
                );
              },
              child: const Text('Ir a Pantalla 2'),
            ),
          ],
        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: () => themeNotifier.toggleTheme(),
        child: Icon(isDark ? Icons.light_mode : Icons.dark_mode),
      ),
    );
  }
}

class Pantalla2 extends StatelessWidget {
  const Pantalla2({super.key});

  @override
  Widget build(BuildContext context) {
    final themeNotifier = context.read<ThemeNotifier>();
    final isDark = context.watch<ThemeNotifier>().isDark;

    return Scaffold(
      appBar: AppBar(title: const Text('Pantalla 2')),
      body: Center(
        child: ElevatedButton(
          onPressed: () => themeNotifier.toggleTheme(),
          child: const Text('Cambiar modo desde Pantalla 2'),
        ),
      ),
    );
  }
}