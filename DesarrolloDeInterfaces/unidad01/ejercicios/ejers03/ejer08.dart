// Escribe una función que genere una lista 
// con los cuadrados de los primeros n números enteros.
// Usa una función flecha (=>).

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