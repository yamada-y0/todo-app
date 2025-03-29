package com.github.yamy0.infrastructure.persistence;

import com.github.yamy0.domain.model.Status;
import com.github.yamy0.domain.model.Task;
import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity(name = "task")
public class TaskEntity extends PanacheEntityBase {
    @Id
    String id;
    String name;
    LocalDate dueDate;
    Status status;

    public static TaskEntity from(Task task) {
        TaskEntity entity = new TaskEntity();
        entity.id = task.id();
        entity.name = task.name();
        entity.dueDate = task.dueDate();
        entity.status = task.status();
        return entity;
    }

    public Task toTask() {
        return new Task(id, name, dueDate, status);
    }
}
