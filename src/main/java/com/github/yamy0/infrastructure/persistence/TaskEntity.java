package com.github.yamy0.infrastructure.persistence;

import com.github.yamy0.domain.model.Task;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity(name = "task")
public class TaskEntity extends PanacheEntity {
    String name;
    LocalDate dueDate;
    boolean isCompleted;

    public static TaskEntity from(Task task) {
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.name = task.name();
        taskEntity.dueDate = task.dueDate();
        taskEntity.isCompleted = task.isCompleted();
        return taskEntity;
    }

    public Task toTask() {
        return new Task(name, dueDate, isCompleted);
    }
}
