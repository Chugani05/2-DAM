package com.docencia.pgv.soap;

import java.util.List;
import com.docencia.pgv.modelo.Autor;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

@WebService(
    targetNamespace = "http://ies.docencia.com/autor",
    name = "AutorPortType"
)
public interface AutorSoapService {

    @WebMethod(operationName = "listar")
    List<Autor> getAllAuthors();

    @WebMethod(operationName = "listar por ID")
    Autor getAuthorById(@WebParam(name = "id") Long id);

    @WebMethod(operationName = "crear")
    Autor createAuthor(@WebParam(name = "nombre") String nombre, @WebParam(name = "pais") String pais);

    @WebMethod(operationName = "eliminar")
    void deleteAuthor(@WebParam(name = "id") Long id);
}
