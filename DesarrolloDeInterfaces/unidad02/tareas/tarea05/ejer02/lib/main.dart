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
      title: 'Tema claro/oscuro + Prop drilling',
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
      home: Scaffold(
        appBar: AppBar(title: const Text('Home Page')),
        body: Center(
          child: ElevatedButton(
            onPressed: toggleTheme,
            child: Text('Cambiar modo'),
          ),
        ),
        floatingActionButton: FloatingActionButton(
          onPressed: toggleTheme,
          child: Icon(_isDark ? Icons.light_mode : Icons.dark_mode),
        ),
      ),
    );
  }
}