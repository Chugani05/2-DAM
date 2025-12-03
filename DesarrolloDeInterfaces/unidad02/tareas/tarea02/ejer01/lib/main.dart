import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Texto Input y Mostrar',
      home: TextApp(),
    );
  }
}

class TextApp extends StatefulWidget {
  const TextApp({super.key});

  @override
  State<TextApp> createState() => _TextAppState();
}

class _TextAppState extends State<TextApp> {
  final TextEditingController controlador = TextEditingController();
  String textoMostrar = '';

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Campo de texto'),
      ),
      body: Center(
        child: Padding(
          padding: const EdgeInsets.all(100.0),
          child: Column(
            mainAxisSize: MainAxisSize.min,
            crossAxisAlignment: CrossAxisAlignment.center,
            children: [
              TextField(
                controller: controlador,
                decoration: InputDecoration(
                  labelText: 'Escribe algo',
                  border: OutlineInputBorder(),
                ),
              ),
              SizedBox(height: 20),
              ElevatedButton(
                onPressed: () {
                  setState(() {
                    textoMostrar = controlador.text;
                  });
                },
                child: Text('Mostrar texto'),
              ),
              SizedBox(height: 20),
              Text(
                textoMostrar,
                style: TextStyle(fontSize: 18),
              ),
            ],
          ),
        ),
      ),
    );
  }
}