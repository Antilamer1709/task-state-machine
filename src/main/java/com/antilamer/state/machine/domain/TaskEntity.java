package com.antilamer.state.machine.domain;

import com.antilamer.state.machine.dto.TaskDTO;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "task")
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id")
    private StatusEntity status;


    public static class Builder {

        private TaskEntity task;

        public Builder() {
            task = new TaskEntity();
        }

        public Builder fromDTO(TaskDTO taskDTO) {
            task.name = taskDTO.getName();

            return this;
        }

        public Builder withStatus(StatusEntity status) {
            task.status = status;

            return this;
        }

        public TaskEntity build() {
            return task;
        }
    }
}
