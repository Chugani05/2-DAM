import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text('Texto personalizable'),
          centerTitle: true,
        ),
        body: Center(
          child: TextCustomizer(),
        ),
      ),
    );
  }
}

//Clase TextCustomizer
class TextCustomizer extends StatefulWidget {
  const TextCustomizer({super.key});

  @override
  State<TextCustomizer> createState() => _TextCustomizerState();
}

//Clase _TextCustomizerState
class _TextCustomizerState extends State<TextCustomizer>{
  double _fontSize = 24.0;
  Color _textColor = Colors.blue;

  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.center,
      children: [
        Text(
          'Texto personalizable',
          style: TextStyle(
            fontSize: _fontSize,
            color: _textColor,
          ),
        ),
        SizedBox(height: 20),
        DropdownButton<Color>(
          value: _textColor,
          items: [
            DropdownMenuItem(
              value: Colors.red,
              child: Text('Rojo'),
            ),
            DropdownMenuItem(
              value: Colors.green,
              child: Text('Verde'),
            ),
            DropdownMenuItem(
              value: Colors.blue,
              child: Text('Azul'),
            ),
          ],
          onChanged: (Color? newColor) {
            if (newColor != null) {
              setState(() {
                _textColor = newColor;
              });
            }
          },
        ),
        SizedBox(height: 20),
        Slider(
          min: 10,
          max: 60,
          value: _fontSize,
          onChanged: (double newSize) {
            setState(() {
              _fontSize = newSize;
            });
          },
        ),
      ],
    );
  }
}