package com.antilamer.state.machine.service;

import com.antilamer.state.machine.domain.TaskEntity;
import com.antilamer.state.machine.dto.TaskDTO;
import com.antilamer.state.machine.repository.TaskRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@AllArgsConstructor
public class TaskService {

    private final TaskRepo taskRepo;


    public TaskDTO getTask(Integer id) {
        log.info("getTask with id: {}", id);
        TaskEntity taskEntity = taskRepo.getOne(id);

        log.info("{} is in status: {}", taskEntity.getName(), taskEntity.getStatus().getName());
        log.info("Possible statuses:");
        taskEntity.getStatus().getPossibleStatuses().forEach(possibleStatus -> {
            log.info(possibleStatus.getName());
        });

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
