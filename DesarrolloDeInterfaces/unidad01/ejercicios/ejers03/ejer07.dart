// Dada una lista de nombres, usa una función anónima 
// dentro de forEach para mostrar cada nombre en mayúsculas.

void main() {
  List<String>names = ["RashI", "Jesús", "nora", "EDdie", "Antón"];

  names.forEach((name) => print(name.toUpperCase()));
}