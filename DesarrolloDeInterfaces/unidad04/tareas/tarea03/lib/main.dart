import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      home: const LoginScreen(),
    );
  }
}

class LoginScreen extends StatefulWidget {
  const LoginScreen({super.key});

  @override
  State<LoginScreen> createState() => _LoginScreenState();
}

class _LoginScreenState extends State<LoginScreen> {
  final _emailController = TextEditingController();
  final _passwordController = TextEditingController();
  Alert? alertMessage;
  bool isPasswordHidden = true;

  void setErrorMessage(String? message) {
    setState(
      () => alertMessage = message != null
          ? Alert(
              icon: Icons.error,
              msg: message,
              color: Colors.red.shade300,
            )
          : null,
    );
  }

  void togglePasswordVisibility() {
    setState(() => isPasswordHidden = !isPasswordHidden);
  }

  void handleSubmit() {
    if (_emailController.text.isEmpty) {
      setErrorMessage("Please enter your email");
      return;
    }

    if (_passwordController.text.length < 8) {
      setErrorMessage("Password must be at least 8 characters");
      return;
    }

    setErrorMessage(null);
    setState(
      () => alertMessage = Alert(
        icon: Icons.check_circle,
        msg: "Welcome to the system!",
        color: Colors.green.shade300,
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('Login')),
      body: Padding(
        padding: const EdgeInsets.all(16),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.stretch,
          children: [
            if (alertMessage != null) ...[
              alertMessage!,
              const SizedBox(height: 15),
            ],
            TextField(
              controller: _emailController,
              decoration: const InputDecoration(
                border: OutlineInputBorder(),
                labelText: 'Email',
                hintText: 'name@domain.com',
                helperText: "Use a valid email to log in.",
              ),
            ),
            const SizedBox(height: 15),
            Stack(
              children: [
                TextField(
                  controller: _passwordController,
                  decoration: const InputDecoration(
                    border: OutlineInputBorder(),
                    labelText: 'Password',
                    hintText: "Minimum 8 characters.",
                    helperText: "Do not share your password with anyone.",
                  ),
                  obscureText: isPasswordHidden,
                ),
                Positioned(
                  right: 1,
                  top: 3.5,
                  child: IconButton(
                    onPressed: togglePasswordVisibility,
                    icon: Icon(
                      isPasswordHidden ? Icons.visibility_off : Icons.visibility,
                    ),
                  ),
                ),
              ],
            ),
            const SizedBox(height: 15),
            ElevatedButton(
              onPressed: handleSubmit,
              child: const Text('Login'),
            ),
          ],
        ),
      ),
    );
  }
}

class Alert extends StatelessWidget {
  final IconData icon;
  final String msg;
  final Color color;

  const Alert({
    super.key,
    required this.icon,
    required this.msg,
    required this.color,
  });

  @override
  Widget build(BuildContext context) {
    return Card(
      color: color,
      shape: RoundedRectangleBorder(
        side: BorderSide(color: color, width: 2),
        borderRadius: BorderRadius.circular(4),
      ),
      child: Padding(
        padding: const EdgeInsets.all(10),
        child: Row(
          children: [
            Icon(icon, color: Colors.white),
            const SizedBox(width: 10),
            Expanded(
              child: Text(
                msg,
                style: const TextStyle(
                  fontWeight: FontWeight.bold,
                  color: Colors.white,
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }
}