// Uso de async/await en bucle

void main() async {
  List<String> urls = ["url1", "url2", "url3"];

  for (String url in urls) {
    await Future.delayed(Duration(seconds: 1));
    print("Descargada $url");
  }
}