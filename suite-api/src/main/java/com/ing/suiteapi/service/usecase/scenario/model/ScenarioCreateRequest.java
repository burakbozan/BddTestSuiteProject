package com.ing.suiteapi.service.usecase.scenario.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class ScenarioCreateRequest {
    private final Long projectId;

    private final String name;

    public ScenarioCreateRequest(Long projectId, String name) {
        this.projectId = projectId;
        this.name = name;
    }

    public Long getProjectId() {
        return projectId;
    }

    public String getName() {
        return name;
    }
}
