
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
                Icon(Icons.person, size: 25),


                SizedBox(height: 10),
                MyTextField(
                  icon: Icons.person,                
                  title: 'Nombre completo',
                ),
                
                Column(
                  children: [
                    Icon(Icons.email, size: 25),
                    Icon(Icons.phone, size: 25),
                    Icon(Icons.telegram, size: 25),
                    Icon(Icons.language, size: 25),
                  ],
                ),
                
                
                Column(
                  children: [
                    Icon(Icons.save, size: 25),
                    Text("Guardar perfil")
                  ],
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
  const MyTextField({required this.icon, required this.title, super.key});

  @override
  Widget build(BuildContext context) {
    return Container(
      decoration: BoxDecoration(
        borderRadius: BorderRadius.circular(5),
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
                ],
              ),
            ],
          ),
        ],
      ),
    );
  }
}
