package com.github.yamy0.application.service;

import com.github.yamy0.application.port.in.GetAllTaskUseCase;
import com.github.yamy0.application.port.out.GetAllTaskPort;
import com.github.yamy0.domain.model.Task;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
class GetAllTaskService implements GetAllTaskUseCase {
    private final GetAllTaskPort getAllTaskPort;


    public GetAllTaskService(GetAllTaskPort getAllTaskPort) {
        this.getAllTaskPort = getAllTaskPort;
    }

    @Override
    public List<Task> getAllTasks() {
        return getAllTaskPort.getTasks();
    }
}
