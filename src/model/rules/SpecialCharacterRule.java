package model.rules;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpecialCharacterRule implements IRule {
    private final int minSpecialCharacter;

    public SpecialCharacterRule() {
        this(3);
    }

    public SpecialCharacterRule(int minSpecialCharacter) {
        this.minSpecialCharacter = minSpecialCharacter;
    }

    @Override
    public String requirement() {
        return "Dein Passwort muss mindestens " + minSpecialCharacter + " verschiedene Sonderzeichen enthalten";
    }

    @Override
    public String shortRequirement() {
        return "Min. " + minSpecialCharacter + " versch. Sonderzeichen";
    }

    @Override
    public boolean validate(String password) {
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");
        Matcher matcher = pattern.matcher(password);

        Set<Character> verschiedeneSonderzeichen = new HashSet<>();

        while (matcher.find()) {
            verschiedeneSonderzeichen.add(matcher.group().charAt(0));
            if (verschiedeneSonderzeichen.size() >= minSpecialCharacter) {
                return true;
            }
        }
        return false;
    }

}
