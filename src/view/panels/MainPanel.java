package view.panels;

import model.rules.IRule;
import view.Messages;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainPanel extends JPanel {
    private final TitlePanel ruleLabelPanel;
    private final InputPanel inputPanel;
    private final StatusPanel statusPanel;
    private final Messages messages = new Messages();

    private InputListener inputListener;

    public MainPanel() {
        this.setLayout(new BorderLayout());

        ruleLabelPanel = new TitlePanel();
        inputPanel = new InputPanel();
        statusPanel = new StatusPanel();

        this.add(ruleLabelPanel, BorderLayout.NORTH);
        this.add(inputPanel, BorderLayout.CENTER);
        this.add(statusPanel, BorderLayout.EAST);

        inputPanel.setSubmitListener(e -> {
            if (inputListener != null) {
                inputListener.onInputSubmitted(inputPanel.getInput());
            }
        });

        printWelcomeMessage();
    }

    public void printWelcomeMessage() {
        JOptionPane.showMessageDialog(this, messages.getWelcomeMessage(), "Willkommen", JOptionPane.INFORMATION_MESSAGE);
    }

    public void printRuleDescription(int ruleNumber, IRule rule, String currentPassword) {
        ruleLabelPanel.updateText(messages.getRuleMessage(ruleNumber, rule));
        inputPanel.setInput(currentPassword);
    }

    public void printRuleStatus(List<IRule> allRules, List<IRule> failedRules) {
        statusPanel.updateStatus(allRules, failedRules);
    }

    public void printSuccess() {
        JOptionPane.showMessageDialog(this, messages.getWinMessage(), "Spiel beendet", JOptionPane.INFORMATION_MESSAGE);
    }

    public void setInputListener(InputListener listener) {
        this.inputListener = listener;
    }

    public void disableGame() {
        inputPanel.disableGame();
    }

    public interface InputListener {
        void onInputSubmitted(String input);
    }
}

