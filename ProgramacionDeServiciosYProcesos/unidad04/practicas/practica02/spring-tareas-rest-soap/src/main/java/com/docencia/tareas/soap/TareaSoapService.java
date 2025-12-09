package com.docencia.tareas.soap;

import java.util.List;

import com.docencia.tareas.model.Tarea;
import com.docencia.tareas.service.ITareaService;

import jakarta.jws.WebService;

@WebService(
    serviceName = "TareaService",
    portName = "TareaPort",
    targetNamespace = "http://tareas.ies.puerto.es/",
    endpointInterface = "com.docencia.tareas.soap.ITareaSoapEndpoint"
)
public class TareaSoapService implements ITareaSoapEndpoint {

    private final ITareaService service;

    public TareaSoapService(ITareaService service) {
        this.service = service;
    }

    @Override
    public List<Tarea> listar() {
        return service.listarTodas();
    }

    @Override
    public Tarea buscar(Long id) {
        return service.buscarPorId(id);
    }

    @Override
    public Tarea crear(String titulo, String descripcion) {
        return service.crearTarea(titulo, descripcion);
    }

    @Override
    public Tarea actualizar(Long id, String titulo, String descripcion, Boolean completada) {
        return service.actualizarTarea(id, titulo, descripcion, completada);
    }

    @Override
    public boolean eliminar(Long id) {
        return service.eliminarTarea(id);
    }

}
