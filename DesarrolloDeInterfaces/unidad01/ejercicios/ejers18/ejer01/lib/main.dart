import 'package:flutter/material.dart';

void main() {
  runApp(
    MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text('Recipe book'),
        ),
        body: Center(
          child: Text('Lets cook!!'),
        ),
      ),
    ),
  );
}