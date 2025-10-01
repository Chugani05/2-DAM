// Constructor normal

class Pelicula {
  String titulo;
  int anio;

  Pelicula(this.titulo, this.anio);
}

void main() {
  Pelicula peli = Pelicula('Purple Hearts', 2022);
  print('Película: ${peli.titulo}, Año: ${peli.anio}');
}