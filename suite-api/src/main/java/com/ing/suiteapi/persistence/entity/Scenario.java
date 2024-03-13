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

    @Column(name = "order")
    private Long order;

    @Column(name = "actionKey")
    private String actionKey;

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

    public Long order() {
        return order;
    }

    public Scenario setOrder(Long order) {
        this.order = order;
        return this;
    }

    public String actionKey() {
        return actionKey;
    }

    public Scenario setActionKey(String actionKey) {
        this.actionKey = actionKey;
        return this;
    }
}
