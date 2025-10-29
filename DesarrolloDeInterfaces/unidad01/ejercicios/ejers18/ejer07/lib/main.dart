import 'package:flutter/material.dart';

void main() {
  runApp(
    MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text('Actividad final de layout'),
          centerTitle: true,
          backgroundColor: Colors.teal, 
        ),
        body: Center(
          child: Container(
            margin: EdgeInsets.all(20),
            decoration: BoxDecoration(
              color: Colors.grey[200],
              borderRadius: BorderRadius.circular(15),
            ),
            padding: EdgeInsets.all(250),
            child: Column(
              mainAxisSize: MainAxisSize.min,
              children: [
                Text(
                  'Mi iconos favoritos',
                  style: TextStyle(fontSize: 24, fontWeight: FontWeight.bold),
                ),
                SizedBox(height: 20),
                Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    Icon(Icons.star, size: 50, color: Colors.orange),
                    Icon(Icons.favorite, size: 50, color: Colors.pink),
                    Icon(Icons.home, size: 50, color: Colors.blue),
                  ],
                ),
              ],
            ),
          ),
        ),
      ),
    ),
  );
}