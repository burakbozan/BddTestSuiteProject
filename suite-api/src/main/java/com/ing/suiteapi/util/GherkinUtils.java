package com.ing.suiteapi.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GherkinUtils {

    private static final String GHERKIN_PATTERN = "(Feature|Scenario(?: Outline)?|Given|When|Then|And|But):.*";

    private GherkinUtils() { }

    public static boolean isValidGherkinSyntax(String text) {
        Pattern pattern = Pattern.compile(GHERKIN_PATTERN, Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(text);
        return matcher.matches();
    }

    public static int countScenarios(String text) {
        Pattern pattern = Pattern.compile("Scenario(?: Outline)?:", Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(text);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    public static List<String> extractScenarioTitles(String text) {
        List<String> titles = new ArrayList<>();
        Pattern pattern = Pattern.compile("Scenario(?: Outline)?:\\s+(.+)", Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            titles.add(matcher.group(1));
        }
        return titles;
    }

}
