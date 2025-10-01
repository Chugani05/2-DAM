// Ejercicio con getter

class Temperatura {
  double celsius;

  Temperatura(this.celsius);

  double get fahrenheit => (celsius * 9 / 5) + 32;
}

void main() {
  var temp1 = Temperatura(0);
  var temp2 = Temperatura(25);
  var temp3 = Temperatura(100);

  print('Temperatura en Celsius: ${temp1.celsius}°F en Fahrenheit: ${temp1.fahrenheit}°');
  print('Temperatura en Celsius: ${temp2.celsius}°F en Fahrenheit: ${temp2.fahrenheit}°');
  print('Temperatura en Celsius: ${temp3.celsius}°F en Fahrenheit: ${temp3.fahrenheit}°');
}