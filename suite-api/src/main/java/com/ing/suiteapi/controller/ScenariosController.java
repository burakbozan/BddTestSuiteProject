package com.ing.suiteapi.controller;

import com.ing.suiteapi.service.dto.Projects;
import com.ing.suiteapi.service.dto.ScenarioDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/scenarios")
public class ScenariosController {

    @PostMapping("/list")
    public ResponseEntity<List<ScenarioDto>> list(@RequestBody Long projectId) {

        List<ScenarioDto> scenarioDtoList = new ArrayList<>();
        scenarioDtoList.add(
                new ScenarioDto.Builder().
                        id(2L).
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
                        id(3L).
                        name("Loan Rating").
                        isSuccess(true)
                        .build()
        );

        scenarioDtoList.add(
                new ScenarioDto.Builder().
                        id(3L).
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

        return ResponseEntity.status(HttpStatus.OK).body(scenarioDtoList);
    }

}
