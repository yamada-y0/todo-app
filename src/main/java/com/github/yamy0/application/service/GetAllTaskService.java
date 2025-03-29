package com.github.yamy0.application.service;

import com.github.yamy0.application.port.in.GetAllTaskUseCase;
import com.github.yamy0.application.port.out.GetAllTaskPort;
import com.github.yamy0.domain.model.Task;
import com.github.yamy0.infrastructure.persistence.TaskEntity;
import io.quarkus.hibernate.reactive.panache.Panache;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
class GetAllTaskService implements GetAllTaskUseCase {
    private final GetAllTaskPort getAllTaskPort;


    public GetAllTaskService(GetAllTaskPort getAllTaskPort) {
        this.getAllTaskPort = getAllTaskPort;
    }

    @Override
    public Uni<List<Task>> getAllTasks() {
        return Panache.withTransaction(getAllTaskPort::getTasks)
                .onItem().transform(list -> list.stream()
                        .map(TaskEntity.class::cast)
                        .map(TaskEntity::toTask)
                        .toList());
    }
}
