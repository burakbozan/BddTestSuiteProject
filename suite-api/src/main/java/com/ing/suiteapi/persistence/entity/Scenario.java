package com.ing.suiteapi.persistence.entity;

import com.ing.suiteapi.service.dto.ActionKey;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Table(name = "scenario")
@Entity
public class Scenario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "projectId")
    private Long projectId;

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

    public Scenario setId(Long id) {
        this.id = id;
        return this;
    }

    public Long projectId() {
        return projectId;
    }

    public Scenario setProjectId(Long projectId) {
        this.projectId = projectId;
        return this;
    }

    public LocalDateTime txnDate() {
        return txnDate;
    }

    public Scenario setTxnDate(LocalDateTime txnDate) {
        this.txnDate = txnDate;
        return this;
    }

    public Long orderNo() {
        return orderNo;
    }

    public Scenario setOrderNo(Long orderNo) {
        this.orderNo = orderNo;
        return this;
    }

    public String actionKey() {
        return actionKey;
    }

    public Scenario setActionKey(String actionKey) {
        this.actionKey = actionKey;
        return this;
    }

    public String actionWord() {
        return actionWord;
    }

    public Scenario setActionWord(String actionWord) {
        this.actionWord = actionWord;
        return this;
    }



}
