import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatefulWidget {
  const MyApp({super.key});

  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  bool _isDark = false;

  void toggleTheme() {
    setState(() {
      _isDark = !_isDark;
    });
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Tema claro/oscuro + Navegación',
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
      themeMode: _isDark ? ThemeMode.dark : ThemeMode.light,
      home: HomePage(
        isDark: _isDark,
        onToggleTheme: toggleTheme,
      ),
    );
  }
}

class HomePage extends StatelessWidget {
  final bool isDark;
  final VoidCallback onToggleTheme;

  const HomePage({super.key, required this.isDark, required this.onToggleTheme});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Pantalla A')),
      body: Center(
        child: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            ElevatedButton(
              onPressed: onToggleTheme,
              child: const Text('Cambiar modo'),
            ),
            const SizedBox(height: 20),
            ElevatedButton(
              onPressed: () {
                Navigator.push(
                  context,
                  MaterialPageRoute(
                    builder: (context) => Pantalla2(
                      isDark: isDark,
                      onToggleTheme: onToggleTheme,
                    ),
                  ),
                );
              },
              child: const Text('Ir a Pantalla B'),
            ),
          ],
        ),
      ),
      floatingActionButton: FloatingActionButton(
        onPressed: onToggleTheme,
        child: Icon(isDark ? Icons.light_mode : Icons.dark_mode),
      ),
    );
  }
}

class Pantalla2 extends StatelessWidget {
  final bool isDark;
  final VoidCallback onToggleTheme;

  const Pantalla2({super.key, required this.isDark, required this.onToggleTheme});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Pantalla B')),
      body: Center(
        child: ElevatedButton(
          onPressed: onToggleTheme,
          child: const Text('Cambiar modo'),
        ),
      ),
    );
  }
}