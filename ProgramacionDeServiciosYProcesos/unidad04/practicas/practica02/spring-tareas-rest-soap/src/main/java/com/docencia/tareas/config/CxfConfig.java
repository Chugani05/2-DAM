package com.docencia.tareas.config;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.docencia.tareas.soap.IAlumnoSoapEndpoint;
import com.docencia.tareas.soap.ITareaSoapEndpoint;

@Configuration
public class CxfConfig {

    private final Bus bus;
    private final ITareaSoapEndpoint tareaSoapEndpoint;
    private final IAlumnoSoapEndpoint alumnoSoapEndpoint;

    public CxfConfig(Bus bus, ITareaSoapEndpoint tareaSoapEndpoint, IAlumnoSoapEndpoint alumnoSoapEndpoint) {
        this.bus = bus;
        this.tareaSoapEndpoint = tareaSoapEndpoint;
        this.alumnoSoapEndpoint = alumnoSoapEndpoint;
    }

    @Bean
    public EndpointImpl tareaEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, tareaSoapEndpoint);
        endpoint.publish("/tareas");
        return endpoint;
    }

    @Bean
    public EndpointImpl alumnoEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, alumnoSoapEndpoint);
        endpoint.publish("/tareas");
        return endpoint;
    }
}