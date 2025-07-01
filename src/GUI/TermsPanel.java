package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TermsPanel extends JPanel {

    public TermsPanel(CardLayout cardLayout, JPanel mainPanel) {
        setLayout(null);

        JLabel title = new JLabel("Terms and Conditions !");
        title.setBounds(150, 30, 300, 30);
        title.setFont(new Font("Arial", Font.BOLD, 24));

        JTextArea termsText = new JTextArea(" Please read the following terms and conditions carefully.\n\n"
                + "    1. This app is for university students only.\n"
                + "    2. You must be registered as either a Rider or Driver.\n"
                + "    3. Respect the community guidelines for safety and respect.\n"
                + "    4. Any misuse may result in a ban.\n"
                + "    4. Do not forget to carry your belongings.\n\n"
                + " By clicking 'Get Started', you agree to these terms and conditions.");
        termsText.setBounds(50, 100, 500, 200);
        termsText.setEditable(false);
        termsText.setBackground(Color.WHITE);


        JButton getStartedButton = new JButton("Get Started");
        getStartedButton.setBounds(150, 320, 150, 30);
        getStartedButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel,"roleSelection");
            }
        });

        JButton closeButton = new JButton("Close");
        closeButton.setBounds(350, 320, 100, 30);
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(mainPanel,"App Closes Successfully!");
                System.exit(0);
            }
        });

        add(title);
        add(termsText);
        add(getStartedButton);
        add(closeButton);
    }
}
