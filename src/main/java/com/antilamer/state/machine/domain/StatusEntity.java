package com.antilamer.state.machine.domain;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "status")
public class StatusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;

    @Column
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="possible_status",
            joinColumns = @JoinColumn(name="status_id"),
            inverseJoinColumns = @JoinColumn(name="possible_status_id")
    )
    @Fetch(FetchMode.SUBSELECT)
    private List<StatusEntity> possibleStatuses;

}
