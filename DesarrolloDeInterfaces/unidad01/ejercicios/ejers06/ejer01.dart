// Cifrado ASCII Shift (+1)

String decodeAscii(String code) {
  List<String> parts = code.split(' ');
  String result = parts.map((n) => String.fromCharCode(int.parse(n) - 1)).join('');
  
  return result;
}

void main() {
  String secretMessage = "82 118 102 33 109 98 33 103 118 102 115 123 98 33 117 102 33 98 100 112 110 113 98 242 102";

  String originalMessage = decodeAscii(secretMessage);

  print("Decoded message: $originalMessage");
}