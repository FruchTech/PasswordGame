package view.panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InputPanel extends JPanel {
    private final JTextArea inputField;
    private final JButton submitButton;

    public InputPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        setBackground(Color.WHITE);

        inputField = new JTextArea(1, 20);
        inputField.setLineWrap(false);
        inputField.setWrapStyleWord(false);
        inputField.setFont(new Font(null, Font.PLAIN, 18));
        inputField.setBackground(Color.WHITE);
        inputField.setAlignmentX(Component.LEFT_ALIGNMENT);
        inputField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 45));
        inputField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        ));

        submitButton = new JButton("Überprüfen");
        submitButton.setPreferredSize(new Dimension(140, 50));
        submitButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));
        submitButton.setBackground(new Color(33, 150, 243));
        submitButton.setForeground(Color.WHITE);
        submitButton.setFocusPainted(false);
        submitButton.setFont(new Font("Dialog", Font.BOLD, 18));
        submitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        submitButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        submitButton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(30, 120, 200)),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));

        submitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent event) {
                submitButton.setBackground(new Color(66, 165, 245));
            }

            public void mouseExited(java.awt.event.MouseEvent event) {
                submitButton.setBackground(new Color(33, 150, 243));
            }
        });

        add(inputField);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(submitButton);

        InputMap inputMap = inputField.getInputMap(JComponent.WHEN_FOCUSED);
        ActionMap actionMap = inputField.getActionMap();

        inputMap.put(KeyStroke.getKeyStroke("ENTER"), "submitAction");
        actionMap.put("submitAction", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (ActionListener listener : submitButton.getActionListeners()) {
                    listener.actionPerformed(new ActionEvent(submitButton, ActionEvent.ACTION_PERFORMED, "submit"));
                }
            }
        });
    }

    public String getInput() {
        return inputField.getText();
    }

    public void setInput(String value) {
        inputField.setText(value);
        inputField.requestFocusInWindow();
        inputField.selectAll();
    }

    public void setSubmitListener(ActionListener listener) {
        submitButton.addActionListener(listener);
    }

    public void disableGame() {
        submitButton.setEnabled(false);
        inputField.setEnabled(false);
    }
}
