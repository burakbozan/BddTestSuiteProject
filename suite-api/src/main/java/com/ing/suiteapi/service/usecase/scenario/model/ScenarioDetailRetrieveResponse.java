package com.ing.suiteapi.service.usecase.scenario.model;

import com.ing.suiteapi.service.dto.ScenarioParametersDto;
import com.ing.suiteapi.service.dto.ScenarioStepsDto;

import java.util.List;

public class ScenarioDetailRetrieveResponse {
    private List<ScenarioParametersDto> scenarioParametersDtoList;
    private List<ScenarioStepsDto> scenarioStepsDtoList;
}
