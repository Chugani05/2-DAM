package com.docencia.tasks.adapters.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.docencia.tasks.adapters.in.api.TaskRequest;
import com.docencia.tasks.adapters.in.api.TaskResponse;
import com.docencia.tasks.domain.model.Task;
import com.docencia.tasks.entitys.TaskEntity;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    @Mapping(source = "identificador", target = "id")
    @Mapping(source = "titulo", target = "title")
    @Mapping(source = "descripcion", target = "description")
    @Mapping(source = "completada", target = "completed")
    public Task to(TaskRequest source);

    public List<Task> toTasks(List<TaskRequest> source);

    public Task entityTask(TaskEntity source);

    public List<Task> entityToTasksList(List<TaskEntity> entities);

    public Task requestToTask(TaskRequest taskRequest);

    public TaskResponse taskToRequest(Task task);
}
