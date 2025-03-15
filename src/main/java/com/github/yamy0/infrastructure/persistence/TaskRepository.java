package com.github.yamy0.infrastructure.persistence;

import com.github.yamy0.domain.model.Task;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class TaskRepository {

    public List<Task> findAll() {
        return TaskEntity.listAll()
                .stream()
                .map(entity -> ((TaskEntity) entity).toTask())
                .toList();
    }

    @Transactional
    public void save(Task task) {
        TaskEntity entity = TaskEntity.from(task);
        entity.persist();
    }
}
