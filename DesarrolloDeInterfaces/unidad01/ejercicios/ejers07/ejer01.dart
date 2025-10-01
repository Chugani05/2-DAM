//  Lista de notas

void main() {
  List<double> grades = [7.5, 8.0, 6.5, 9.0, 7.0];
  grades.add(8.5);

  print('First grade: ${grades.first}');
  print('Last grade: ${grades.last}');

  double average = grades.reduce((a, b) => a + b) / grades.length;
  print('Average grade: $average');
}