package GUI;

import models.Driver;
import models.Rider;
import utils.DatabaseManager;

import javax.swing.*;
import java.awt.*;

public class RegistrationPanel extends JPanel {
    private boolean isDriver;

    public RegistrationPanel(CardLayout cardLayout, JPanel mainPanel, boolean isDriver) {
        this.isDriver = isDriver;
        setLayout(null);

        JLabel title = new JLabel("Registration - " + (isDriver ? "Driver" : "Rider"));
        title.setBounds(150, 30, 300, 30);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        add(title);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(100, 80, 80, 25);
        JTextField nameField = new JTextField();
        nameField.setBounds(180, 80, 200, 25);

        JLabel contactLabel = new JLabel("Contact:");
        contactLabel.setBounds(100, 120, 80, 25);
        JTextField contactField = new JTextField();
        contactField.setBounds(180, 120, 200, 25);

        JLabel extraLabel = new JLabel(isDriver ? "Car Model:" : "Student ID:");
        extraLabel.setBounds(100, 160, 100, 25);
        JTextField extraField = new JTextField();
        extraField.setBounds(180, 160, 200, 25);

        JButton registerBtn = new JButton("Register");
        registerBtn.setBounds(180, 210, 120, 30);
        registerBtn.addActionListener(e -> {
            String name = nameField.getText().trim();
            String contact = contactField.getText().trim();
            String extra = extraField.getText().trim();

            if (utils.Validator.isEmpty(name, contact, extra)) {
                JOptionPane.showMessageDialog(mainPanel, "❌ All fields are required.");
                return;
            }

            if (!utils.Validator.isValidContact(contact)) {
                JOptionPane.showMessageDialog(mainPanel, "❌ Contact must be a valid 11-digit number starting with 03.");
                return;
            }


            if (isDriver) {
                Driver driver = new Driver(name, contact, extra);
                DatabaseManager.insertDriver(driver);
                JOptionPane.showMessageDialog(mainPanel, "✅ Driver registered.");
                cardLayout.show(mainPanel, "login");
            } else {
                Rider rider = new Rider(name, contact, extra);
                DatabaseManager.insertRider(rider);
                JOptionPane.showMessageDialog(mainPanel, "✅ Rider registered.");
                cardLayout.show(mainPanel, "login");
            }
        });

        JButton backButton = new JButton("Back");
        backButton.setBounds(320, 210, 80, 30);
        backButton.addActionListener(e -> cardLayout.show(mainPanel, "roleSelection"));

        JButton loginButton = new JButton("Login Instead");
        loginButton.setBounds(180, 260, 150, 30);
        loginButton.addActionListener(e -> cardLayout.show(mainPanel, "login"));

        add(nameLabel); add(nameField);
        add(contactLabel); add(contactField);
        add(extraLabel); add(extraField);
        add(registerBtn); add(backButton);
        add(loginButton);

    }
}

