package com.antilamer.state.machine.repository;

import com.antilamer.state.machine.domain.StatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepo extends JpaRepository<StatusEntity, Integer> {
}
