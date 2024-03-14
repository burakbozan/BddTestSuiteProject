package com.ing.suiteapi.service.usecase.project;

import com.ing.suiteapi.persistence.entity.ScenarioData;
import com.ing.suiteapi.persistence.repository.ScenarioDataRepository;
import com.ing.suiteapi.persistence.repository.ScenarioStepRepository;
import com.ing.suiteapi.service.dto.ScenarioDto;
import com.ing.suiteapi.service.dto.ScenarioParametersDto;
import com.ing.suiteapi.service.dto.ScenarioStepsDto;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ScenarioRetrieveService {

    private final ScenarioStepRepository scenarioStepRepository;

    private final ScenarioDataRepository scenarioDataRepository;

    public ScenarioRetrieveService(ScenarioStepRepository scenarioStepRepository, ScenarioDataRepository scenarioDataRepository) {
        this.scenarioStepRepository = scenarioStepRepository;
        this.scenarioDataRepository = scenarioDataRepository;
    }

    public List<ScenarioDto> getScenario(){
        return scenarioStepRepository.findAll().stream().map(m -> new ScenarioDto.Builder().id(m.projectId()).build()).toList();
    }

    public List<ScenarioParametersDto> getScenarioParameterList(){

        //List<ScenarioData> scenarioDataList = scenarioDataRepository.findAllById(Collections.singleton(1L)).stream().map(a -> new ScenarioData().setOrderNo().setScenarioName().set).toList();
        //params.put(scenarioData.parameterKey(), scenarioData.parameterValue());
        //return scenarioRepository.findAll().stream().map(m -> new ScenarioParametersDto(scenarioData.orderNo(), scenarioData.scenarioName(), params)).toList();

        return null;
    }

    public List<ScenarioStepsDto> getScenarioStepList(){
        /*
        Scenario scenario = scenarioRepository.findAllById(Collections.singleton(1L)).get(0);
        return scenarioRepository.findAll().stream().map(m -> new ScenarioStepsDto(scenario.orderNo(), scenario.setActionKey(), scenario.actionWord()));
         */
        return null;
    }
}
