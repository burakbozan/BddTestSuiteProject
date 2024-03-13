package com.ing.suiteapi.controller;

import com.ing.suiteapi.service.usecase.project.retrive.ProjectRetrieveRequestDto;
import com.ing.suiteapi.service.usecase.project.retrive.ProjectRetrieveResponseDto;
import com.ing.suiteapi.util.GherkinUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/projects")
public class ProjectController
{

    @PostMapping("/create")
    public ResponseEntity<String> createProject(@RequestBody String gherkinText) {
        if (GherkinUtils.isValidGherkinSyntax(gherkinText)) {
            return ResponseEntity.ok("Valid Gherkin syntax!");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Gherkin syntax!");
        }
    }

    @PostMapping("/list")
    public ResponseEntity<ProjectRetrieveResponseDto> list(@RequestBody ProjectRetrieveRequestDto projectRetrieveRequestDto) {

        return  null;
    }
}
