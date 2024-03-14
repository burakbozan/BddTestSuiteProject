package com.ing.suiteapi.service.usecase.scenario;

import com.ing.suiteapi.persistence.entity.Scenario;
import com.ing.suiteapi.persistence.entity.ScenarioData;
import com.ing.suiteapi.persistence.repository.ScenarioDataRepository;
import com.ing.suiteapi.persistence.repository.ScenarioRepository;
import com.ing.suiteapi.service.dto.ActionKey;
import com.ing.suiteapi.service.dto.ScenarioParametersDto;
import com.ing.suiteapi.service.dto.ScenarioStepsDto;
import com.ing.suiteapi.service.usecase.scenario.model.ScenarioCreateRequest;
import com.ing.suiteapi.service.usecase.scenario.model.ScenarioDetailRetrieveResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ScenarioCreateApplicationService {

    private final ScenarioRepository scenarioRepository;
    private final ScenarioDataRepository scenarioDataRepository;

    public ScenarioCreateApplicationService(ScenarioRepository scenarioRepository, ScenarioDataRepository scenarioDataRepository) {
        this.scenarioRepository = scenarioRepository;
        this.scenarioDataRepository = scenarioDataRepository;
    }

    public void createScenario(ScenarioCreateRequest scenarioCreateRequest)
    {
        List<ScenarioData> scenarioDataList  = new ArrayList<>();
        for (var rec: scenarioCreateRequest.getScenarioParametersDtoList())
        {
            for (String key : rec.getParams().keySet()) {
                String  value = rec.getParams().get(key);

                var scenarioData =  new ScenarioData()
                        .setOrderNo(rec.getOrder())
                        .setTxnDate(LocalDateTime.now())
                        .setName(rec.getName())
                        .setParameterKey(key)
                        .setParameterValue(value);
                scenarioDataList.add(scenarioData);
            }
        }

        List<Scenario> scenarioList = scenarioCreateRequest.getScenarioStepsDtoList().stream().map(
                m->  new Scenario()
                        .setProjectId(scenarioCreateRequest.getScenarioId())
                        .setTxnDate(LocalDateTime.now())
                        .setActionWord(m.getActionWord())
                        .setOrderNo(m.getOrder())
                        .setActionKey(m.getActionKey().getValue())
        ).toList();

        scenarioRepository.saveAll(scenarioList);
        scenarioDataRepository.saveAll(scenarioDataList);
    }
}
