package view;

import model.rules.IRule;

public class Messages {

    public String getWelcomeMessage() {
        return "Neues PasswordGame starten?";
    }

    public String getRuleMessage(int ruleNumber, IRule rule) {
        return "Level " + ruleNumber + ": " + rule.requirement();
    }

    public String getWrongPasswordMessage() {
        return "Es wurden nicht alle Anforderungen erfüllt!";
    }

    public String getWinMessage() {
        return "Glückwunsch! Das Passwort erfüllt nun alle Anforderungen!";
    }
}
