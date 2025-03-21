package com.github.yamy0.adapter.in.web;

import com.github.yamy0.application.port.in.CreateTaskCommand;
import com.github.yamy0.application.port.in.CreateTaskUseCase;
import com.github.yamy0.application.port.in.GetAllTaskUseCase;
import com.github.yamy0.domain.model.Task;
import jakarta.annotation.Nonnull;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/task")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TaskController {
    private final CreateTaskUseCase createTaskUseCase;
    private final GetAllTaskUseCase getAllTaskUseCase;

    public TaskController(CreateTaskUseCase createTaskUseCase, GetAllTaskUseCase getAllTaskUseCase) {
        this.createTaskUseCase = createTaskUseCase;
        this.getAllTaskUseCase = getAllTaskUseCase;
    }

    @GET
    public List<Task> tasks() {
        return getAllTaskUseCase.getAllTasks();
    }

    @POST
    public void createTask(@Nonnull CreateTaskCommand command) {
        createTaskUseCase.createTask(command);
    }
}
