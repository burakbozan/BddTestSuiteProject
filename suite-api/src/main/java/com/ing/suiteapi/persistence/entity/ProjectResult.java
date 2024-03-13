package com.ing.suiteapi.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Table(name = "projectResult")
@Entity
public class ProjectResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "projectId")
    private Long projectId;

    @Column(name = "txnDate")
    private LocalDateTime txnDate;

    @Column(name = "passedResults")
    private Long passedResults;

    @Column(name = "failedResults")
    private Long failedResults;

    @Column(name = "scenario")
    private String scenario;

    public Long id() {
        return id;
    }

    public ProjectResult setId(Long id) {
        this.id = id;
        return this;
    }

    public Long projectId() {
        return projectId;
    }

    public ProjectResult setProjectId(Long projectId) {
        this.projectId = projectId;
        return this;
    }

    public LocalDateTime txnDate() {
        return txnDate;
    }

    public ProjectResult setTxnDate(LocalDateTime txnDate) {
        this.txnDate = txnDate;
        return this;
    }

    public Long passedResults() {
        return passedResults;
    }

    public ProjectResult setPassedResults(Long passedResults) {
        this.passedResults = passedResults;
        return this;
    }

    public Long failedResults() {
        return failedResults;
    }

    public ProjectResult setFailedResults(Long failedResults) {
        this.failedResults = failedResults;
        return this;
    }

    public String scenario() {
        return scenario;
    }

    public ProjectResult setScenario(String scenario) {
        this.scenario = scenario;
        return this;
    }
}
