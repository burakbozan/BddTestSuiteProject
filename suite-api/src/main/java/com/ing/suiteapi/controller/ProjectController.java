package com.ing.suiteapi.controller;

import com.ing.suiteapi.service.dto.Projects;
import com.ing.suiteapi.service.usecase.project.ProjectRetrieveApplicationService;
import com.ing.suiteapi.util.GherkinUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8000")
@RestController
@RequestMapping("/api/projects")
public class ProjectController{

    private ProjectRetrieveApplicationService projectRetrieveApplicationService;

    public ProjectController(ProjectRetrieveApplicationService projectRetrieveApplicationService) {
        this.projectRetrieveApplicationService = projectRetrieveApplicationService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createProject(@RequestBody String gherkinText) {
        if (GherkinUtils.isValidGherkinSyntax(gherkinText)) {
            return ResponseEntity.ok("Valid Gherkin syntax!");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Gherkin syntax!");
        }
    }

    @PostMapping("/list")
    public ResponseEntity<List<Projects>> list() {

        /*
        List<Projects> projects = new ArrayList<>();
        projects.add(new Projects.Builder().name("saving").id(1L).failedCount(5L).passedCount(26L).build());
        projects.add(new Projects.Builder().name("account").id(2L).failedCount(0L).passedCount(56L).build());
        projects.add(new Projects.Builder().name("loan").id(3L).failedCount(0L).passedCount(2326L).build());
         */

        return  ResponseEntity.status(HttpStatus.OK).body(projectRetrieveApplicationService.retrieveProject());
    }
}
