package com.antilamer.state.machine.enums;

public enum Status {
    NEW(1),
    IN_DEVELOPMENT(2);

    private final Integer id;

    private Status(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
