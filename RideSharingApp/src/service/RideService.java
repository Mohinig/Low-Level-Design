package service;

import model.*;
import strategy.*;

import java.util.*;

public class RideService {
    private final Map<String, User> users = new HashMap<>();
    private final Map<String, Vehicle> vehicles = new HashMap<>();
    private final List<Ride> rides = new ArrayList<>();

    public void addUser(String name, String gender, int age) {
        users.putIfAbsent(name, new User(name, gender, age));
    }

    public void addVehicle(String userName, String model, String number) {
        User user = users.get(userName);
        if (user != null) {
            Vehicle vehicle = new Vehicle(user, model, number);
            user.addVehicle(vehicle);
            vehicles.put(number, vehicle);
        }
    }

    public boolean offerRide(String userName, String origin, String destination, int seats, String vehicleNumber) {
        User user = users.get(userName);
        Vehicle vehicle = vehicles.get(vehicleNumber);

        if (user == null || vehicle == null) return false;

        for (Ride ride : rides) {
            if (ride.getVehicle().equals(vehicle) && ride.isActive()) {
                System.out.println("Cannot offer ride: Active ride already exists for vehicle " + vehicleNumber);
                return false;
            }
        }

        Ride ride = new Ride(user, vehicle, origin, destination, seats);
        rides.add(ride);
        return true;
    }

    public void selectRide(String userName, String origin, String destination, int seats, RideSelectionStrategy strategy) {
        User user = users.get(userName);
        if (user == null) return;

        List<Ride> candidates = new ArrayList<>();
        for (Ride ride : rides) {
            if (ride.isActive() &&
                    ride.getOrigin().equalsIgnoreCase(origin) &&
                    ride.getDestination().equalsIgnoreCase(destination) &&
                    ride.getAvailableSeats() >= seats) {
                candidates.add(ride);
            }
        }

        Ride selectedRide = strategy.selectRide(candidates);
        if (selectedRide != null && selectedRide.bookSeats(seats)) {
            user.incrementTaken();
            selectedRide.getOwner().incrementOffered();
            System.out.println(userName + " selected ride with " + selectedRide.getVehicle().getModel());
        } else {
            System.out.println("No suitable ride found for " + userName);
        }
    }

    public void endRide(String vehicleNumber) {
        for (Ride ride : rides) {
            if (ride.getVehicle().getNumber().equals(vehicleNumber) && ride.isActive()) {
                ride.endRide();
                break;
            }
        }
    }

    public void printRideStats() {
        for (User user : users.values()) {
            System.out.println(user.getName() + ": " +
                    user.getRidesTaken() + " Taken, " +
                    user.getRidesOffered() + " Offered");
        }
    }
}
