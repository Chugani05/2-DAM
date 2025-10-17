import 'dart:io';
import 'dart:convert';

Future<void> main() async {
  final file = File('poema.txt');

  if (!await file.exists()) {
    print('❌ El archivo poema.txt no existe.');
    return;
  }

  int lineNumber = 1;

  final lines = file
      .openRead()
      .transform(utf8.decoder)
      .transform(LineSplitter());

  await for (var line in lines) {
    print('$lineNumber️⃣ $line');
    lineNumber++;
  }

  print('✅ Lectura finalizada.');
}