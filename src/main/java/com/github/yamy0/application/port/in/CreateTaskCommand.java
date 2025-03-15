package com.github.yamy0.application.port.in;

import java.time.LocalDate;

public record CreateTaskCommand(
        String name,
        LocalDate dueDate
) {
}
