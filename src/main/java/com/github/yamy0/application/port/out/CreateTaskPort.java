package com.github.yamy0.application.port.out;

import com.github.yamy0.domain.model.Task;
import io.smallrye.mutiny.Uni;
import org.jboss.resteasy.reactive.RestResponse;

public interface CreateTaskPort {
    Uni<RestResponse<Task>> createTask(Task task);
}
