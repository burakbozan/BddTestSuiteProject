package com.ing.suiteapi.service.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class ScenarioStepsDto {
    private final Long order;
    private final ActionKey actionKey;
    private final String actionWorld;

    public ScenarioStepsDto(Long order, ActionKey actionKey, String actionWorld) {
        this.order = order;
        this.actionKey = actionKey;
        this.actionWorld = actionWorld;
    }
}
