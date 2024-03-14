package com.ing.suiteapi.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Table(name = "scenarioStep")
@Entity
public class ScenarioStep {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "scenarioId")
    private Long scenarioId;

    @Column(name = "txnDate")
    private LocalDateTime txnDate;

    @Column(name = "orderNo")
    private Long orderNo;

    @Column(name = "actionKey")
    private String actionKey;

    @Column(name = "actionWord")
    private String actionWord;

    public Long id() {
        return id;
    }

    public ScenarioStep setId(Long id) {
        this.id = id;
        return this;
    }

    public Long projectId() {
        return scenarioId;
    }

    public ScenarioStep setScenarioId(Long scenarioId) {
        this.scenarioId = scenarioId;
        return this;
    }

    public LocalDateTime txnDate() {
        return txnDate;
    }

    public ScenarioStep setTxnDate(LocalDateTime txnDate) {
        this.txnDate = txnDate;
        return this;
    }

    public Long orderNo() {
        return orderNo;
    }

    public ScenarioStep setOrderNo(Long orderNo) {
        this.orderNo = orderNo;
        return this;
    }

    public String actionKey() {
        return actionKey;
    }

    public ScenarioStep setActionKey(String actionKey) {
        this.actionKey = actionKey;
        return this;
    }

    public String actionWord() {
        return actionWord;
    }

    public ScenarioStep setActionWord(String actionWord) {
        this.actionWord = actionWord;
        return this;
    }



}
