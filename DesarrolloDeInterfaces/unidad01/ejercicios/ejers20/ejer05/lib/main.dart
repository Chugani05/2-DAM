import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text('Color dinámico'),
          centerTitle: true,
        ),
        body: Center(
          child: ColorSliderWidget(),
        ),
      ),
    );
  }
}

//Clase ColorSliderWidget
class ColorSliderWidget extends StatefulWidget {
  const ColorSliderWidget({super.key});

  @override
  State<ColorSliderWidget> createState() => _ColorSliderWidgetState();
}

//Clase _ColorSliderWidgetState
class _ColorSliderWidgetState extends State<ColorSliderWidget>{
  int _redValue = 100;

  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.center,
      children: [
        Container(
          width: 150,
          height: 150,
          color: Color.fromRGBO(_redValue, 0, 0, 1),
        ),
        SizedBox(height: 30),
        Slider(
          min: 0,
          max: 255,
          value: _redValue.toDouble(),
          onChanged: (double newValue) {
            setState(() {
              _redValue = newValue.toInt();
            });
          },
        ),
        Text(
          'Valor rojo: $_redValue',
          style: TextStyle(fontSize: 20),
        ),
      ],
    );
  }
}