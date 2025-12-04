import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  const MyApp({super.key});
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Comunicación en ambas direcciones',
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
  String textoRecibido = 'Sin mensaje aún';

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Pantalla A')),
      body: Center(
        child: Padding(
          padding: const EdgeInsets.all(20.0),
          child: Column(
            mainAxisSize: MainAxisSize.min,
            mainAxisAlignment: MainAxisAlignment.center,
            children: [
              Text(
                textoRecibido,
                style: TextStyle(fontSize: 20),
                textAlign: TextAlign.center,
              ),
              SizedBox(height: 20),
              ElevatedButton(
                child: Text('Ir a Pantalla B'),
                onPressed: () async {
                  final resultado = await Navigator.push(
                    context,
                    MaterialPageRoute(builder: (context) => PantallaB()),
                  );
                  if (resultado != null && resultado is String) {
                    setState(() {
                      textoRecibido = resultado;
                    });
                  }
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
  final TextEditingController _controller = TextEditingController();

  PantallaB({super.key});

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Pantalla B')),
      body: Padding(
        padding: const EdgeInsets.all(20.0),
        child: Column(
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
              child: Text('Devolver texto a Pantalla A'),
              onPressed: () {
                final texto = _controller.text;
                Navigator.pop(context, texto);
              },
            ),
          ],
        ),
      ),
    );
  }
}