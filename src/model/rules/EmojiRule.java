package model.rules;

import java.util.Arrays;
import java.util.List;

public class EmojiRule implements IRule {

    private final List<String> emojiList;

    public EmojiRule() {
        this(Arrays.asList(
                "\uD83D\uDE00", // 😀 – Grinsend
                "\uD83D\uDE01", // 😁 – Lächelnd mit großen Augen
                "\uD83D\uDE02", // 😂 – Lachend mit Tränen
                "\uD83D\uDE0D", // 😍 – Verliebt
                "\uD83D\uDE14", // 😔 – Nachdenklich
                "\uD83D\uDE22", // 😢 – Traurig
                "\uD83D\uDE2D", // 😭 – Weinend
                "\uD83D\uDE21", // 😡 – Wütend
                "\uD83D\uDE0F", // 😏 – Verschmitzt
                "\uD83E\uDD14", // 🤔 – Nachdenklich
                "\uD83D\uDE33", // 😳 – Verlegen
                "\uD83D\uDE0E", // 😎 – Cool
                "\uD83E\uDD72", // 🥲 – Erleichtert/traurig zugleich
                "\uD83E\uDD23", // 🤣 – Lachkrampf
                "\uD83D\uDE07", // 😇 – Unschuldig
                "\uD83E\uDD70", // 🥰 – Verliebt mit Herzchen
                "\uD83E\uDEE1", // 🫡 – Salutieren (Stolz / Respekt)
                "\uD83E\uDD79"  // 🥹 – Rührselig
        ));
    }

    public EmojiRule(List<String> emojis) {
        this.emojiList = emojis;
    }

    @Override
    public String requirement() {
        return "Dein Passwort muss deine aktuelle Gefühlslage als Emoji \uD83D\uDE00 enthalten";
    }

    @Override
    public String shortRequirement() {
        return "Deine Gefühlslage als Emoji";
    }

    @Override
    public boolean validate(String password) {
        for (String emoji : emojiList) {
            if (password.contains(emoji)) {
                return true;
            }
        }
        return false;
    }
}
