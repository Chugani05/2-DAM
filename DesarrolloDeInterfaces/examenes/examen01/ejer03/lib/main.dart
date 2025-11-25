
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
  const MyMainWidget({super.key});    
    
    @override   
    Widget build(BuildContext context) {     
      return Scaffold(       
        appBar: AppBar(title: Text('Widgets personalizados')),       
        body: Center(         
          child: Padding(           
            padding: const EdgeInsets.symmetric(horizontal: 50),           
            child: Column(             
              mainAxisAlignment: MainAxisAlignment.center,             
              children: [               
                MyTextField(     
                  icon: Icons.work,            
                  title: 'Trabajo',
                  description: "Gestiona tus tareas y proyectos diarios",
                ),
                SizedBox(height: 10),               
                MyTextField(
                  icon: Icons.health_and_safety,               
                  title: 'Salud',
                  description: "Consulta información relacionada con tu bienestar.",
                ),
                SizedBox(height: 10),
                MyTextField(
                  icon: Icons.home,                
                  title: 'Hogar',
                  description: "Organiza todos los aspectos de tu vivienda",
                ),          
            ],           
          ),         
        ),       
      ),     
    );   
  } 
}

  class MyTextField extends StatelessWidget {
  final IconData icon;
  final String title;
  final String description;
  const MyTextField({required this.icon, required this.title, required this.description, super.key});

  @override
  Widget build(BuildContext context) {
    return Container(
      decoration: BoxDecoration(
        borderRadius: BorderRadius.circular(50),
        border: Border.all(color: const Color.fromARGB(255, 219, 219, 219)),
      ),
      padding: EdgeInsets.all(12),
      child: Column(
        children: [
          Row(
            children: [
              Icon(
                 icon,
                size: 30
              ),
              SizedBox(width: 10),
              Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Text(title),
                  SizedBox(width: 2),
                  Text(description),
                ],
              ),
            ],
          ),
        ],
      ),
    );
  }
}
