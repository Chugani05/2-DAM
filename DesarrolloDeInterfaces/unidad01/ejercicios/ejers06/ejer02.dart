String decodeCesar(String text, int shift) {
  List<int> decoded = text.codeUnits.map((c) => c - shift).toList();
  return String.fromCharCodes(decoded);
}

void main() {
  String secretMessage = "Zlqjduglxp#Ohylrvd";

  String originalMessage = decodeCesar(secretMessage, 3);

  print("Decoded message: $originalMessage");
}