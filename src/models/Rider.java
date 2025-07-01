package models;

public class Rider extends Models.User {
    private String studentId;

    public Rider(String name, String contact, String studentId) {
        super(name, contact);
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public String getRole() {
        return "Rider";
    }

    @Override
    public String getInfo() {
        return super.getInfo() + " | Student ID: " + studentId;
    }
}

