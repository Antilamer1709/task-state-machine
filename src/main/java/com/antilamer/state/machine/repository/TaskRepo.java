package com.antilamer.state.machine.repository;

import com.antilamer.state.machine.domain.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepo extends JpaRepository<TaskEntity, Integer> {
}
