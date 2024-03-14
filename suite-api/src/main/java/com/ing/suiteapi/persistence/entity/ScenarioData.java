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

    @Column(name = "orderNo")
    private Long orderNo;

    @Column(name = "scenarioName")
    private String scenarioName;

    @Column(name = "parameterKey")
    private String parameterKey;

    @Column(name = "parameterValue")
    private String parameterValue;

    public Long id() {
        return id;
    }

    public ScenarioData setId(Long id) {
        this.id = id;
        return this;
    }

    public ScenarioData setOrderNo(Long orderNo) {
        this.orderNo = orderNo;
        return this;
    }

    public ScenarioData setName(String scenarioName) {
        this.scenarioName = scenarioName;
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

    public String parameterValue() {
        return parameterValue;
    }

    public ScenarioData setParameterValue(String parameterValue) {
        this.parameterValue = parameterValue;
        return this;
    }

}
