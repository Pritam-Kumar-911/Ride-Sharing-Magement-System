package GUI;

import utils.DatabaseManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class BookRidePanel extends JPanel {
    private DefaultListModel<String> rideListModel = new DefaultListModel<>();
    private JList<String> rideList;

    public BookRidePanel(CardLayout cardLayout, JPanel mainPanel) {
        setLayout(null);

        JLabel title = new JLabel("Available Rides");
        title.setBounds(180, 20, 300, 30);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        add(title);

        rideList = new JList<>(rideListModel);
        JScrollPane scrollPane = new JScrollPane(rideList);
        scrollPane.setBounds(70, 70, 450, 150);
        add(scrollPane);

        JButton refreshBtn = new JButton("Refresh");
        refreshBtn.setBounds(100, 240, 100, 30);
        refreshBtn.addActionListener(e -> loadRides());
        add(refreshBtn);

        JButton acceptBtn = new JButton("Accept Ride");
        acceptBtn.setBounds(230, 240, 150, 30);
        acceptBtn.addActionListener(e -> {
            String selected = rideList.getSelectedValue();
            if (selected != null) {
                try {
                    int rideId = Integer.parseInt(selected.split(",")[0].split(":")[1].trim());

                    utils.DatabaseManager.bookRideById(rideId);

                    JOptionPane.showMessageDialog(mainPanel, "✅ Ride Accepted Successfully!");
                    loadRides();  // Refresh list
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(mainPanel, "❌ Failed to accept ride.");
                }
            } else {
                JOptionPane.showMessageDialog(mainPanel, "❌ Please select a ride.");
            }
        });


        JButton backBtn = new JButton("Back");
        backBtn.setBounds(400, 240, 100, 30);
        backBtn.addActionListener(e -> cardLayout.show(mainPanel, "riderDashboard"));
        add(backBtn);

        // Refresh every 3 seconds
        Timer timer = new Timer(3000, e -> loadRides());
        timer.start();

        loadRides();
        add(scrollPane);
        add(refreshBtn);
        add(acceptBtn);
        add(backBtn);
    }

    private void loadRides() {
        rideListModel.clear();
        try {
            ResultSet rs = DatabaseManager.getAvailableRides();
            while (rs != null && rs.next()) {
                String line = "ID: " + rs.getInt("id") + ", From: " + rs.getString("fromPlace") +
                        ", To: " + rs.getString("toPlace") + ", Time: " + rs.getString("time") +
                        ", Seats: " + rs.getInt("seats") + ", Driver: " + rs.getString("driverName");
                rideListModel.addElement(line);
            }
        } catch (Exception e) {
            rideListModel.addElement("Error loading rides.");
        }
    }
}
