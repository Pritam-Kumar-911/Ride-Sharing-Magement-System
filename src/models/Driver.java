package models;

public class Driver extends User {
    private String carModel;

    public Driver(String name, String contact, String carModel) {
        super(name, contact);
        this.carModel = carModel;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    @Override
    public String getRole() {
        return "Driver";
    }

    @Override
    public String getInfo() {
        return super.getInfo() + " | Car: " + carModel;
    }
}

