import 'dart:io';

Future<void> main() async {
  print('Comprobando conexión a Internet...');

  try {
    final result = await InternetAddress.lookup('google.com');

    if (result.isNotEmpty) {
      print('✅ Conectado a Internet');
    } else {
      print('❌ Sin conexión a Internet');
    }
  } on SocketException catch (_) {
    print('❌ Sin conexión a Internet');
  }
}