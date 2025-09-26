// Simulación de botón con callback

void main() {
  void onPressed(Function callback) {
    callback();
  }

  onPressed(() => print("Button pressed"));
}