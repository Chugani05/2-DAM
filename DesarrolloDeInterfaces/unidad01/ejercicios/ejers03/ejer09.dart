// Crea una función que devuelva otra función (closure).
// La función devuelta debe multiplicar por un factor fijo
// el número que reciba.

void main() {
  Function multiplier(int factor) {
    return (int number) {
      return number * factor;
    };
  }

  var byThree = multiplier(3);
  print(byThree(5));
}