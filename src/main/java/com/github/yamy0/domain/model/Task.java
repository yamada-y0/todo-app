package com.github.yamy0.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDate;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record Task(
        String id,
        String name,
        LocalDate dueDate,
        Status status
) {
    public Task(String name, LocalDate dueDate) {
        this(UUID.randomUUID().toString(), name, dueDate, Status.TODO);
    }
}
