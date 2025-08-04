package model.rules;

public class UppercaseRule implements IRule {
    private final int minUppercase;

    public UppercaseRule() {
        this(3);
    }

    public UppercaseRule(int minUppercase) {
        this.minUppercase = minUppercase;
    }

    @Override
    public String requirement() {
        return "Dein Passwort muss mindestens " + minUppercase + " Großbuchstaben enthalten";
    }

    @Override
    public String shortRequirement() {
        return "Min. " + minUppercase + " Großbuchstaben";
    }

    @Override
    public boolean validate(String password) {
        return password.chars().filter(Character::isUpperCase).count() >= 3;
    }

}
