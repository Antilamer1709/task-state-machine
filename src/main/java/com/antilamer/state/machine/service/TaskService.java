package com.antilamer.state.machine.service;

import com.antilamer.state.machine.dto.TaskDTO;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    public TaskDTO getTask(Integer id) {
        return new TaskDTO();
    }

}
