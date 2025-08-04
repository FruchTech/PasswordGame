package view;

import view.panels.MainPanel;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class MainFrame extends JFrame {
    private final MainPanel mainPanel;

    public MainFrame() {
        super.setTitle("The PasswordGame");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(980, 540);

        mainPanel = new MainPanel();
        this.add(mainPanel);

        this.loadIcon();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public MainPanel getMainPanel() {
        return mainPanel;
    }

    private void loadIcon() {
        try {
            URL iconURL = getClass().getResource("assets/icon.png");
            if (iconURL != null) {
                Image icon = ImageIO.read(iconURL);
                this.setIconImage(icon);
            } else {
                System.err.println("Icon nicht gefunden!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
