package com.github.yamy0.application.service;

import com.github.yamy0.application.port.in.CreateTaskCommand;
import com.github.yamy0.application.port.in.CreateTaskUseCase;
import com.github.yamy0.application.port.out.CreateTaskPort;
import com.github.yamy0.domain.model.Task;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import org.jboss.resteasy.reactive.RestResponse;

@ApplicationScoped
class CreateTaskService implements CreateTaskUseCase {
    private final CreateTaskPort createTaskPort;

    public CreateTaskService(CreateTaskPort createTaskPort) {
        this.createTaskPort = createTaskPort;
    }

    @Override
    public Uni<RestResponse<Task>> createTask(CreateTaskCommand command) {
        Task task = new Task(command.name(), command.dueDate());
        return createTaskPort.createTask(task);
    }
}
