package controller;

import model.Password;
import model.rules.IRule;
import model.RuleProvider;
import view.MainFrame;
import view.panels.MainPanel;

import java.util.List;

public class PasswordGame implements MainPanel.InputListener {
    private static PasswordGame INSTANCE;
    private final MainPanel view;
    private int stepNumber;
    private Password password;
    private List<IRule> rules;

    public static synchronized PasswordGame getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PasswordGame();
        }
        return INSTANCE;
    }

    private PasswordGame() {
        MainFrame frame = new MainFrame();
        view = frame.getMainPanel();
        view.setInputListener(this);
    }

    public void startNewGame() {
        password = new Password();
        rules = RuleProvider.getRules();
        stepNumber = 1;
        startStep();
    }

    private void startStep() {
        if (stepNumber > rules.size()) {
            view.printSuccess();
            view.disableGame();
            return;
        }

        IRule currentRule = rules.get(stepNumber - 1);
        view.printRuleDescription(stepNumber, currentRule, password.getValue());
    }

    @Override
    public void onInputSubmitted(String input) {
        password.setValue(input);

        List<IRule> rulesToCheck = rules.subList(0, stepNumber);
        List<IRule> failedRules = rulesToCheck.stream()
                .filter(r -> !r.validate(password.getValue()))
                .toList();

        view.printRuleStatus(rulesToCheck, failedRules);

        if (failedRules.isEmpty()) {
            stepNumber++;
            startStep();
        }
    }
}
