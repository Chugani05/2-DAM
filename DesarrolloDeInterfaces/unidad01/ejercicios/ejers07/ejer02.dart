//  Correos únicos

void main() {
  Set<String> emails = {
    "ana@mail.com",
    "luis@mail.com",
    "ana@mail.com",
    "pedro@mail.com"
  };
  
  print('Emails: $emails');
  
  emails.add("maria@mail.com");
  print('After adding a new email: $emails');
  
  bool containsLuis = emails.contains("luis@mail.com");
  print('Contains luis@mail.com? $containsLuis');
}