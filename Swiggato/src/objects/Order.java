package objects;

import java.util.List;
import java.util.UUID;

public class Order {
    private  final String id;
    private final Customer customer;
    private final Restaurant restaurant;
    private final List<FoodItem> orderItemList;
    private OrderStatus orderStatus;
    private DeliveryAgent deliveryAgent;



    public Order(Customer customer, Restaurant restaurant,List<FoodItem> items) {
        this.id = "ORD"+ UUID.randomUUID().toString().toUpperCase();
        this.customer = customer;
        this.restaurant = restaurant;
        this.orderItemList=items;
        this.orderStatus=OrderStatus.PENDING;
    }
    public void addItems(FoodItem item){
        orderItemList.add(item);
    }
    public void removeItems(FoodItem item){
        orderItemList.remove(item);
    }
    public double calculateAmount(List<FoodItem> items){
        double total=0.0;
        for(FoodItem foodItem:items){
            total+=foodItem.getPrice();
        }
        return total;
    }
    public void assignDeliveryAgent(DeliveryAgent agent){
        deliveryAgent=agent;
    }

    public void updateOrderStatus(OrderStatus orderStatus){
        this.orderStatus=orderStatus;
    }
    public String getId() {
        return id;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public DeliveryAgent getDeliveryAgent() {
        return deliveryAgent;
    }
}
