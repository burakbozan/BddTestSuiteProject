package com.ing.suiteapi.service.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class ScenarioStepsDto {
    private final Long order;
    private final ActionKey actionKey;
    private final String actionWord;

    public ScenarioStepsDto(Long order, ActionKey actionKey, String actionWord) {
        this.order = order;
        this.actionKey = actionKey;
        this.actionWord = actionWord;
    }

    public Long getOrder() {
        return order;
    }

    public ActionKey getActionKey() {
        return actionKey;
    }

    public String getActionWord() {
        return actionWord;
    }
}
