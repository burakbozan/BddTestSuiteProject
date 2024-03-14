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

    @Column(name = "projectId")
    private Long projectId;

    public Scenario(Long id, Long scenarioName, Long projectId) {
        this.id = id;
        this.scenarioName = scenarioName;
        this.projectId = projectId;
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

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }
}
