package com.github.yamy0.application.port.in;

import com.github.yamy0.domain.model.Task;

import java.util.List;

public interface GetAllTaskUseCase {
    List<Task> getAllTasks();
}
