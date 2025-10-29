import 'package:flutter/material.dart';

void main() {
  runApp(
    MaterialApp(
      home: Center(
        child: Image.network(
          'https://picsum.photos/200',
          width: 400,
        ),
      ),
    ),
  );
}