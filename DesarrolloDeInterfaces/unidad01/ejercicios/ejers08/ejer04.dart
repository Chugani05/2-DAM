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
  // TODO: Añade un bloque finally que muestre "📕 Archivo cerrado"
}