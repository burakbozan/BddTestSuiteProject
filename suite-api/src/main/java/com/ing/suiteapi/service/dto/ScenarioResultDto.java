package com.ing.suiteapi.service.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class ScenarioResultDto {
    private final Boolean isSuccess;
    private final String htmlText;

    public ScenarioResultDto(Boolean isSuccess, String htmlText) {
        this.isSuccess = isSuccess;
        this.htmlText = htmlText;
    }
}
