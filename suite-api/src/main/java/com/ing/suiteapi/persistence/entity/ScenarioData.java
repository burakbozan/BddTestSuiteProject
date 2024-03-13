package com.ing.suiteapi.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Table(name = "scenarioData")
@Entity
public class ScenarioData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "txnDate")
    private LocalDateTime txnDate;

    @Column(name = "parameterKey")
    private String parameterKey;

    @Column(name = "parameterValue")
    private Long parameterValue;

    @Column(name = "example")
    private Long example;

    public Long id() {
        return id;
    }

    public ScenarioData setId(Long id) {
        this.id = id;
        return this;
    }

    public LocalDateTime txnDate() {
        return txnDate;
    }

    public ScenarioData setTxnDate(LocalDateTime txnDate) {
        this.txnDate = txnDate;
        return this;
    }

    public String parameterKey() {
        return parameterKey;
    }

    public ScenarioData setParameterKey(String parameterKey) {
        this.parameterKey = parameterKey;
        return this;
    }

    public Long parameterValue() {
        return parameterValue;
    }

    public ScenarioData setParameterValue(Long parameterValue) {
        this.parameterValue = parameterValue;
        return this;
    }

    public Long example() {
        return example;
    }

    public ScenarioData setExample(Long example) {
        this.example = example;
        return this;
    }
}
