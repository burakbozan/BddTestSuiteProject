package com.ing.suiteapi.controller;

import com.ing.suiteapi.service.FeatureService;
import com.ing.suiteapi.service.dto.FeatureDto;
import com.ing.suiteapi.util.GherkinUtils;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/features")
public class FeatureController {

    private final FeatureService featureService;

    public FeatureController(FeatureService featureService) {
        this.featureService = featureService;
    }

    @PostMapping("")
    public ResponseEntity<String> createFeature(@Valid @RequestBody FeatureDto featureDto) {
        featureService.createFeature(featureDto);
        return ResponseEntity.ok("Feature created successfully");
    }

    @PostMapping("/validate")
    public ResponseEntity<String> validateGherkin(@RequestBody String gherkinText) {
        if (GherkinUtils.isValidGherkinSyntax(gherkinText)) {
            return ResponseEntity.ok("Valid Gherkin syntax!");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Gherkin syntax!");
        }
    }

}
