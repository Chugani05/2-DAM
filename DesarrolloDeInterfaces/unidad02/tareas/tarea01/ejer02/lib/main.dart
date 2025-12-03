import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Ejemplo con setState()',
      home: BotonFavorito(),
    );
  }
}

class BotonFavorito extends StatefulWidget {
  const BotonFavorito({super.key});

  @override
  State<BotonFavorito> createState() => _BotonFavoritoState();
}

class _BotonFavoritoState extends State<BotonFavorito> {
  bool _esFavorito = false;

  void _toggleFavorito() {
    setState(() {
      _esFavorito = !_esFavorito;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Ejemplo con setState()')),
      body: Center(
        child: Column(
          mainAxisSize: MainAxisSize.min,
          children: [
            IconButton(
              iconSize: 100,
              icon: Icon(
                _esFavorito ? Icons.favorite : Icons.favorite_border,
                color: _esFavorito ? Colors.red : Colors.grey,
              ),
              onPressed: _toggleFavorito,
            ),
            SizedBox(height: 20),
            Text(
              _esFavorito
                  ? '¡Añadido a favorito ❤️!'
                  : 'Pulsa para marcar como favorito 🤍',
              style: TextStyle(fontSize: 18),
            ),
            SizedBox(height: 20),
            ElevatedButton.icon(
              onPressed: _toggleFavorito,
              icon: Icon(Icons.refresh),
              label: Text(' Cambiar estado'),
              style: ElevatedButton.styleFrom(
                backgroundColor: Colors.blue,
                foregroundColor: Colors.white,
              ),
              
            ),
          ],
        ),
      ),
    );
  }
}