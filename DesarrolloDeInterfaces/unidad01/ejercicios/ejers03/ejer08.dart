// Generar lista de cuadrados (=>)

void main() {
  List generateSquares(n) {
    Function square = (number) => number * number;

    List<int>values = [];

    for (var i = 1; i <= n; i++) {
      values.add(square(i));
    }
  
    return values;
  }
  
  print(generateSquares(5));
}