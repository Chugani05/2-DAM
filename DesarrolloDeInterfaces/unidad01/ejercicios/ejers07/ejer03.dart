// Diccionario de productos

void main() {
  Map<String, double> products = { 
    "bread": 1.0,
    "milk": 1.5,
    "eggs": 2.0
  };

  print('Price of milk: ${products["milk"]}');

  products["coffee"] = 3.0;

  products.forEach((product, price) {
    print('$product → $price');
  });
}