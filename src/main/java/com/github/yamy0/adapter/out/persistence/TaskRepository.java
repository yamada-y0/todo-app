package com.github.yamy0.adapter.out.persistence;

import com.github.yamy0.domain.model.Task;
import com.github.yamy0.infrastructure.persistence.TaskEntity;
import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import org.jboss.resteasy.reactive.RestResponse;

import java.util.List;

@ApplicationScoped
public class TaskRepository {

    public Uni<List<PanacheEntityBase>> findAll() {
        return TaskEntity.listAll();
    }

    public Uni<RestResponse<Task>> save(Task task) {
        TaskEntity entity = TaskEntity.from(task);
        return entity.persist()
                .replaceWith(RestResponse.status(RestResponse.Status.CREATED, task));
    }
}
