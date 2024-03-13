package com.ing.suiteapi.persistence.repository;

import com.ing.suiteapi.persistence.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
