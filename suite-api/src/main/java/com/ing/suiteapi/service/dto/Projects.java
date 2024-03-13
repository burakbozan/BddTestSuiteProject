package com.ing.suiteapi.service.dto;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class Projects  {

    private Long id;
    private String name;
    private Long passedCount;
    private Long failedCount;

    public Projects(Long id, String name, Long passedCount, Long failedCount) {
        this.id = id;
        this.name = name;
        this.passedCount = passedCount;
        this.failedCount = failedCount;
    }

    private Projects(Builder builder) {
        id = builder.id;
        name = builder.name;
        passedCount = builder.passedCount;
        failedCount = builder.failedCount;
    }

    public static final class Builder {
        private Long id;
        private String name;
        private Long passedCount;
        private Long failedCount;

        public Builder() {
        }

        public Builder id(Long val) {
            id = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder passedCount(Long val) {
            passedCount = val;
            return this;
        }

        public Builder failedCount(Long val) {
            failedCount = val;
            return this;
        }

        public Projects build() {
            return new Projects(this);
        }
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getPassedCount() {
        return passedCount;
    }

    public Long getFailedCount() {
        return failedCount;
    }
}
