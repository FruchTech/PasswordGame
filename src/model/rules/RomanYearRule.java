package model.rules;

public class RomanYearRule implements IRule {

    public RomanYearRule() {
    }

    @Override
    public String requirement() {
        return "Dein Passwort muss das aktuelle Jahr in römischen Ziffern enthalten";
    }

    @Override
    public String shortRequirement() {
        return "Jahr in Römischen Ziffern";
    }

    @Override
    public boolean validate(String password) {
        int currentYear = java.time.Year.now().getValue();
        String romanYear = toRoman(currentYear);
        return password.toUpperCase().contains(romanYear);
    }

    private String toRoman(int number) {
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (number >= values[i]) {
                number -= values[i];
                result.append(romans[i]);
            }
        }

        return result.toString();
    }

}
