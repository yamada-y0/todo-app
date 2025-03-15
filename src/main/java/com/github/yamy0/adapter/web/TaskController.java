package com.github.yamy0.adapter.web;

import com.github.yamy0.application.usecase.TaskUseCase;
import com.github.yamy0.domain.model.Task;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/task")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TaskController {
    private final TaskUseCase taskUseCase;

    public TaskController(TaskUseCase taskUseCase) {
        this.taskUseCase = taskUseCase;
    }

    @GET
    public List<Task> tasks() {
        return taskUseCase.findAll();
    }

    @POST
    public void createTask(Task task) {
        taskUseCase.createTask(task);
    }
}
