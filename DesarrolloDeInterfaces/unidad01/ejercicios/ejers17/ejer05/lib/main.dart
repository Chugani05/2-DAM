import 'package:flutter/material.dart';

void main() {
  runApp(
    MaterialApp(
      home: Center(
        child: Card(
          color: Colors.white,
          elevation: 5,
          shape: RoundedRectangleBorder(
            borderRadius: BorderRadius.circular(12),
          ),
          child: Padding(
            padding: EdgeInsets.all(16.0),
            child: Text(
              'I am having a proper full-on gay crisis! -Nick Nelson',
              style: TextStyle(fontSize: 18),
            ),
          ),
        ),
      ),
    ),
  );
}
