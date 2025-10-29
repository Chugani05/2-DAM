import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text('Nueva aplicación'),
        ),
        body: Center(
          child: Text('Palabra palabra palabra palabra.'),
        ),
      ),
    );
  }
}