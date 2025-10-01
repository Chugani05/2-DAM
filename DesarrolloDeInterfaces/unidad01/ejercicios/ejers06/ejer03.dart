// Cifrado Morse

void main() {
  String secretMessage = "- --- -.-. / - --- -.-. / - --- -.-. --..-- / .--. . -. -. -.--";

  Map<String, String> morseDict = {
    ".-": "A",
    "-...": "B",
    "-.-.": "C",
    "-..": "D",
    ".": "E",
    "..-.": "F",
    "--.": "G",
    "....": "H",
    "..": "I",
    ".---": "J",
    "-.-": "K",
    ".-..": "L",
    "--": "M",
    "-.": "N",
    "---": "O",
    ".--.": "P",
    "--.-": "Q",
    ".-.": "R",
    "...": "S",
    "-": "T",
    "..-": "U",
    "...-": "V",
    ".--": "W",
    "-..-": "X",
    "-.--": "Y",
    "--..": "Z",
    "--..--": ",",
    "/": " "
  };

  String originalMessage = secretMessage
      .split(" ")
      .map((symbol) => morseDict[symbol] ?? "")
      .join();

  print("Decoded message: $originalMessage");
}
