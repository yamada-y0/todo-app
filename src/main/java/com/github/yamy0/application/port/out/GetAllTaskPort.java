package com.github.yamy0.application.port.out;

import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import io.smallrye.mutiny.Uni;

import java.util.List;

public interface GetAllTaskPort {
    Uni<List<PanacheEntityBase>> getTasks();
}
