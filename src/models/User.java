package Models;

public abstract class User {
    private String name;
    private String contact;

    public User(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }

    public abstract String getRole();


    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getInfo() {
        return name + " | " + contact;
    }
}

