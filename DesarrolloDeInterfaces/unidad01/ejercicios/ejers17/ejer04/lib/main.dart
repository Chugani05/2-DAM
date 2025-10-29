import 'package:flutter/material.dart';

void main() {
  runApp(
    MaterialApp(
      home: Center(
        child: ElevatedButton.icon(
          onPressed: () {
            print('¡Has pulsado el botón con icono!');
          },
          icon: Icon(
            Icons.favorite,
            size: 30,
            color: Colors.red,
          ),
          label: Text('Me gusta'),
          style: ElevatedButton.styleFrom(
            padding: EdgeInsets.symmetric(horizontal: 20, vertical: 12),
          ),
        ),
      ),
    ),
  );
}
