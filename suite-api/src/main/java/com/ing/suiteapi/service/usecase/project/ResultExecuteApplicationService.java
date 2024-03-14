package com.ing.suiteapi.service.usecase.project;

import com.ing.suiteapi.persistence.entity.ScenarioStep;
import com.ing.suiteapi.persistence.repository.ScenarioDataRepository;
import com.ing.suiteapi.persistence.repository.ScenarioRepository;
import com.ing.suiteapi.persistence.repository.ScenarioStepRepository;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class ResultExecuteApplicationService {

    private final ScenarioStepRepository scenarioStepRepository;
    private final ScenarioDataRepository scenarioDataRepository;
    private final ScenarioRepository scenarioRepository;

    public ResultExecuteApplicationService(ScenarioStepRepository scenarioStepRepository, ScenarioDataRepository scenarioDataRepository, ScenarioRepository scenarioRepository) {
        this.scenarioStepRepository = scenarioStepRepository;
        this.scenarioDataRepository = scenarioDataRepository;
        this.scenarioRepository = scenarioRepository;
    }

    public void createResult(Long projectId)
    {
       List<Long> scenarioList = scenarioStepRepository.findAll().stream().
                filter(f-> f.scenarioId().equals(projectId)).map(ScenarioStep::getScenarioId).toList();

        String joined = "Feature:Auto test \n Scenario: ";
        for (var scenarioId : scenarioList.stream().distinct().toList())
        {
            joined =  joined + scenarioRepository.findAll().stream().
                    filter(f -> f.getId().equals(scenarioId)).findFirst().get().getScenarioName() + "\n";

            List<String> listString =  scenarioStepRepository.findAll().stream().
                    filter(f-> f.scenarioId().equals(scenarioId))
                    .map(m-> m.actionKey() + m.actionWord() ).toList();

            joined = joined + String.join("\n", listString);
        }


        try {

            FileOutputStream fos = new FileOutputStream("dosya.txt");
            byte[] veri = joined.getBytes();
            fos.write(veri);
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
