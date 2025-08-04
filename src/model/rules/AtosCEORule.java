package model.rules;

public class AtosCEORule implements IRule {
    private final String[] ceoList;

    public AtosCEORule() {
        this(new String[]{"mustier", "saleh", "bernaert", "bihmane", "girard"});
    }

    public AtosCEORule(String[] ceoList) {
        this.ceoList = ceoList;
    }

    @Override
    public String requirement() {
        return "Dein Passwort muss den Nachnamen eines ehem. Atos CEOs enthalten";
    }

    @Override
    public String shortRequirement() {
        return "Nachname Atos CEO";
    }

    @Override
    public boolean validate(String password) {
        for (String s : ceoList) {
            if (password.toLowerCase().contains(s)) {
                return true;
            }
        }

        return false;
    }

}
