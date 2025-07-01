package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RoleSelectionPanel extends JPanel {

    public RoleSelectionPanel(CardLayout cardLayout, JPanel mainPanel) {
        setLayout(null);

        JLabel title = new JLabel("Choose Your Role");
        title.setBounds(150, 80, 300, 30);
        title.setFont(new Font("Arial", Font.BOLD, 32));

        JLabel description = new JLabel("\n\n\nSelect whether you want to ride or offer rides as a driver.");
        description.setBounds(100, 150, 400, 25);
        description.setFont(new Font("Arial", Font.PLAIN, 14));

        JButton riderButton = new JButton("Rider");
        riderButton.setBounds(150, 200, 120, 40);
        riderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "registerRider");
            }
        });

        JButton driverButton = new JButton("Driver");
        driverButton.setBounds(300, 200, 120, 40);
        driverButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "registerDriver");
            }
        });

        add(title);
        add(riderButton);
        add(driverButton);
        add(description);
    }
}
