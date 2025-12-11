package com.docencia.tareas.soap;

import java.util.List;

import com.docencia.tareas.model.Alumno;
import com.docencia.tareas.repositories.ITareaRepository;
import com.docencia.tareas.repositories.TareaRepository;
import com.docencia.tareas.service.IAlumnoService;

import jakarta.jws.WebService;

@WebService(
    serviceName = "AlumnoService",
    portName = "AlumnoPort",
    targetNamespace = "http://alumnos.ies.puerto.es/",
    endpointInterface = "com.docencia.alumnos.soap.IAlumnoSoapEndpoint"
)
public class AlumnoSoapService implements IAlumnoSoapEndpoint {

    private IAlumnoService service;

    public IAlumnoService(IAlumnoService service) {
        this.service = service;
    }

    @Override
    public List<Alumno> listar() {
        return service.listarTodas();
    }

}
