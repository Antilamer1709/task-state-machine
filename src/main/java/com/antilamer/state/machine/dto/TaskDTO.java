package com.antilamer.state.machine.dto;

import com.antilamer.state.machine.domain.TaskEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TaskDTO {

    private Integer id;

    private String name;

    public TaskDTO(TaskEntity taskEntity) {
        this.id = taskEntity.getId();
        this.name = taskEntity.getName();
    }
}
