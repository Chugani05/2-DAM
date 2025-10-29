import 'package:flutter/material.dart';

void main() {
  runApp(
    MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text('Combinar Column y Row'),
          centerTitle: true,
        ),
        body: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Text(
                'Iconos favoritos',
                style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
              ),
              Row(
                mainAxisAlignment: MainAxisAlignment.center,
                children: [
                  Icon(
                    Icons.star,
                    color: Colors.orange,
                    size: 50,
                  ),
                  Icon(
                    Icons.favorite,
                    color: Colors.pink,
                    size: 50,
                  ),
                  Icon(
                    Icons.home,
                    color: Colors.blue,
                    size: 50,
                  ),
                ],
              ),
            ],
          ),
        ),
      ),
    ),
  );
}