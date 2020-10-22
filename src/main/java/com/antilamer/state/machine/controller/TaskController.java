package com.antilamer.state.machine.controller;

import com.antilamer.state.machine.dto.TaskDTO;
import com.antilamer.state.machine.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/task")
@AllArgsConstructor
public class TaskController {

    private final TaskService taskService;


    @GetMapping("{id}")
    public TaskDTO getTask(@PathVariable("id") Integer id) {
        return taskService.getTask(id);
    }

    @PutMapping
    public TaskDTO createTask(@RequestBody TaskDTO task) {
        return taskService.createTask(task);
    }

    @PostMapping
    public TaskDTO editTask(@RequestBody TaskDTO task) {
        return taskService.editTask(task);
    }

}
