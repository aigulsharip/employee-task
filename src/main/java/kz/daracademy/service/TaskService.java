package kz.daracademy.service;

import kz.daracademy.model.TaskRequest;
import kz.daracademy.model.TaskResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TaskService {
    TaskResponse createTask (TaskRequest taskRequest);

    TaskResponse updateTask (TaskRequest taskRequest);

    TaskResponse getTaskByTaskId (String taskId);

    void deleteByTaskId (String taskId);

    Page<TaskResponse> getTasksByInitiatorId (String initiatorId, Pageable pageable);

    Page<TaskResponse> getTasksByExecutorId (String executorId, Pageable pageable);



}
