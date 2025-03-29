package com.github.yamy0.application.port.in;

import com.github.yamy0.domain.model.Task;
import io.smallrye.mutiny.Uni;
import org.jboss.resteasy.reactive.RestResponse;

public interface CreateTaskUseCase {
    Uni<RestResponse<Task>> createTask(CreateTaskCommand command);
}
