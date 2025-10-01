// Ejercicio con interfaz

abstract class Exportable {
  void exportar();
}

class DocumentoPDF implements Exportable {
  @override
  void exportar() {
    print('Exportando documento en PDF...');
  }
}

class ImagenPNG implements Exportable {
  @override
  void exportar() {
    print('Exportando imagen en PNG...');
  }
}

void main() {
  List<Exportable> elementos = [DocumentoPDF(), ImagenPNG()];

  for (var elemento in elementos) {
    elemento.exportar();
  }
}
