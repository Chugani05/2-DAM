package com.docencia.pgv.config;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.docencia.pgv.soap.AutorSoapService;
import com.docencia.pgv.soap.LibroSoapService;

@Configuration
public class CxfConfig {

    private final Bus bus;
    private final LibroSoapService libroSoapService;
    private final AutorSoapService autorSoapService;

    public CxfConfig(Bus bus, LibroSoapService libroSoapService, AutorSoapService autorSoapService) {
        this.bus = bus;
        this.libroSoapService = libroSoapService;
        this.autorSoapService = autorSoapService;
    }

    @Bean
    public EndpointImpl libroEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, libroSoapService);
        endpoint.publish("/libros");
        return endpoint;
    }

    @Bean
    public EndpointImpl autorEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, autorSoapService);
        endpoint.publish("/autores");
        return endpoint;
    }
}
