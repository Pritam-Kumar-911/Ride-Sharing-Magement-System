package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WelcomePanel extends JPanel {

    public WelcomePanel(CardLayout cardLayout, JPanel mainPanel) {
        setLayout(null);

        JLabel title = new JLabel("Welcome to UniRide!");
        title.setBounds(150, 50, 300, 30);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        Font titleFont = new Font("Arial", Font.BOLD, 28);
        title.setFont(titleFont);


        JTextArea description = new JTextArea("\n       UniRide is a Java Swing-based ride-sharing app designed for university students.\n" +
                "       It allows Riders and Drivers to register, offer or book rides, and manage data easily.\n" +
                "       Built with OOP principles with Database integration, it's a practical, campus-focused \n" +
                "       solution.\n ");
        description.setBounds(50, 100, 500, 100);
        description.setEditable(false);
        description.setBackground(Color.WHITE);


        JButton proceedButton = new JButton("Proceed");
        proceedButton.setBounds(200, 270, 170, 30);
        proceedButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "terms");
            }
        });

        add(title);
        add(description);
        add(proceedButton);
    }
}
