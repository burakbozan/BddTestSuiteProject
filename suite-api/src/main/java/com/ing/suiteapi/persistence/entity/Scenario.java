package com.ing.suiteapi.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Table(name = "scenario")
@Entity
public class Scenario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "scenarioName")
    private Long scenarioName;

    public Scenario(Long id, Long scenarioName) {
        this.id = id;
        this.scenarioName = scenarioName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getScenarioName() {
        return scenarioName;
    }

    public void setScenarioName(Long scenarioName) {
        this.scenarioName = scenarioName;
    }
}
