package com.github.yamy0.infrastructure.persistence;

import com.github.yamy0.application.port.out.TaskRepository;
import com.github.yamy0.domain.model.Task;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class TaskRepositoryImpl implements TaskRepository {

    @Override
    public List<Task> findAll() {
        return TaskEntity.listAll()
                .stream()
                .map(entity -> ((TaskEntity) entity).toTask())
                .toList();
    }

    @Transactional
    @Override
    public void save(Task task) {
        TaskEntity entity = TaskEntity.from(task);
        entity.persist();
    }
}
