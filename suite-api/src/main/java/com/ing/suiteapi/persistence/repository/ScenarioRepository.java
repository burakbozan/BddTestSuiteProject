package com.ing.suiteapi.persistence.repository;

import com.ing.suiteapi.persistence.entity.ScenarioStep;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScenarioRepository extends JpaRepository<ScenarioStep, Long> {
}
