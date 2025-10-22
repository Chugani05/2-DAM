import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text('Contador con estado'),
          centerTitle: true,
        ),
        body: Center(
          child: CounterWidget(),
        ),
      ),
    );
  }
}

// Clase CounterWidget
class CounterWidget extends StatefulWidget {
  const CounterWidget({super.key});

  @override
  State<CounterWidget> createState() => _CounterWidgetState();
}

// Clase _CounterWidgetState
class _CounterWidgetState extends State<CounterWidget>{
  int _counter = 0;
  
  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisAlignment: MainAxisAlignment.center,
      children: [
        Text(
          'Has pulsado $_counter veces', 
          style: TextStyle(fontSize: 20)
        ),
        ElevatedButton(
          onPressed: ()=>setState(() {
            _counter++;
            }),
          child: Text('Púlsame'),
        ),
      ],
    );
  }
}
