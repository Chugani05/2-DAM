import 'package:flutter/material.dart';

void main() {
  runApp(
    MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text('Ejemplo de Column'),
          centerTitle: true,
        ),
        body: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Text(
                'Necesito dormir!!',
                style: TextStyle(fontSize: 24),
              ),
              Icon(
                Icons.star,
                color: Colors.yellow,
                size: 50,
              ),
              ElevatedButton(
                onPressed: () {},
                child: Text('Púlsame'),
              ),
            ],
          ),
        ),
      ),
    ),
  );
}