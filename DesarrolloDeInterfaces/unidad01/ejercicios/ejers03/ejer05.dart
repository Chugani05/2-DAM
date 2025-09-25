// Escribe una función que muestre en consola un mensaje 
// de presentación con un nombre obligatorio y una edad opcional 
// (si no se da edad, usa 0 por defecto).

void main() {
  void introduction(String name, [int? age = 0]) {
    print("Hello, my name is $name and I am ${age} years old.");
  }

  introduction("Rashi");
  introduction("Rashi", 20);
}
