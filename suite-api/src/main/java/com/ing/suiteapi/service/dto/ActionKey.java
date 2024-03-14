package com.ing.suiteapi.service.dto;

public enum ActionKey {
    GIVEN("Given"),
    WHEN("When"),
    THEN("Then"),
    AND("And");

    private final String value;
    ActionKey(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
