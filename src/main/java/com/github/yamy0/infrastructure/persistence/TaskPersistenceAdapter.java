package com.github.yamy0.infrastructure.persistence;

import com.github.yamy0.application.port.out.CreateTaskPort;
import com.github.yamy0.application.port.out.GetAllTaskPort;
import com.github.yamy0.domain.model.Task;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class TaskPersistenceAdapter implements CreateTaskPort, GetAllTaskPort {
    private final TaskRepository repository;

    public TaskPersistenceAdapter(TaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createTask(Task task) {
        repository.save(task);
    }

    @Override
    public List<Task> getTasks() {
        return repository.findAll();
    }
}
