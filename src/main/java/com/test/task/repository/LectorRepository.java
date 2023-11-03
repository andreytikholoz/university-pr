package com.test.task.repository;

import com.test.task.entity.LectorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LectorRepository extends JpaRepository<LectorEntity, UUID> {
}
