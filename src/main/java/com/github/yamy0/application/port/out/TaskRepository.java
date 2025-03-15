package com.github.yamy0.application.port.out;

import com.github.yamy0.domain.model.Task;

import java.util.List;

public interface TaskRepository {
    List<Task> findAll();

    void save(Task task);
}
