package com.ing.suiteapi.service.dto;

import com.ing.suiteapi.validator.ValidGherkinSyntax;

public record FeatureDto(String title, String description, String author, @ValidGherkinSyntax String text) {}

