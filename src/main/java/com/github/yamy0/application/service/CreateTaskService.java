package com.github.yamy0.application.service;

import com.github.yamy0.application.port.in.CreateTaskCommand;
import com.github.yamy0.application.port.in.CreateTaskUseCase;
import com.github.yamy0.application.port.out.CreateTaskPort;
import com.github.yamy0.domain.model.Task;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CreateTaskService implements CreateTaskUseCase {
    private final CreateTaskPort createTaskPort;

    public CreateTaskService(CreateTaskPort createTaskPort) {
        this.createTaskPort = createTaskPort;
    }

    @Override
    public void createTask(CreateTaskCommand command) {
        Task task = new Task(command.name(), command.dueDate());
        createTaskPort.createTask(task);
    }
}
