import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text('Control deslizante'),
          centerTitle: true,
        ),
        body: Center(
          child: SliderWidget(),
        ),
      ),
    );
  }
}

//Clase SliderWidget
class SliderWidget extends StatefulWidget {
  const SliderWidget({super.key});

  @override
  State<SliderWidget> createState() => _SliderWidgetState();
}

//Clase _SliderWidgetState
class _SliderWidgetState extends State<SliderWidget>{
  double _value = 50.0;

  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.center,
      children: [
        Slider(
          value: _value,
          min: 0, 
          max: 100,
          onChanged: (double newValue) {
            setState(() {
              _value = newValue;
            });
          },
        ),
        SizedBox(height: 20),
        Text(
          'Valor actual: ' + _value.toStringAsFixed(1),
          style: TextStyle(fontSize: 20),
        ),
      ],
    );
  }
}
