// Sumar elementos de una lista

void main() {
  List<int>values = [7, 13, 9, 24, 5];

  int sum = values.reduce((a, b) => a + b);
  print(sum);
}