package com.ing.suiteapi.service.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class ScenarioDto {
    private final Long id;
    private final String name;
    private final Boolean isSuccess;

    public ScenarioDto(Builder builder) {
        id = builder.id;
        name = builder.name;
        isSuccess = builder.isSuccess;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public static final class Builder {
        private Long id;
        private String name;
        private Boolean isSuccess;

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

        public Builder isSuccess(Boolean val) {
            isSuccess = val;
            return this;
        }

        public ScenarioDto build() {
            return new ScenarioDto(this);
        }
    }
}
