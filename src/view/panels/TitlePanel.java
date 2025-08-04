package view.panels;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class TitlePanel extends JLabel {
    public TitlePanel() {
        super("Aktuelle Regel");
        this.setFont(new Font("Dialog", Font.BOLD, 22));
        this.setOpaque(true);
        this.setBackground(new Color(200, 230, 255));
        this.setBorder(new EmptyBorder(10, 15, 10, 15));
    }

    public void updateText(String text) {
        this.setText(text);
    }
}
