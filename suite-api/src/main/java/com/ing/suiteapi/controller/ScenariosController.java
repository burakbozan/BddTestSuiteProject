package com.ing.suiteapi.controller;

import com.ing.suiteapi.service.dto.*;
import com.ing.suiteapi.service.usecase.project.ResultExecuteApplicationService;
import com.ing.suiteapi.service.usecase.project.ScenarioRetrieveService;
import com.ing.suiteapi.service.usecase.scenario.ScenarioCreateApplicationService;
import com.ing.suiteapi.service.usecase.scenario.ScenarioStepCreateApplicationService;
import com.ing.suiteapi.service.usecase.scenario.model.*;
import com.ing.suiteapi.util.HtmlReader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:8000")
@RestController
@RequestMapping("/api/scenarios")
public class ScenariosController {

    private final HtmlReader htmlReader;
    private final ScenarioStepCreateApplicationService scenarioStepCreateApplicationService;
    private final ScenarioCreateApplicationService scenarioCreateApplicationService;
    private final ScenarioRetrieveService scenarioRetrieveService;
    private final ResultExecuteApplicationService resultExecuteApplicationService;

    public ScenariosController(HtmlReader htmlReader, ScenarioRetrieveService scenarioRetrieveService, ScenarioStepCreateApplicationService scenarioStepCreateApplicationService, ScenarioCreateApplicationService scenarioCreateApplicationService, ScenarioRetrieveService scenarioRetrieveService1, ResultExecuteApplicationService resultExecuteApplicationService) {
        this.htmlReader = htmlReader;
        this.scenarioStepCreateApplicationService = scenarioStepCreateApplicationService;
        this.scenarioCreateApplicationService = scenarioCreateApplicationService;
        this.scenarioRetrieveService = scenarioRetrieveService1;
        this.resultExecuteApplicationService = resultExecuteApplicationService;
    }

    @PostMapping("/list")
    public ResponseEntity<List<ScenarioDto>> list(@RequestBody ScenarioRetrieveRequest scenarioRetrieveRequest) {

        List<ScenarioDto> scenarioDtoList = new ArrayList<>();
        scenarioDtoList.add(
                new ScenarioDto.Builder().
                        id(1L).
                        name("Account Open").
                        isSuccess(true)
                        .build()
        );

        scenarioDtoList.add(
                new ScenarioDto.Builder().
                        id(1L).
                        name("Account Close").
                        isSuccess(false)
                        .build()
        );

        scenarioDtoList.add(
                new ScenarioDto.Builder().
                        id(2L).
                        name("Saving Rate").
                        isSuccess(false)
                        .build()
        );

        scenarioDtoList.add(
                new ScenarioDto.Builder().
                        id(3L).
                        name("Loan Rating").
                        isSuccess(true)
                        .build()
        );

        scenarioDtoList.add(
                new ScenarioDto.Builder().
                        id(3L).
                        name("Loan Accounting").
                        isSuccess(false)
                        .build()
        );

        scenarioDtoList.add(
                new ScenarioDto.Builder().
                        id(3L).
                        name("Loan Rate").
                        isSuccess(true)
                        .build()
        );

        return ResponseEntity.status(HttpStatus.OK).body(scenarioDtoList.stream().filter(f-> f.getId().equals(scenarioRetrieveRequest.getProjectId())).toList());
        //return ResponseEntity.status(HttpStatus.OK).body(scenarioRetrieveService.getScenario());
    }

    @PostMapping("detail/list")
    public ResponseEntity<ScenarioDetailRetrieveResponse> scenarioDetail(@RequestBody ScenarioDetailRetrieveRequest scenarioDetailRetrieveRequest) {

        List<ScenarioParametersDto> scenarioParametersDtoList = new ArrayList<>();
        Map<String, String> params1 = new HashMap<>();
        params1.put("ending_balance", "$0");
        params1.put("amount", "$100");
        scenarioParametersDtoList.add(new ScenarioParametersDto(1L, "Account Open", params1));
        Map<String, String> params2 = new HashMap<>();
        params2.put("ending_balance", "$50");
        params2.put("amount", "$50");
        scenarioParametersDtoList.add(new ScenarioParametersDto(2L, "Account Open", params2));
        Map<String, String> params3 = new HashMap<>();
        params3.put("ending_balance", "$80");
        params3.put("amount", "$20");
        scenarioParametersDtoList.add(new ScenarioParametersDto(3L, "Account Open", params3));

        List<ScenarioStepsDto> scenarioStepsDtoList = new ArrayList<>();
        scenarioStepsDtoList.add(new ScenarioStepsDto(1L, ActionKey.GIVEN, "the account balance is \"$100\""));
        scenarioStepsDtoList.add(new ScenarioStepsDto(2L, ActionKey.AND, "the machine contains enough money"));
        scenarioStepsDtoList.add(new ScenarioStepsDto(3L, ActionKey.AND, "the card is valid"));
        scenarioStepsDtoList.add(new ScenarioStepsDto(4L, ActionKey.WHEN, "the Account Holder requests \"<amount>\""));
        scenarioStepsDtoList.add(new ScenarioStepsDto(5L, ActionKey.THEN, "the ATM should dispense \"<amount>\""));
        scenarioStepsDtoList.add(new ScenarioStepsDto(6L, ActionKey.AND, "the account balance should be \"<ending_balance>\""));
        scenarioStepsDtoList.add(new ScenarioStepsDto(7L, ActionKey.AND, "the card should be returned"));

        //ScenarioDetailRetrieveResponse response = new ScenarioDetailRetrieveResponse(scenarioRetrieveService.getScenarioParameterList(), scenarioRetrieveService.getScenarioStepList());
        ScenarioDetailRetrieveResponse response = new ScenarioDetailRetrieveResponse(scenarioParametersDtoList, scenarioStepsDtoList);
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

    @PostMapping("create/step")
    public ResponseEntity<String> scenarioStepCreate(@RequestBody ScenarioStepCreateRequest scenarioStepCreateRequest) {

        scenarioStepCreateApplicationService.createScenarioStep(scenarioStepCreateRequest);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @PostMapping("create")
    public ResponseEntity<Long> scenarioCreate(@RequestBody ScenarioCreateRequest scenarioCreateRequest) {

        return ResponseEntity.status(HttpStatus.OK).body(scenarioCreateApplicationService.createScenario(scenarioCreateRequest));
    }


    @PostMapping("result/retrieve")
    public ResponseEntity<String> scenarioRetrieveStep(@RequestBody ScenarioResultRetrieveRequest scenarioResultRetrieveRequest) {

        return ResponseEntity.status(HttpStatus.OK).body(htmlReader.readHtmlFile());
    }

    @PostMapping("result/execute")
    public ResponseEntity<String> scenarioExecuteStep(@RequestBody ScenarioExecuteRetrieveRequest scenarioExecuteRetrieveRequest) {

        resultExecuteApplicationService.createResult(scenarioExecuteRetrieveRequest.getProjectId());
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}
