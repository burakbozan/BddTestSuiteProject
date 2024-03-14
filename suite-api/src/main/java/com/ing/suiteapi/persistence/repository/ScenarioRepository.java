package com.ing.suiteapi.persistence.repository;


import com.ing.suiteapi.persistence.entity.Scenario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScenarioRepository extends JpaRepository<Scenario, Long> {
}
