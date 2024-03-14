package com.ing.suiteapi.service.usecase.scenario;

import com.ing.suiteapi.persistence.entity.ScenarioStep;
import com.ing.suiteapi.persistence.entity.ScenarioData;
import com.ing.suiteapi.persistence.repository.ScenarioDataRepository;
import com.ing.suiteapi.persistence.repository.ScenarioStepRepository;
import com.ing.suiteapi.service.usecase.scenario.model.ScenarioStepCreateRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScenarioStepCreateApplicationService {

    private final ScenarioStepRepository scenarioStepRepository;
    private final ScenarioDataRepository scenarioDataRepository;

    public ScenarioStepCreateApplicationService(ScenarioStepRepository scenarioStepRepository, ScenarioDataRepository scenarioDataRepository) {
        this.scenarioStepRepository = scenarioStepRepository;
        this.scenarioDataRepository = scenarioDataRepository;
    }

    public void createScenarioStep(ScenarioStepCreateRequest scenarioStepCreateRequest)
    {
        List<ScenarioData> scenarioDataList  = new ArrayList<>();
        for (var rec: scenarioStepCreateRequest.getScenarioParametersDtoList())
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

        List<ScenarioStep> scenarioStepList = scenarioStepCreateRequest.getScenarioStepsDtoList().stream().map(
                m->  new ScenarioStep()
                        .setScenarioId(scenarioStepCreateRequest.getScenarioId())
                        .setTxnDate(LocalDateTime.now())
                        .setActionWord(m.getActionWord())
                        .setOrderNo(m.getOrder())
                        .setActionKey(m.getActionKey().getValue())
        ).toList();

        scenarioStepRepository.saveAll(scenarioStepList);
        scenarioDataRepository.saveAll(scenarioDataList);
    }
}
