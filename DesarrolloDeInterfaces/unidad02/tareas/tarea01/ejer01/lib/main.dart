import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Actividad Flutter',
      home: BotonFavorito(),
    );
  }
}

class BotonFavorito extends StatefulWidget {
  const BotonFavorito({super.key});

  @override
   _BotonFavoritoState createState() => _BotonFavoritoState();
}

class _BotonFavoritoState extends State<BotonFavorito> {
  bool esFavorito = false;

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
                esFavorito ? Icons.favorite : Icons.favorite_border,
                color: esFavorito ? Colors.red : Colors.grey,
              ),
              onPressed: () {
                setState(() {
                  esFavorito = !esFavorito;
                });
              },
            ),
            SizedBox(width: 20),
            Text(
              esFavorito
                  ? '¡Añadido a favorito ❤️!'
                  : 'Pulsa para marcar como favorito 🤍',
              style: TextStyle(fontSize: 18),
            ),
          ],
        ),
      ),
    );
  }
}