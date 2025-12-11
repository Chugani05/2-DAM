package com.docencia.tareas.soap;

import java.util.List;

import com.docencia.tareas.model.Alumno;

import jakarta.jws.*;

@WebService(
    targetNamespace = "http://ies.puerto.es/ws/alumno",
    name = "AlumnoPortType"
)
public interface IAlumnoSoapEndpoint {

    @WebMethod(operationName = "listar")
    List<Alumno> listar();
}
