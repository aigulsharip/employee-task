package kz.daracademy.service;

import kz.daracademy.model.TaskRequest;
import kz.daracademy.model.TaskResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TaskService {
    TaskResponse createTask (TaskRequest taskRequest);

    TaskResponse updateTask (TaskRequest taskRequest);

    TaskResponse getTaskByTaskId (String taskId);
    List<TaskResponse> getAllTasks();


    void deleteByTaskId (String taskId);

    Page<TaskResponse> getTasksByInitiatorId (String initiatorId, Pageable pageable);

    Page<TaskResponse> getTasksByExecutorId (String executorId, Pageable pageable);



}
