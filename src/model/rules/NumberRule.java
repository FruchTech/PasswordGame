package model.rules;

public class NumberRule implements IRule {
    private final int minNumbers;

    public NumberRule() {
        this(3);
    }

    public NumberRule(int minNumbers) {
        this.minNumbers = minNumbers;
    }

    @Override
    public String requirement() {
        return "Dein Passwort muss mindestens " + minNumbers + " Zahlen enthalten";
    }

    @Override
    public String shortRequirement() {
        return "Min. " + minNumbers + " Zahlen";
    }

    @Override
    public boolean validate(String password) {
        return password.replaceAll("\\D", "").length() >= minNumbers;
    }

}
