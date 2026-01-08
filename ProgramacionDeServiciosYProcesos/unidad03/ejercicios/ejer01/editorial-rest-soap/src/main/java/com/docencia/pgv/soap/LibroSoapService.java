package com.docencia.pgv.soap;

import java.util.List;
import com.docencia.pgv.modelo.Libro;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService(
    targetNamespace = "http://ies.docencia.com/libro",
    name = "LibroPortType"
)
public interface LibroSoapService {

    @WebMethod(operationName = "listar")
    List<Libro> getAllBooks();

    @WebMethod(operationName = "listar por ID")
    Libro getBookById(@WebParam(name = "id") Long id);

    @WebMethod(operationName = "listar por autor")
    List<Libro> getBooksByAuthor(@WebParam(name = "idAutor") Long idAutor);

    @WebMethod(operationName = "crear")
    Libro createBook(@WebParam(name = "titulo") String titulo,
                     @WebParam(name = "anioPublicacion") Integer anioPublicacion,
                     @WebParam(name = "idAutor") Long idAutor);

    @WebMethod(operationName = "eliminar")
    void deleteBook(@WebParam(name = "id") Long id);
}
