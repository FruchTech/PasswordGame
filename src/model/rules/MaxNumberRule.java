package model.rules;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MaxNumberRule implements IRule {
    private final int maxNmber;

    public MaxNumberRule() {
        this(42);
    }

    public MaxNumberRule(int maxNmber) {
        this.maxNmber = maxNmber;
    }

    @Override
    public String requirement() {
        return "Die (arabischen) Zahlen in deinem Passwort müssen addiert " + maxNmber + " ergeben";
    }

    @Override
    public String shortRequirement() {
        return "Zahlen ergeben addiert " + maxNmber;
    }

    @Override
    public boolean validate(String password) {
        int sum = 0;

        Matcher matcher = Pattern.compile("\\d").matcher(password);
        while (matcher.find()) {
            sum += Integer.parseInt(matcher.group());
        }

        return sum == maxNmber;
    }
}
