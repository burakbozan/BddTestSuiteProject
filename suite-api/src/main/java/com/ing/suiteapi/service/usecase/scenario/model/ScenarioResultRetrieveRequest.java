package com.ing.suiteapi.service.usecase.scenario.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize
public class ScenarioResultRetrieveRequest {
    private  Long scenarioId;

    public Long getScenarioId() {
        return scenarioId;
    }
}
