package com.github.yamy0.application.port.in;

import com.github.yamy0.domain.model.Task;
import io.smallrye.mutiny.Uni;

import java.util.List;

public interface GetAllTaskUseCase {
    Uni<List<Task>> getAllTasks();
}
