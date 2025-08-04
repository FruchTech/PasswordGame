package model.rules;

public class LengthRule implements IRule {
    private final int minLength;

    public LengthRule() {
        this(8);
    }

    public LengthRule(int minLength) {
        this.minLength = minLength;
    }

    @Override
    public String requirement() {
        return "Dein Passwort muss mindestens " + minLength + " Zeichen lang sein";
    }

    @Override
    public String shortRequirement() {
        return "Min. " + minLength + " Zeichen";
    }

    @Override
    public boolean validate(String password) {
        return password.length() >= minLength;
    }

}
