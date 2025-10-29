import 'package:flutter/material.dart';

void main() {
  runApp(
    MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text('Ejemplo de Row'),
          centerTitle: true,
        ),
        body: Center(
          child: Row(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Icon(
                Icons.star,
                color: Colors.orange,
                size: 40,
              ),
              Icon(
                Icons.favorite,
                color: Colors.red,
                size: 40,
              ),
              Icon(
                Icons.home,
                color: Colors.pink,
                size: 40,
              ),
            ],
          ),
        ),
      ),
    ),
  );
}