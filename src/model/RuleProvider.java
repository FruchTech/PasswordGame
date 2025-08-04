package model;

import model.rules.*;

import java.util.List;

public class RuleProvider {

    public static List<IRule> getRules() {
        return List.of(
                new LengthRule(),
                new NumberRule(),
                new UppercaseRule(),
                new SpecialCharacterRule(),
                new LeapYearRule(),

                new RomanYearRule(),
                new VocaleRule(),
                new AtosCEORule(),
                new EmojiRule(),
                new MaxNumberRule(),

                new ChemFormulaRule(),
                new AstrologyRule(),
                new MathRule(),
                new UsbekWinnerRule(),
                new MaxLength()
        );
    }

}
