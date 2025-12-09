import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Navegación básica',
      home: PantallaA(),
    );
  }
}

class PantallaA extends StatefulWidget {
  const PantallaA({super.key});

  @override
  State<PantallaA> createState() => _PantallaAState();
}

class _PantallaAState extends State<PantallaA> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Pantalla A')),
      body: Center(
        child: ElevatedButton(
          child: Text('Ir a Pantalla B'),
          onPressed: () {
            Navigator.push(
              context,
              MaterialPageRoute(builder: (context) => PantallaB()),
            );
          },
        ),
      ),
    );
  }
}

class PantallaB extends StatefulWidget {
  const PantallaB({super.key});

  @override
  State<PantallaB> createState() => _PantallaBState();
}

class _PantallaBState extends State<PantallaB> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Pantalla B')),
      body: Center(
        child: ElevatedButton(
          child: Text('Volver a Pantalla A'),
          onPressed: () {
            Navigator.pop(context);
          },
        ),
      ),
    );
  }
}