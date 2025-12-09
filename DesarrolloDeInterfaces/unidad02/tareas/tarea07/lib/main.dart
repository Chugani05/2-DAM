import 'package:flutter/material.dart';

void main() {
  runApp(const MiniJuegoEstado());
}

class MiniJuegoEstado extends StatefulWidget {
  const MiniJuegoEstado({super.key});

  @override
  State<MiniJuegoEstado> createState() => _MiniJuegoEstadoState();
}

class _MiniJuegoEstadoState extends State<MiniJuegoEstado> {
  int energia = 50; // Variable de energía
  bool isDark = false; // Modo claro/oscuro

  void aumentar() {
    setState(() {
      if (energia < 100) {
        energia += 10;
        if (energia > 100) {
          energia = 100;
        }
      }
    });
  }

  // Función para disminuir energía, min 0
  void disminuir() {
    setState(() {
      if (energia > 0) {
        energia -= 10;
        if (energia < 0) {
          energia = 0;
        }
      }
    });
  }

  // Función para reiniciar energía a 50
  void reiniciar() {
    setState(() {
      energia = 50;
    });
  }

  // Función para cambiar modo oscuro/claro
  void cambiarTema() {
    setState(() {
      isDark = !isDark;
    });
  }

  // Función para obtener el mensaje según energía
  String getMensaje() {
    if (energia == 0) {
      return "Has perdido toda tu energía";
    } else if (energia == 50) {
      return "Estás a mitad de camino";
    } else if (energia == 100) {
      return "¡Has escapado!";
    } else {
      return "Sigue ajustando la energía…";
    }
  }

  // Función para obtener el color del número según energía
  Color getColor() {
    if (energia < 30) {
      return Colors.red;
    } else if (energia <= 70) {
      return Colors.orange;
    } else {
      return Colors.green;
    }
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        brightness: isDark ? Brightness.dark : Brightness.light,
        useMaterial3: true,
      ),
      home: Scaffold(
        appBar: AppBar(
          title: const Text("Minijuego: Gestión de estado"),
          actions: [
            IconButton(
              icon: Icon(isDark ? Icons.wb_sunny : Icons.nights_stay),
              onPressed: cambiarTema,
            ),
          ],
        ),
        body: Center(
          child: Padding(
            padding: const EdgeInsets.all(16.0),
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Text(
                  'Energía',
                  style: TextStyle(
                    fontSize: 30,
                    fontWeight: FontWeight.bold,
                  ),
                ),
                Text(
                  '$energia',
                  style: TextStyle(
                    fontSize: 60,
                    fontWeight: FontWeight.bold,
                    color: getColor(),
                  ),
                ),
                const SizedBox(height: 20),
                Text(
                  getMensaje(),
                  style: const TextStyle(fontSize: 20),
                  textAlign: TextAlign.center,
                ),
                const SizedBox(height: 30),
                Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    ElevatedButton(
                      onPressed: aumentar,
                      child: const Text('+ Aumentar'),
                    ),
                    const SizedBox(width: 10),
                    ElevatedButton(
                      onPressed: disminuir,
                      child: const Text('- Disminuir'),
                    ),
                    const SizedBox(width: 10),
                    ElevatedButton(
                      onPressed: reiniciar,
                      child: const Text('Reiniciar'),
                    ),
                  ],
                ),
              ],
            ),
          ),
        ),
      ),
    );
  }
}