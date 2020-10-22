package com.antilamer.state.machine.dto;

import com.antilamer.state.machine.domain.StatusEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class StatusDTO {

    private Integer id;

    private String name;

    private List<StatusDTO> possibleStatuses;


    public StatusDTO(StatusEntity statusEntity, boolean deep) {
        this.id = statusEntity.getId();
        this.name = statusEntity.getName();
        if (deep) {
            this.possibleStatuses = statusEntity.getPossibleStatuses()
                    .stream()
                    .map(x -> new StatusDTO(x, false))
                    .collect(Collectors.toList());
        }
    }
}
