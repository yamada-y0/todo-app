package com.github.yamy0.application.port.out;

import com.github.yamy0.domain.model.Task;

public interface CreateTaskPort {
    void createTask(Task task);
}
