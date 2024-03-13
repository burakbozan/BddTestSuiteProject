package com.ing.suiteapi.service.usecase.scenario.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize
public class ScenarioDetailRetrieveRequest {
    private  Long scenarioId;

    public Long getScenarioId() {
        return scenarioId;
    }
}
