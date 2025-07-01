package utils;

import models.Driver;
import models.Rider;
import models.Ride;

import java.sql.*;

public class DatabaseManager {
    private static final String DB_URL = "jdbc:sqlite:carpool.db";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    public static void initializeDatabase() {
        String createUsers = "CREATE TABLE IF NOT EXISTS users (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT NOT NULL," +
                "contact TEXT NOT NULL," +
                "role TEXT NOT NULL," +
                "extra TEXT" + // carModel or studentId
                ");";

        String createRides = "CREATE TABLE IF NOT EXISTS rides (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "fromPlace TEXT," +
                "toPlace TEXT," +
                "time TEXT," +
                "seats INTEGER," +
                "driverName TEXT," +
                "status TEXT" +
                ");";

        try (Connection conn = connect(); Statement stmt = conn.createStatement()) {
            stmt.execute(createUsers);
            stmt.execute(createRides);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertDriver(Driver d) {
        String sql = "INSERT INTO users (name, contact, role, extra) VALUES (?, ?, 'Driver', ?)";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, d.getName());
            stmt.setString(2, d.getContact());
            stmt.setString(3, d.getCarModel());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertRider(Rider r) {
        String sql = "INSERT INTO users (name, contact, role, extra) VALUES (?, ?, 'Rider', ?)";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, r.getName());
            stmt.setString(2, r.getContact());
            stmt.setString(3, r.getStudentId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertRide(Ride ride) {
        String sql = "INSERT INTO rides (fromPlace, toPlace, time, seats, driverName, status) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, ride.getFrom());
            stmt.setString(2, ride.getTo());
            stmt.setString(3, ride.getTime());
            stmt.setInt(4, ride.getSeats());
            stmt.setString(5, ride.getDriverName());
            stmt.setString(6, ride.getStatus());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet getAvailableRides() {
        String sql = "SELECT * FROM rides WHERE status = 'Available'";
        try {
            Connection conn = connect();
            return conn.createStatement().executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static boolean isUserValid(String name, String contact, String role) {
        String sql = "SELECT * FROM users WHERE name = ? AND contact = ? AND role = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, contact);
            stmt.setString(3, role);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); // returns true if a record is found
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    // Mark ride as booked using its ID
    public static void bookRideById(int rideId) {
        String sql = "UPDATE rides SET status = 'Booked' WHERE id = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, rideId);
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

