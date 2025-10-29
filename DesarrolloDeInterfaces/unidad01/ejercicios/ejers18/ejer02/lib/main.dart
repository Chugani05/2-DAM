import 'package:flutter/material.dart';

void main() {
  runApp(
    MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          backgroundColor: Colors.lightBlue,
          title: Text('Título'),
          centerTitle: true,
        ),
        body: Center(
          child: Text('Contenido principal'),
        ),
      ),
    ),
  );
}