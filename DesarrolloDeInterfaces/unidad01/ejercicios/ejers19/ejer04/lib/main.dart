import 'package:flutter/material.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: Text('Combinando widgets personalizados'),
          centerTitle: true,
        ),
        body: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            HeaderWidget(
              title: 'Panel principal',
              subtitle: 'Ejemplo con widgets propios',
            ),
            SizedBox(height: 20),
            InfoCard(
              title: 'Configuración del sistema',
              icon: Icons.settings,
            ),
            InfoCard(
              title: 'Perfil de usuario',
              icon: Icons.person,
            ),
            InfoCard(
              title: 'Centro de ayuda',
              icon: Icons.help,
            ),
          ],
        ),
      ),
    );
  }
}

// Clase HeaderWidget
class HeaderWidget extends StatelessWidget {
  final String title;
  final String subtitle;

  const HeaderWidget({super.key, required this.title, required this.subtitle});

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: EdgeInsets.all(16),
      child: Column(
        children: [
          Text(
            title,
            style: TextStyle(
              fontSize: 26,
              fontWeight: FontWeight.bold,
              color: Colors.blue,
            ),
          ),
          SizedBox(height: 10),
          Text(
            subtitle,
            style: TextStyle(
              fontSize: 18,
              color: Colors.grey[700],
            ),
          ),
        ],
      ),
    );
  }
}

// Clase InfoCard
class InfoCard extends StatelessWidget {
  final String title;
  final IconData icon;

  const InfoCard({required this.title, required this.icon, super.key});

  @override
  Widget build(BuildContext context) {
    return Card(
      elevation: 4,
      margin: EdgeInsets.all(16),
      child: Padding(
        padding: EdgeInsets.all(12),
        child: Row(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            Icon(
              icon,
              color: Colors.blue,
              size: 40,
            ),
            SizedBox(width: 10),
            Text(
              title,
              style: TextStyle(
                fontSize: 16,
                fontWeight: FontWeight.bold
              ),
            ),
          ],
        ),
      ),
    );
  }
}