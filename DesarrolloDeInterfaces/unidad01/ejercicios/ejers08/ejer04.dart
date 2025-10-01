// Uso de finally

void abrirArchivo() {
  print("📂 Archivo abierto");
  throw Exception("Error al leer archivo");
}

void main() {
  try {
    abrirArchivo();
  } 
  // TODO: Captura el error
  catch (e) {
    print("Error: $e");
  } 
  // TODO: Añade un bloque finally que muestre "📕 Archivo cerrado"
  finally {
    print("📕 Archivo cerrado");
  }
}