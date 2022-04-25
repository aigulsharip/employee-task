package kz.daracademy.controller;

import kz.daracademy.model.TaskRequest;
import kz.daracademy.model.TaskResponse;
import kz.daracademy.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.PUT;
import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public TaskResponse createTask (@RequestBody TaskRequest taskRequest) {
        return taskService.createTask(taskRequest);

    }

    @PutMapping
    public TaskResponse update (@RequestParam String taskId, @RequestBody TaskRequest taskRequest) {
        taskRequest.setTaskId(taskId);
        return taskService.updateTask(taskRequest);
    }

    @GetMapping("/all")
    public List<TaskResponse> getAllTasks () {
        return taskService.getAllTasks();
    }


    @GetMapping
    public TaskResponse getTaskById (@RequestParam String taskId) {
        return taskService.getTaskByTaskId(taskId);
    }

    // ADD get All Tasks
    @GetMapping ("/executor")
    public Page<TaskResponse> getTasksByExecutorId (@RequestParam String executorId, Pageable pageable) {
        return taskService.getTasksByExecutorId(executorId, pageable);
    }

    @GetMapping ("/initiator")
    public Page<TaskResponse> getTasksByInitiatorId (@RequestParam String initiatorId, Pageable pageable) {
        return taskService.getTasksByInitiatorId(initiatorId, pageable);
    }





}
