
package GUI;

import Models.Ride;
import Utils.DatabaseManager;

import javax.swing.*;
import java.awt.*;

public class CreateRidePanel extends JPanel {

    public CreateRidePanel(CardLayout cardLayout, JPanel mainPanel) {
        setLayout(null);

        JLabel title = new JLabel("Create a New Ride");
        title.setBounds(180, 20, 300, 30);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        add(title);

        JLabel fromLabel = new JLabel("From:");
        fromLabel.setBounds(100, 70, 80, 25);
        JTextField fromField = new JTextField();
        fromField.setBounds(180, 70, 200, 25);

        JLabel toLabel = new JLabel("To:");
        toLabel.setBounds(100, 110, 80, 25);
        JTextField toField = new JTextField();
        toField.setBounds(180, 110, 200, 25);

        JLabel timeLabel = new JLabel("Time:");
        timeLabel.setBounds(100, 150, 80, 25);
        JTextField timeField = new JTextField();
        timeField.setBounds(180, 150, 200, 25);

        JLabel seatsLabel = new JLabel("Seats:");
        seatsLabel.setBounds(100, 190, 80, 25);
        JTextField seatsField = new JTextField();
        seatsField.setBounds(180, 190, 200, 25);

        JLabel driverLabel = new JLabel("Driver Name:");
        driverLabel.setBounds(100, 230, 100, 25);
        JTextField driverField = new JTextField();
        driverField.setBounds(180, 230, 200, 25);

        JButton postBtn = new JButton("Post Ride");
        postBtn.setBounds(180, 280, 120, 30);
        postBtn.addActionListener(e -> {
            try {
                Ride ride = new Ride(0,
                        fromField.getText(),
                        toField.getText(),
                        timeField.getText(),
                        Integer.parseInt(seatsField.getText()),
                        driverField.getText(),
                        "Available"
                );
                DatabaseManager.insertRide(ride);
                JOptionPane.showMessageDialog(mainPanel, "✅ Ride Posted!");
                fromField.setText(""); toField.setText(""); timeField.setText("");
                seatsField.setText(""); driverField.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(mainPanel, "❌ Please check input fields.");
            }
        });

        JButton backBtn = new JButton("Back");
        backBtn.setBounds(320, 280, 80, 30);
        backBtn.addActionListener(e -> cardLayout.show(mainPanel, "driverDashboard"));

        add(fromLabel); add(fromField);
        add(toLabel); add(toField);
        add(timeLabel); add(timeField);
        add(seatsLabel); add(seatsField);
        add(driverLabel); add(driverField);
        add(postBtn); add(backBtn);
    }
}
