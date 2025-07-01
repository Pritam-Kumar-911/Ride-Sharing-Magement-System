package GUI;

import javax.swing.*;
import java.awt.*;

public class DriverDashboardPanel extends JPanel {

    public DriverDashboardPanel(CardLayout cardLayout, JPanel mainPanel) {
        setLayout(null);

        JLabel title = new JLabel("Driver Dashboard");
        title.setBounds(180, 40, 300, 30);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        add(title);

        JButton createRideBtn = new JButton("Create Ride");
        createRideBtn.setBounds(200, 100, 150, 40);
        createRideBtn.addActionListener(e -> {
            cardLayout.show(mainPanel, "createRide");
        });

        JButton logoutBtn = new JButton("Logout");
        logoutBtn.setBounds(200, 160, 150, 30);
        logoutBtn.addActionListener(e -> {
            cardLayout.show(mainPanel, "login");
        });

        add(createRideBtn);
        add(logoutBtn);
    }
}
