package models;

public class Ride {
    private int id;
    private String from;
    private String to;
    private String time;
    private int seats;
    private String driverName;
    private String status;  // e.g., "Available", "Booked"

    public Ride(int id, String from, String to, String time, int seats, String driverName, String status) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.time = time;
        this.seats = seats;
        this.driverName = driverName;
        this.status = status;
    }

    public int getId() {
        return id; }
    public String getFrom() {
        return from; }
    public String getTo() {
        return to; }
    public String getTime() {
        return time; }
    public int getSeats() {
        return seats; }
    public String getDriverName() {
        return driverName; }
    public String getStatus() {
        return status; }

    public void setSeats(int seats) {
        this.seats = seats; }
    public void setStatus(String status) {
        this.status = status; }

    @Override
    public String toString() {
        return "Ride ID: " + id + ", From: " + from + ", To: " + to + ", Time: " + time + ", Seats: " + seats + ", Driver: " + driverName + ", Status: " + status;
    }
}

