// Simula el comportamiento de un botón.

void main() {
  void onPressed(Function callback) {
    callback();
  }

  onPressed(() => print("Button pressed"));
}