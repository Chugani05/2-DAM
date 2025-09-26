// Función operar con otra función

import 'dart:io';

void main() {
  String? getOperationType() {
    print("Choose the operation type");
    print("1. Addition");
    print("2. Subtraction");
    print("3. Multiplication");
    print("4. Division");
    return stdin.readLineSync();
  }

  void operate() {
    print("Enter the first value");
    num value1 = num.parse(stdin.readLineSync() ?? "0");
    print("Enter the second value");
    num value2 = num.parse(stdin.readLineSync() ?? "0");

    switch (getOperationType()) {
      case "1":
        print("The sum of $value1 + $value2 is ${value1 + value2}");
        break;
      case "2":
        print("The subtraction of $value1 - $value2 is ${value1 - value2}");
        break;
      case "3":
        print("The multiplication of $value1 x $value2 is ${value1 * value2}");
        break;
      case "4":
        print("The division of $value1 / $value2 is ${value1 / value2}");
        break;
      default:
        break;
    }
  }

  operate();
}