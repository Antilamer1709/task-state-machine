package com.antilamer.state.machine.service;

import com.antilamer.state.machine.domain.TaskEntity;
import com.antilamer.state.machine.dto.TaskDTO;
import com.antilamer.state.machine.repository.TaskRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class TaskService {

    private final TaskRepo taskRepo;


    public TaskDTO getTask(Integer id) {
        TaskEntity taskEntity = taskRepo.getOne(id);

        return new TaskDTO(taskEntity);
    }

    @Transactional
    public void createTask(TaskDTO taskDTO) {
        TaskEntity taskEntity = new TaskEntity.Builder()
                .fromDTO(taskDTO)
                .build();

        taskRepo.save(taskEntity);
    }

}
