package objects;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Restaurant {
    private final String id;
    private final String name;
    private final String address;
    private final List<FoodItem> foodItemList;

    public Restaurant(String name, String address) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.address = address;
        this.foodItemList=new ArrayList<>();
    }
    public void addFoodItems(FoodItem foodItem){
        foodItemList.add(foodItem);
    }
    public void removeFoodItem(FoodItem foodItem){
        foodItemList.remove(foodItem);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public List<FoodItem> getFoodItemList() {
        return foodItemList;
    }
}
