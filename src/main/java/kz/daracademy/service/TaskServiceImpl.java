package kz.daracademy.service;

import kz.daracademy.model.TaskRequest;
import kz.daracademy.model.TaskResponse;
import kz.daracademy.repository.TaskEntity;
import kz.daracademy.repository.TaskRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TaskServiceImpl implements TaskService{

    @Autowired
    private TaskRepository taskRepository;

    static ModelMapper modelMapper = new ModelMapper();

    static {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    @Override
    public TaskResponse createTask(TaskRequest taskRequest) {
        taskRequest.setTaskId(UUID.randomUUID().toString());
        TaskEntity taskEntity = modelMapper.map(taskRequest, TaskEntity.class);
        taskEntity = taskRepository.save(taskEntity);
        return modelMapper.map(taskEntity, TaskResponse.class);
    }

    @Override
    public TaskResponse updateTask(TaskRequest taskRequest) {

        TaskEntity taskEntity = modelMapper.map(taskRequest, TaskEntity.class);
        TaskEntity dbEntity = taskRepository.getTaskEntityByTaskId(taskRequest.getTaskId());

        taskEntity.setTaskId(dbEntity.getTaskId());
        return modelMapper.map(taskEntity, TaskResponse.class);


    }

    @Override
    public TaskResponse getTaskByTaskId(String taskId) {
        TaskEntity taskEntity = taskRepository.getTaskEntityByTaskId(taskId);

        return  modelMapper.map(taskEntity, TaskResponse.class);
    }

    @Override
    public void deleteByTaskId(String taskId) {
        taskRepository.deleteTaskEntitiesByTaskId(taskId);
    }

    @Override
    public Page<TaskResponse> getTasksByInitiatorId(String initiatorId, Pageable pageable) {
        return taskRepository.getTaskEntityByInitiatorId(initiatorId, pageable).map(task -> modelMapper.map(task, TaskResponse.class));
    }

    @Override
    public Page<TaskResponse> getTasksByExecutorId(String executorId, Pageable pageable) {
        return taskRepository.getTaskEntityByExecutorId(executorId, pageable).map(task -> modelMapper.map(task, TaskResponse.class));

    }
}
