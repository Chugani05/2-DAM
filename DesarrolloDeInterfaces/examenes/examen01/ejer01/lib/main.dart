
import 'package:flutter/material.dart';

void main() => runApp(MiApp());

class MiApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      title: 'Actividad Flutter',
      home: MyMainWidget(),
    );
  }
}

class MyMainWidget extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: Text('Widget principal')),
      body: Center(
        child: Column(
          children: [
            Padding(
              padding: const EdgeInsets.all(8.0),
              child: Text("Alaska"),
            ),
            Padding(
              padding: const EdgeInsets.all(8.0),
              child: Text("El sol se ha ido oficialmente en Alaska y no volverá a salir hasta el 22 de enero de 2026."),
            ),
            Padding(
              padding: const EdgeInsets.all(8.0),
              child: Image.asset('assets/alaska.jpg', width: 350),
            ),
            Image.network('https://s1.ppllstatics.com/lasprovincias/www/multimedia/201811/26/media/cortadas/alaska-U30168758986hpE--624x337@Las%20Provincias-LasProvincias.jpg', width: 350),
          ],
        ) 
      )
    );
  }
}