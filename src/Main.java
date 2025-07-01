import GUI.WelcomePanel;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("UniRide App");

        JPanel mainPanel = new JPanel();
        CardLayout cardLayout = new CardLayout();
        mainPanel.setLayout(cardLayout);

        WelcomePanel welcome = new WelcomePanel(cardLayout, mainPanel);

        mainPanel.add(welcome, "welcome");




        frame.add(mainPanel);
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setBackground(Color.WHITE);
        frame.setResizable(false);
    }
}
