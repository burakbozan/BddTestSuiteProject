package com.ing.suiteapi.service.usecase.scenario.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ing.suiteapi.service.dto.ScenarioParametersDto;
import com.ing.suiteapi.service.dto.ScenarioStepsDto;

import java.util.List;

@JsonSerialize
public class ScenarioCreateRequest {
    private final Long scenarioId;
    private final List<ScenarioParametersDto> scenarioParametersDtoList;
    private final List<ScenarioStepsDto> scenarioStepsDtoList;

    public ScenarioCreateRequest(Long scenarioId, List<ScenarioParametersDto> scenarioParametersDtoList, List<ScenarioStepsDto> scenarioStepsDtoList) {
        this.scenarioId = scenarioId;
        this.scenarioParametersDtoList = scenarioParametersDtoList;
        this.scenarioStepsDtoList = scenarioStepsDtoList;
    }

    public List<ScenarioParametersDto> getScenarioParametersDtoList() {
        return scenarioParametersDtoList;
    }

    public List<ScenarioStepsDto> getScenarioStepsDtoList() {
        return scenarioStepsDtoList;
    }

    public Long getScenarioId() {
        return scenarioId;
    }
}
