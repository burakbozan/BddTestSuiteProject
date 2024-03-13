package com.ing.suiteapi.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Table(name = "projectResult")
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

    private ProjectResult(Builder builder) {
        id = builder.id;
        projectId = builder.projectId;
        txnDate = builder.txnDate;
        passedResults = builder.passedResults;
        failedResults = builder.failedResults;
        scenario = builder.scenario;
    }

    public static final class Builder {
        private Long id;
        private Long projectId;
        private LocalDateTime txnDate;
        private Long passedResults;
        private Long failedResults;
        private String scenario;

        public Builder() {
        }

        public Builder id(Long val) {
            id = val;
            return this;
        }

        public Builder projectId(Long val) {
            projectId = val;
            return this;
        }

        public Builder txnDate(LocalDateTime val) {
            txnDate = val;
            return this;
        }

        public Builder passedResults(Long val) {
            passedResults = val;
            return this;
        }

        public Builder failedResults(Long val) {
            failedResults = val;
            return this;
        }

        public Builder scenario(String val) {
            scenario = val;
            return this;
        }

        public ProjectResult build() {
            return new ProjectResult(this);
        }
    }
}
