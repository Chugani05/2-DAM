import 'package:flutter/material.dart';

void main() {
  runApp(
    MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text('Ejemplo de Container'),
          centerTitle: true,
        ),
        body: Center(
          child: Container(
            color: Colors.lightGreen,
            width: 200,
            height: 100,
            margin: EdgeInsets.all(20),
            alignment: Alignment.center,
            child: Text(
              'Texto centrado',
              style: TextStyle(fontSize: 16, color: Colors.white),
            ),
          ),
        ),
      ),
    ),
  );
}