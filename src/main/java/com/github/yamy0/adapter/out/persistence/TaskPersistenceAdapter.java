package com.github.yamy0.adapter.out.persistence;

import com.github.yamy0.application.port.out.CreateTaskPort;
import com.github.yamy0.application.port.out.GetAllTaskPort;
import com.github.yamy0.domain.model.Task;
import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import org.jboss.resteasy.reactive.RestResponse;

import java.util.List;

@ApplicationScoped
class TaskPersistenceAdapter implements CreateTaskPort, GetAllTaskPort {
    private final TaskRepository repository;

    public TaskPersistenceAdapter(TaskRepository repository) {
        this.repository = repository;
    }

    @Override
    public Uni<RestResponse<Task>> createTask(Task task) {
        return repository.save(task);
    }

    @Override
    public Uni<List<PanacheEntityBase>> getTasks() {
        return repository.findAll();
    }
}
