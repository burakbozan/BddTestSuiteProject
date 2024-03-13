package com.ing.suiteapi.service.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Map;

@JsonSerialize
public class ScenarioParametersDto {
    private final Long order;
    private final String name;
    private final Map<String,String> params;

    public ScenarioParametersDto(Long order, String name, Map<String, String> params) {
        this.order = order;
        this.name = name;
        this.params = params;
    }
}
