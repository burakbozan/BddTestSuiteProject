package com.ing.suiteapi.service.usecase.scenario;

import com.ing.suiteapi.persistence.entity.Scenario;
import com.ing.suiteapi.persistence.entity.ScenarioData;
import com.ing.suiteapi.persistence.entity.ScenarioStep;
import com.ing.suiteapi.persistence.repository.ScenarioRepository;
import com.ing.suiteapi.service.usecase.scenario.model.ScenarioCreateRequest;
import com.ing.suiteapi.service.usecase.scenario.model.ScenarioStepCreateRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScenarioCreateApplicationService {

    private final ScenarioRepository scenarioRepository;

    public ScenarioCreateApplicationService(ScenarioRepository scenarioRepository) {
        this.scenarioRepository = scenarioRepository;
    }

    public Long createScenario(ScenarioCreateRequest scenarioCreateRequest)
    {
        Scenario scenario = new Scenario(scenarioCreateRequest.getName(),scenarioCreateRequest.getProjectId());
        return scenarioRepository.save(scenario).getId();
    }
}
