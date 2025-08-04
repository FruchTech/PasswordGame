package view.panels;

import model.rules.IRule;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.*;
import java.awt.*;
import java.util.List;

public class StatusPanel extends JScrollPane {
    private final JTextPane textPane;
    private final StyledDocument doc;
    private final Style styleCorrect;
    private final Style styleIncorrect;

    public StatusPanel() {
        textPane = new JTextPane();
        textPane.setEditable(false);
        textPane.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
        textPane.setForeground(Color.BLACK);
        textPane.setBackground(new Color(245, 245, 245));
        textPane.setBorder(new EmptyBorder(15, 15, 15, 15));

        this.setViewportView(textPane);
        this.setPreferredSize(new Dimension(320, 360));
        this.setBackground(Color.WHITE);
        this.getViewport().setBackground(Color.WHITE);

        this.setBorder(new CompoundBorder(
                new EmptyBorder(20, 0, 20, 20),
                new LineBorder(Color.LIGHT_GRAY, 1)
        ));

        doc = textPane.getStyledDocument();

        styleCorrect = textPane.addStyle("Correct", null);
        StyleConstants.setForeground(styleCorrect, new Color(44, 175, 44));

        styleIncorrect = textPane.addStyle("Incorrect", null);
        StyleConstants.setForeground(styleIncorrect, new Color(215, 70, 70));
        StyleConstants.setBold(styleIncorrect, true);
    }

    public void updateStatus(List<IRule> allRules, List<IRule> failedRules) {
        textPane.setText("");

        for (int i = 0; i < allRules.size(); i++) {
            IRule rule = allRules.get(i);
            int ruleNumber = i + 1;
            boolean failed = failedRules.contains(rule);

            String prefix = failed ? "❌ " : "✅ ";
            String line = prefix + rule.shortRequirement() + "\n";

            try {
                doc.insertString(doc.getLength(), line, failed ? styleIncorrect : styleCorrect);
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
        }
    }
}
