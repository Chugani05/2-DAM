package com.docencia.pgv.soap;

import java.util.List;

import org.springframework.stereotype.Service;

import com.docencia.pgv.interfaces.LibroService;
import com.docencia.pgv.modelo.Libro;

import jakarta.jws.WebService;

@WebService(
    serviceName = "LibroService",
    portName = "LibroPort",
    targetNamespace = "http://ies.docencia.com/libro",
    endpointInterface = "com.docencia.pgv.soap.LibroSoapService"
)
@Service
public class LibroSoapServiceImpl implements LibroSoapService {

    private LibroService service;

    public LibroSoapServiceImpl(LibroService service) {
        this.service = service;
    }

    @Override
    public List<Libro> getAllBooks() {
        return service.findAll();
    }

    @Override
    public Libro getBookById(Long id) {
        return service.findByIdOrThrow(id);
    }

    @Override
    public List<Libro> getBooksByAuthor(Long idAutor) {
        return service.findByAutorOrThrow(idAutor);
    }

    @Override
    public Libro createBook(String titulo, Integer anioPublicacion, Long idAutor) {
        return service.create(null);
    }

    @Override
    public void deleteBook(Long id) {
        service.delete(id);
    }
    
    
}
