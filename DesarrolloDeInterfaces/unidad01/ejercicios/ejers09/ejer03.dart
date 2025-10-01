// Multiplicación con dos tipos de errores

int multiplicar(int? a, int? b) {
  if (a == null || b == null) {
    throw ArgumentError("Los argumentos no pueden ser nulos");
  }
  if (a < 0 || b < 0) {
    throw Exception("Los números no pueden ser negativos");
  }
  return a * b;
}

void main() {
  try {
    print(multiplicar(5, 3));
    print(multiplicar(null, 2));
    print(multiplicar(4, -2));
  } on ArgumentError catch (e) {
    print("ArgumentError: ${e.message}");
  } catch (e) {
    print("Error: $e");
  }
}