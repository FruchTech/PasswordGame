package model.rules;

public class VocaleRule implements IRule {

    public VocaleRule() {

    }

    @Override
    public String requirement() {
        return "Dein Passwort muss alle Vokale ('A', 'E', 'I', 'O', 'U') enthalten";
    }

    @Override
    public String shortRequirement() {
        return "Enthält alle Vokale";
    }

    @Override
    public boolean validate(String password) {
        String pwUpper = password.toUpperCase();
        return pwUpper.contains("A") && pwUpper.contains("E") && pwUpper.contains("I") && pwUpper.contains("O") && pwUpper.contains("U");
    }
}
