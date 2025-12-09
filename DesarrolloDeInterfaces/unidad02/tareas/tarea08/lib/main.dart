import 'package:flutter/material.dart';
import 'dart:async';

void main() {
  runApp(const TimerApp());
}

class TimerApp extends StatelessWidget {
  const TimerApp({super.key});

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      debugShowCheckedModeBanner: false,
      home: CuentaAtras(),
    );
  }
}

class CuentaAtras extends StatefulWidget {
  const CuentaAtras({super.key});

  @override
  State<CuentaAtras> createState() => _CuentaAtrasState();
}

class _CuentaAtrasState extends State<CuentaAtras> {
  int tiempo = 10;
  late Timer timer;

  @override
  void initState() {
    super.initState();
    timer = Timer.periodic(const Duration(seconds: 1), (Timer t) {
      if (tiempo > 0) {
        setState(() {
          tiempo--;
        });
      } else {
        t.cancel();
      }
    });
  }

  @override
  void dispose() {
    timer.cancel();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Cuenta atrás con Timer')),
      body: Center(
        child: Text(
          tiempo.toString(),
          style: const TextStyle(
            fontSize: 60,
            fontWeight: FontWeight.bold,
          ),
        ),
      ),
    );
  }
}