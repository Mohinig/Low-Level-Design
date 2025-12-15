package objects;

import java.util.UUID;

public class FoodItem {

    private final String id;
    private final String name;
    private final String description;
    private final double price;
    private boolean availability;

    public FoodItem(String name, String description, double price) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.description = description;
        this.price = price;
        this.availability = true;
    }

    public String getName() {
        return name;
    }

    public void setAvailability(boolean available) {
        this.availability=available;
    }

    public double getPrice() {
        return price;
    }

    public String getFoodItem(){
        return "Name: "+name+",Description: "+description+",Price: "+price;
    }
}
