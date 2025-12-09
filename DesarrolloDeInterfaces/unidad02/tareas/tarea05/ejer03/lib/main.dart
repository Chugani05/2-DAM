import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatefulWidget {
  const MyApp({super.key});

  @override
  State createState() => _MyAppState();
}

class _MyAppState extends State {
  bool _isDark = false;

  void toggleTheme() {
    setState(() {
      _isDark = !_isDark;
    });
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Tema claro/oscuro + Botón que cambia de texto',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(
          brightness: Brightness.light,
          seedColor: Color(0xFF0455BF),
        ),
      ),
      darkTheme: ThemeData(
        colorScheme: ColorScheme.fromSeed(
          seedColor: Color(0xFF0455BF),
          brightness: Brightness.dark,
        ),
      ),
      themeMode: _isDark ? ThemeMode.dark : ThemeMode.light,

      home: HomePage(isDark: _isDark, toggleTheme: toggleTheme),
    );
  }
}

class HomePage extends StatelessWidget {
  final bool isDark;
  final VoidCallback toggleTheme;

  const HomePage({super.key, required this.isDark, required this.toggleTheme});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Home Page')),

      body: Center(
        child: ElevatedButton(
          onPressed: toggleTheme,
          child: Text(isDark ? 'Cambiar a claro' : 'Cambiar a oscuro'),
        ),
      ),

      floatingActionButton: FloatingActionButton(
        onPressed: toggleTheme,
        child: isDark ? Icon(Icons.dark_mode) : Icon(Icons.light_mode),
      ),
    );
  }
}