package com.ing.suiteapi.controller;

import com.ing.suiteapi.service.dto.*;
import com.ing.suiteapi.service.usecase.scenario.ScenarioCreateApplicationService;
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
    private final ScenarioCreateApplicationService scenarioCreateApplicationService;

    public ScenariosController(HtmlReader htmlReader, ScenarioCreateApplicationService scenarioCreateApplicationService) {
        this.htmlReader = htmlReader;
        this.scenarioCreateApplicationService = scenarioCreateApplicationService;
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
                        id(2L).
                        name("Account Close").
                        isSuccess(true)
                        .build()
        );

        scenarioDtoList.add(
                new ScenarioDto.Builder().
                        id(1L).
                        name("Saving Rate").
                        isSuccess(false)
                        .build()
        );

        scenarioDtoList.add(
                new ScenarioDto.Builder().
                        id(1L).
                        name("Loan Rating").
                        isSuccess(true)
                        .build()
        );

        scenarioDtoList.add(
                new ScenarioDto.Builder().
                        id(2L).
                        name("Loan Accounting").
                        isSuccess(true)
                        .build()
        );

        scenarioDtoList.add(
                new ScenarioDto.Builder().
                        id(3L).
                        name("Loan Rate").
                        isSuccess(true)
                        .build()
        );


        return ResponseEntity.status(HttpStatus.OK).body(scenarioDtoList.stream().filter(f -> f.getId().equals(scenarioRetrieveRequest.getProjectId())).toList());
    }

    @PostMapping("detail/list")
    public ResponseEntity<ScenarioDetailRetrieveResponse> scenarioDetail(@RequestBody ScenarioDetailRetrieveRequest scenarioDetailRetrieveRequest) {

        List<ScenarioParametersDto> scenarioParametersDtoList = new ArrayList<>();
        Map<String, String> params = new HashMap<>();
        params.put("ending_balance", "$0");
        params.put("amount", "$100");
        scenarioParametersDtoList.add(new ScenarioParametersDto(1L, "Account Open", params));
        params.clear();
        params.put("ending_balance", "$50");
        params.put("amount", "$50");
        scenarioParametersDtoList.add(new ScenarioParametersDto(1L, "Account Open", params));
        params.clear();
        params.put("ending_balance", "$80");
        params.put("amount", "$20");
        scenarioParametersDtoList.add(new ScenarioParametersDto(1L, "Account Open", params));

        List<ScenarioStepsDto> scenarioStepsDtoList = new ArrayList<>();
        scenarioStepsDtoList.add(new ScenarioStepsDto(1L, ActionKey.GIVEN, "the account balance is \"$100\""));
        scenarioStepsDtoList.add(new ScenarioStepsDto(2L, ActionKey.AND, "the machine contains enough money"));
        scenarioStepsDtoList.add(new ScenarioStepsDto(3L, ActionKey.AND, "the card is valid"));
        scenarioStepsDtoList.add(new ScenarioStepsDto(4L, ActionKey.WHEN, "the Account Holder requests \"<amount>\""));
        scenarioStepsDtoList.add(new ScenarioStepsDto(5L, ActionKey.THEN, "the ATM should dispense \"<amount>\""));
        scenarioStepsDtoList.add(new ScenarioStepsDto(6L, ActionKey.AND, "the account balance should be \"<ending_balance>\""));
        scenarioStepsDtoList.add(new ScenarioStepsDto(7L, ActionKey.AND, "the card should be returned"));

        ScenarioDetailRetrieveResponse response = new ScenarioDetailRetrieveResponse(scenarioParametersDtoList, scenarioStepsDtoList);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("crate")
    public ResponseEntity<String> scenarioCreate(@RequestBody ScenarioCreateRequest scenarioCreateRequest) {

        scenarioCreateApplicationService.createScenario(scenarioCreateRequest);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }


    @PostMapping("result/retrieve")
    public ResponseEntity<String> scenarioRetrieveStep(@RequestBody ScenarioResultRetrieveRequest scenarioResultRetrieveRequest) {

        return ResponseEntity.status(HttpStatus.OK).body(htmlReader.readHtmlFile());
    }

    @PostMapping("result/execute")
    public ResponseEntity<String> scenarioExecuteStep(@RequestBody ScenarioExecuteRetrieveRequest scenarioExecuteRetrieveRequest) {

        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}
