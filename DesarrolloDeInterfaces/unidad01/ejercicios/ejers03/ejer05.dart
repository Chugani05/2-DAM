// Mensaje de presentación con edad opcional

void main() {
  void introduction(String name, [int? age = 0]) {
    print("Hello, my name is $name and I am ${age} years old.");
  }

  introduction("Rashi");
  introduction("Rashi", 20);
}
