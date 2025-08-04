package model.rules;

public class UsbekWinnerRule implements IRule {
    private final String[] leagueWinners;

    public UsbekWinnerRule() {
        this(new String[]{
                "Nasaf", "Pakhtakor", "Lokomotiv", "Bunyodkor",
                "Dustlik", "Neftchi", "MHKS", "Navbahor"
        });
    }

    public UsbekWinnerRule(String[] leagueWinners) {
        this.leagueWinners = leagueWinners;
    }

    @Override
    public String requirement() {
        return "Dein Passwort muss einen Gewinner der Usbekistan Super League enthalten";
    }

    @Override
    public String shortRequirement() {
        return "Usbekistan League Gewinner";
    }

    @Override
    public boolean validate(String password) {
        String lowerPassword = password.toLowerCase();

        for (String s : leagueWinners) {
            if (lowerPassword.contains(s.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}
