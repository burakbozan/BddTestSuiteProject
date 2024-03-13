package com.ing.suiteapi.service.usecase.project;

import com.ing.suiteapi.persistence.repository.ScenarioRepository;
import com.ing.suiteapi.service.dto.Projects;
import com.ing.suiteapi.service.dto.ScenarioDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScenarioRetrieveService {

    private final ScenarioRepository scenarioRepository;

    public ScenarioRetrieveService(ScenarioRepository scenarioRepository) {
        this.scenarioRepository = scenarioRepository;
    }

    public List<ScenarioDto> getScenario(){
        return scenarioRepository.findAll().stream().map(m -> new ScenarioDto.Builder().id(m.projectId()).build()).toList();
    }
}
