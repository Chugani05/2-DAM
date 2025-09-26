// Devolver una función closure

void main() {
  Function multiplier(int factor) {
    return (int number) {
      return number * factor;
    };
  }

  var byThree = multiplier(3);
  print(byThree(5));
}