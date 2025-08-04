package model.rules;

public class ChemFormulaRule implements IRule {
    private final String fullNameFormula;
    private final String formula;

    public ChemFormulaRule() {
        this("Glukose", "C6H12O6");
    }

    public ChemFormulaRule(String fullNameFormula, String formula) {
        this.fullNameFormula = fullNameFormula;
        this.formula = formula;
    }

    @Override
    public String requirement() {
        return "Dein Passwort muss die chem. Formel von " + fullNameFormula + " enthalten";
    }

    @Override
    public String shortRequirement() {
        return "Enthält Formel von " + fullNameFormula;

    }

    @Override
    public boolean validate(String password) {
        return password.contains(formula);
    }
}
