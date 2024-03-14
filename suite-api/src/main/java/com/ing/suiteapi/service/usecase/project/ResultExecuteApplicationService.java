package com.ing.suiteapi.service.usecase.project;

import com.ing.suiteapi.persistence.repository.ScenarioDataRepository;
import com.ing.suiteapi.persistence.repository.ScenarioRepository;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ResultExecuteApplicationService {

    private final ScenarioRepository scenarioRepository;
    private final ScenarioDataRepository scenarioDataRepository;

    public ResultExecuteApplicationService(ScenarioRepository scenarioRepository, ScenarioDataRepository scenarioDataRepository) {
        this.scenarioRepository = scenarioRepository;
        this.scenarioDataRepository = scenarioDataRepository;
    }

    public void createResult(Long projectId)
    {
       List<String> listString =   scenarioRepository.findAll().stream().
                filter(f-> f.projectId().equals(projectId))
                .map(m-> m.actionKey() + m.actionWord() ).toList();

        String joined = String.join("\n", listString);

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
