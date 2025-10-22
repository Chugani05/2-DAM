import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text('Interruptor con estado'),
          centerTitle: true,
        ),
        body: Center(
          child: SwitchWidget(),
        ),
      ),
    );
  }
}

// Clase SwitchWidget
class SwitchWidget extends StatefulWidget {
  const SwitchWidget({super.key});

  @override
  State<SwitchWidget> createState() => _SwitchWidgetState();
}

// Clase _SwitchWidgetState
class _SwitchWidgetState extends State<SwitchWidget>{
  bool _isOn = false;
  
  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.center,
      children: [
        Switch(
          value: _isOn, 
          onChanged: (value) {
            setState(() {
              _isOn = value;
            }
          );
        }),
        Text(_isOn ? 'Interruptor activado' : 'Interuptor desactivado')
      ],
    );
  }
}
