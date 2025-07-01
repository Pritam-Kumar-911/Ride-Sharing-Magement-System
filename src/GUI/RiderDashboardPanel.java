
package GUI;

import javax.swing.*;
import java.awt.*;

public class RiderDashboardPanel extends JPanel {

    public RiderDashboardPanel(CardLayout cardLayout, JPanel mainPanel) {
        setLayout(null);

        JLabel title = new JLabel("Rider Dashboard");
        title.setBounds(180, 40, 300, 30);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        add(title);

        JButton bookRideBtn = new JButton("Book Ride");
        bookRideBtn.setBounds(200, 100, 150, 40);
        bookRideBtn.addActionListener(e -> {
            cardLayout.show(mainPanel, "bookRide");
        });

        JButton logoutBtn = new JButton("Logout");
        logoutBtn.setBounds(200, 160, 150, 30);
        logoutBtn.addActionListener(e -> {
            cardLayout.show(mainPanel, "login");
        });

        add(bookRideBtn);
        add(logoutBtn);
    }
}
