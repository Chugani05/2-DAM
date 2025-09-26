// Encontrar el mayor de tres números

void main() {
  List<int>values = [7, 3, 9];

  int maxNumber(List<int>values) {
    int maxValue = values[0];
    for (var value in values) {
      if (value > maxValue) {
        maxValue = value;
      }      
    }

    return maxValue;
  }
  
  print(maxNumber(values));
}