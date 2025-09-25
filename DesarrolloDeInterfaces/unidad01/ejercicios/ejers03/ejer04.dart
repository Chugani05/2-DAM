// Crea una función que reciba una lista de números
// y devuelva la suma de todos ellos.

void main() {
  List<int>values = [7, 13, 9, 24, 5];

  int sum = values.reduce((a, b) => a + b);
  print(sum);
}