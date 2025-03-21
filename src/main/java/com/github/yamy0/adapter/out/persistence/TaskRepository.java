package com.github.yamy0.adapter.out.persistence;

import com.github.yamy0.domain.model.Task;
import com.github.yamy0.infrastructure.persistence.TaskEntity;
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
