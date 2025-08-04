package model.rules;

public class MaxLength implements IRule {
    private final int maxLength;
    private final EmojiRule emojiRule;

    public MaxLength() {
        this(42);
    }

    public MaxLength(int maxLength) {
        this.maxLength = maxLength;
        this.emojiRule = new EmojiRule();
    }

    @Override
    public String requirement() {
        return "Dein Passwort darf maximal " + maxLength + " Zeichen lang sein";
    }

    @Override
    public String shortRequirement() {
        return "Max. " + maxLength + " Zeichen";
    }

    @Override
    public boolean validate(String password) {
        int length = password.length();

        if (emojiRule.validate(password)) {
            length -= 1;
        }

        return length <= maxLength;
    }
}
