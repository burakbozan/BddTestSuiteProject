package com.ing.suiteapi.service.usecase.scenario.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize
public class ScenarioExecuteRetrieveRequest {
    private  Long projectId;

    public Long getProjectId() {
        return projectId;
    }
}
