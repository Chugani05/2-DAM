package com.docencia.pgv.soap;

import java.util.List;

import org.springframework.stereotype.Service;

import com.docencia.pgv.interfaces.AutorService;
import com.docencia.pgv.modelo.Autor;
import jakarta.jws.WebService;

@WebService(
    serviceName = "AutorService",
    portName = "AutorPort",
    targetNamespace = "http://ies.docencia.com/autor",
    endpointInterface = "com.docencia.pgv.soap.AutorSoapService"
)
@Service
public class AutorSoapServiceImpl implements AutorSoapService {

    private final AutorService service;

    public AutorSoapServiceImpl(AutorService service) {
        this.service = service;
    }

    @Override
    public List<Autor> getAllAuthors() {
        return service.findAll();
    }

    @Override
    public Autor getAuthorById(Long id) {
        return service.findByIdOrThrow(id);
    }

    @Override
    public Autor createAuthor(String nombre, String pais) {
        return service.create(null);
    }

    @Override
    public void deleteAuthor(Long id) {
        service.delete(id);
    }
    
}
