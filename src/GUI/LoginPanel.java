package GUI;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel {

    public LoginPanel(CardLayout cardLayout, JPanel mainPanel) {
        setLayout(null);

        JLabel title = new JLabel("Login");
        title.setBounds(200, 30, 200, 30);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        add(title);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(100, 90, 100, 25);
        JTextField nameField = new JTextField();
        nameField.setBounds(180, 90, 200, 25);
        add(nameLabel);
        add(nameField);

        JLabel contactLabel = new JLabel("Contact:");
        contactLabel.setBounds(100, 130, 100, 25);
        JTextField contactField = new JTextField();
        contactField.setBounds(180, 130, 200, 25);
        add(contactLabel);
        add(contactField);

        JLabel roleLabel = new JLabel("Role:");
        roleLabel.setBounds(100, 170, 100, 25);
        String[] roles = {"Driver", "Rider"};
        JComboBox<String> roleBox = new JComboBox<>(roles);
        roleBox.setBounds(180, 170, 200, 25);
        add(roleLabel);
        add(roleBox);

        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(180, 220, 100, 30);
        loginBtn.addActionListener(e -> {
            String name = nameField.getText().trim();
            String contact = contactField.getText().trim();
            String role = (String) roleBox.getSelectedItem();

            boolean found = Utils.DatabaseManager.isUserValid(name, contact, role);

            if (found) {
                JOptionPane.showMessageDialog(mainPanel, "✅ Login successful as " + role);
                if (role.equals("Driver")) {
                    cardLayout.show(mainPanel, "driverDashboard");
                } else {
                    cardLayout.show(mainPanel, "riderDashboard");
                }
            } else {
                JOptionPane.showMessageDialog(mainPanel, "❌ Invalid name or contact for " + role);
            }
        });


        JButton backBtn = new JButton("Back");
        backBtn.setBounds(300, 220, 80, 30);
        backBtn.addActionListener(e -> cardLayout.show(mainPanel, "roleSelection"));

        add(loginBtn);
        add(backBtn);
    }
}
