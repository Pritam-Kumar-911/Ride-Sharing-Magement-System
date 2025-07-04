import GUI.*;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        utils.DatabaseManager.initializeDatabase();
        JFrame frame = new JFrame("UniRide App");

        JPanel mainPanel = new JPanel();
        CardLayout cardLayout = new CardLayout();
        mainPanel.setLayout(cardLayout);

        WelcomePanel welcome = new WelcomePanel(cardLayout, mainPanel);
        TermsPanel terms = new TermsPanel(cardLayout, mainPanel);
        RoleSelectionPanel roleSelection = new RoleSelectionPanel(cardLayout,mainPanel);
        RegistrationPanel registerDriver = new RegistrationPanel(cardLayout, mainPanel, true);
        RegistrationPanel registerRider = new RegistrationPanel(cardLayout, mainPanel, false);
        LoginPanel login = new LoginPanel(cardLayout, mainPanel);
        DriverDashboardPanel driverDash = new DriverDashboardPanel(cardLayout, mainPanel);
        RiderDashboardPanel riderDash = new RiderDashboardPanel(cardLayout, mainPanel);
        CreateRidePanel createRide = new CreateRidePanel(cardLayout, mainPanel);
        BookRidePanel bookRide = new BookRidePanel(cardLayout, mainPanel);

        mainPanel.add(welcome, "welcome");
        mainPanel.add(terms, "terms");
        mainPanel.add(roleSelection , "roleSelection");
        mainPanel.add(registerDriver, "registerDriver");
        mainPanel.add(registerRider, "registerRider");
        mainPanel.add(login, "login");
        mainPanel.add(driverDash, "driverDashboard");
        mainPanel.add(riderDash, "riderDashboard");
        mainPanel.add(createRide, "createRide");
        mainPanel.add(bookRide, "bookRide");

        cardLayout.show(mainPanel, "welcome");


        frame.add(mainPanel);
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setBackground(Color.WHITE);
        frame.setResizable(false);
    }
}
