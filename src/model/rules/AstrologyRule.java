package model.rules;

public class AstrologyRule implements IRule {

    private static final String[] signs = {
            "Wassermann", "Fische", "Widder", "Stier", "Zwillinge", "Krebs",
            "Löwe", "Jungfrau", "Waage", "Skorpion", "Schütze", "Steinbock"
    };

    public AstrologyRule() {
    }

    @Override
    public String requirement() {
        return "Dein Passwort muss ein Sternzeichen enthalten";
    }

    @Override
    public String shortRequirement() {
        return "Enthält ein Sternzeichen";
    }

    @Override
    public boolean validate(String password) {
        for (String sign : signs) {
            if (password.contains(sign)) {
                return true;
            }
        }
        return false;
    }
}
