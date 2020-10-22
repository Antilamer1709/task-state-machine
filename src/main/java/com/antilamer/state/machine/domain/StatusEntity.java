package com.antilamer.state.machine.domain;

import lombok.Data;

import javax.persistence.*;

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

}
