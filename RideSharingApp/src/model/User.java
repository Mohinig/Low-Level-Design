package model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final String name;
    private final String gender;
    private final int age;
    private final List<Vehicle> vehicles;
    private int ridesTaken = 0;
    private int ridesOffered = 0;

    public User(String name, String gender, int age) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public String getName() { return name; }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void incrementTaken() {
        ridesTaken++;
    }

    public void incrementOffered() {
        ridesOffered++;
    }

    public int getRidesTaken() {
        return ridesTaken;
    }

    public int getRidesOffered() {
        return ridesOffered;
    }
}
