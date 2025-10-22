import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text('Texto dinámico'),
          centerTitle: true,
        ),
        body: Center(
          child: TextSliderWidget(),
        ),
      ),
    );
  }
}

//Clase TextSliderWidget
class TextSliderWidget extends StatefulWidget {
  const TextSliderWidget({super.key});

  @override
  State<TextSliderWidget> createState() => _TextSliderWidgetState();
}

//Clase _TextSliderWidgetState
class _TextSliderWidgetState extends State<TextSliderWidget>{
  double _fontSize = 20.0;

  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.center,
      children: [
        Text(
          'Texto dinámico',
          style: TextStyle(fontSize: _fontSize),
        ),
        Slider(
          min: 10,
          max: 60,
          value: _fontSize,
          onChanged: (double value) {
            setState(() {
              _fontSize = value;
            });
          },
        ),
      ],
    );
  }
}