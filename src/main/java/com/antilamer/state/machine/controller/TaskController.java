package com.antilamer.state.machine.controller;

import com.antilamer.state.machine.dto.TaskDTO;
import com.antilamer.state.machine.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/task")
@AllArgsConstructor
public class TaskController {

    private final TaskService taskService;


    @GetMapping("{id}")
    public TaskDTO getTask(@PathVariable("id") Integer id) {
        return taskService.getTask(id);
    }

}
