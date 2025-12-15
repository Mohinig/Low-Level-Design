package model;

public class Ride {
    private final User owner;
    private final Vehicle vehicle;
    private final String origin;
    private final String destination;
    private int availableSeats;
    private boolean isActive;

    public Ride(User owner, Vehicle vehicle, String origin, String destination, int availableSeats) {
        this.owner = owner;
        this.vehicle = vehicle;
        this.origin = origin;
        this.destination = destination;
        this.availableSeats = availableSeats;
        this.isActive = true;
    }

    public boolean bookSeats(int seats) {
        if (seats <= availableSeats) {
            availableSeats -= seats;
            return true;
        }
        return false;
    }

    public void endRide() {
        isActive = false;
    }

    public boolean isActive() {
        return isActive;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public User getOwner() {
        return owner;
    }
}
