package model;

public class Vehicle {
    private final User owner;
    private final String model;
    private final String number;

    public Vehicle(User owner, String model, String number) {
        this.owner = owner;
        this.model = model;
        this.number = number;
    }

    public User getOwner() {
        return owner;
    }

    public String getModel() {
        return model;
    }

    public String getNumber() {
        return number;
    }
}
