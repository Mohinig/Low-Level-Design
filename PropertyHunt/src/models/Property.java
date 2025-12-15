package models;

import enums.ListingType;
import enums.PropertyStatus;

import java.util.List;

public class Property {
    private static int idCounter = 1;

    private int id;
    private String title;
    private String location;
    private int price;
    private double size;
    private String rooms;
    private ListingType type;
    private PropertyStatus status;
    private List<String> nearbyLocations;

    public Property(String title, String location, int price, double size, String rooms,
                    ListingType type, List<String> nearbyLocations) {
        this.id = idCounter++;
        this.title = title;
        this.location = location.toLowerCase();
        this.price = price;
        this.size = size;
        this.rooms = rooms.toLowerCase();
        this.type = type;
        this.status = PropertyStatus.AVAILABLE;
        this.nearbyLocations = nearbyLocations;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getLocation() { return location; }
    public int getPrice() { return price; }
    public double getSize() { return size; }
    public String getRooms() { return rooms; }
    public ListingType getType() { return type; }
    public PropertyStatus getStatus() { return status; }
    public List<String> getNearbyLocations() { return nearbyLocations; }

    public void markSold() { this.status = PropertyStatus.SOLD; }
}
