package com.github.yamy0.domain.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record Task(
        String name,
        LocalDate dueDate,
        boolean isCompleted
) {
}
