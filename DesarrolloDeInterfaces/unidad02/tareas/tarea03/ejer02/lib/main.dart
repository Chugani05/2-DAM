import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Pasar Datos entre Pantallas',
      home: PantallaA(),
    );
  }
}

class PantallaA extends StatefulWidget {
  const PantallaA({super.key});

  @override
  State<PantallaA> createState() => _PantallaAState();
}

class _PantallaAState extends State<PantallaA> {
  final TextEditingController _controller = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Pantalla A')),
      body: Center(
        child: Padding(
          padding: const EdgeInsets.all(100.0),
          child: Column(
            mainAxisSize: MainAxisSize.min,
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              TextField(
                controller: _controller,
                decoration: InputDecoration(
                  labelText: 'Escribe un mensaje',
                  border: OutlineInputBorder(),
                ),
              ),
              SizedBox(height: 20),
              ElevatedButton(
                child: Text('Enviar a Pantalla B'),
                onPressed: () {
                  final mensaje = _controller.text;
                  Navigator.push(
                    context,
                    MaterialPageRoute(
                      builder: (context) => PantallaB(mensaje: mensaje),
                    ),
                  );
                },
              ),
            ],
          ),
        ),
      ),
    );
  }
}

class PantallaB extends StatelessWidget {
  final String mensaje;

  const PantallaB({super.key, required this.mensaje});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Pantalla B')),
      body: Center(
        child: Padding(
          padding: const EdgeInsets.all(20.0),
          child: Column(
            mainAxisSize: MainAxisSize.min,
            children: [
              Text(
                mensaje,
                style: TextStyle(fontSize: 24),
                textAlign: TextAlign.center,
              ),
              SizedBox(height: 20),
              ElevatedButton(
                child: Text('Volver a Pantalla A'),
                onPressed: () {
                  Navigator.pop(context);
                },
              ),
            ],
          ),
        ),
      ),
    );
  }
}