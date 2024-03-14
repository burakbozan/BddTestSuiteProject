package com.ing.suiteapi.persistence.repository;

import com.ing.suiteapi.persistence.entity.Scenario;
import com.ing.suiteapi.persistence.entity.ScenarioData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScenarioDataRepository extends JpaRepository<ScenarioData, Long> {
}
