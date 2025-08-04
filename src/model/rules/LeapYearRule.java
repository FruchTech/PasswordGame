package model.rules;

public class LeapYearRule implements IRule {
    public LeapYearRule() {
    }

    @Override
    public String requirement() {
        return "Dein Passwort muss ein Schaltjahr enthalten";
    }

    @Override
    public String shortRequirement() {
        return "Enthält ein Schaltjahr";
    }

    @Override
    public boolean validate(String password) {
        java.util.regex.Matcher matcher = java.util.regex.Pattern.compile("\\d+").matcher(password);

        while (matcher.find()) {
            String numberStr = matcher.group();
            try {
                int year = Integer.parseInt(numberStr);
                if (isLeapYear(year)) {
                    return true;
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
