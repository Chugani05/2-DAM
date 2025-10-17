void main() async {
  final stream = Stream.periodic(
    Duration(seconds: 1),
    (contador) => contador + 1,
  ).take(10);

  await for (var segundo in stream) {
    print('⏱️ Segundo: $segundo');
  }

  print('✅ Contador finalizado.');
}
