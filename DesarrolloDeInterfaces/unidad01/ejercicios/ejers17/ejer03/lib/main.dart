import 'package:flutter/material.dart';

void main() {
  runApp(
    MaterialApp(
      home: Center(
        child: ElevatedButton(
          onPressed: () {
            print('¡Has pulsado el botón!');
          },
          child: Text('Púlsame'),
        ),
      ),
    ),
  );
}