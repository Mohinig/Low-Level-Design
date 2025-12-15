import objects.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FoodDeliveryService {
    private static  FoodDeliveryService instance;
    private final Map<String,Customer> customers;
    private final Map<String,Restaurant> restaurants;
    private final Map<String, Order> orders;
    private final   Map<String,DeliveryAgent> deliveryAgents;

    public FoodDeliveryService() {
        this.customers =new ConcurrentHashMap<>();
        this.restaurants = new ConcurrentHashMap<>();
        this.orders = new ConcurrentHashMap<>();
        this.deliveryAgents = new ConcurrentHashMap<>();
    }
    public static synchronized FoodDeliveryService getInstance(){
        if(instance==null)
            instance=new FoodDeliveryService();
        return instance;
    }
    public Customer registerCustomer(String name,String email,int phoneNo){
        Customer customer=new Customer(name,email,phoneNo);
        customers.put(customer.getId(),customer);
        return customer;
    }
    public Restaurant registerRestaurant(String name,String address){
        Restaurant restaurant=new Restaurant(name,address);
        restaurants.put(restaurant.getId(),restaurant);
        return restaurant;
    }
    public DeliveryAgent registerDeliveryAgent(String name,int phoneNo){
        DeliveryAgent deliveryAgent=new DeliveryAgent(name,phoneNo);
        deliveryAgents.put(deliveryAgent.getId(),deliveryAgent);
        return deliveryAgent;
    }
    public List<String> getAvailableRestaurant(){
        List<String> restaurantList=new ArrayList<>();
        for(Restaurant restaurant: restaurants.values()){
            restaurantList.add(restaurant.getName());
        }
        return restaurantList;
    }
    public void addRestaurantMenu(String restaurantId,String name,String description,double price){
        Restaurant restaurant=restaurants.get(restaurantId);
        if(restaurant==null)throw new IllegalArgumentException("Invalid restaurant");
        restaurant.addFoodItems(new FoodItem(name,description,price));
    }
    public List<String> getRestaurantMenu(String restaurantId){
        List<String> restaurantMenu=new ArrayList<>();
        Restaurant restaurant=restaurants.get(restaurantId);
        if (restaurant!=null){
            for(FoodItem foodItem:restaurant.getFoodItemList()){
                restaurantMenu.add(foodItem.getFoodItem());
            }
        }
        return restaurantMenu;
    }
    public Order placeOrder(String userId,String restaurantId,List<String> foodItems){
        Customer customer=customers.get(userId);
        Restaurant restaurant=restaurants.get(restaurantId);
        if(customer!=null && restaurant!=null){
            List<FoodItem> items=restaurant.getFoodItemList().stream()
                    .filter(foodItem1 -> foodItems.contains(foodItem1.getName()))
                    .toList();
            Order order=new Order(customer,restaurant,items);
            orders.put(order.getId(),order);
            notifyRestaurant(order);
            double price=order.calculateAmount(items);
            System.out.println("Order placed: " +order.getId() + " Amount:"+ price);
            return order;
        }
        return null;
    }

    public void updateOrderStatus(String orderId,OrderStatus orderStatus){
        Order order=orders.get(orderId);
        if(order!=null){
            order.updateOrderStatus(orderStatus);
            System.out.println("Order "+orderId+"update to "+orderStatus);
            notifyCustomer(order);
            if(orderStatus==OrderStatus.DELIVERED && order.getDeliveryAgent()!=null){
                order.getDeliveryAgent().release();
            }
        }
    }
    public void cancelOrder(String orderId){
        Order order=orders.get(orderId);
        if(order!=null && order.getOrderStatus()==OrderStatus.PENDING){
            order.updateOrderStatus(OrderStatus.CANCELLED);
            notifyCustomer(order);
            notifyRestaurant(order);
            System.out.println("Order cancelled: "+order.getId());
        }
    }

    public synchronized  void assignDeliveryAgent(String orderId){
        Order order=orders.get(orderId);
        if(order==null)throw new IllegalArgumentException("Order not found");
        for(DeliveryAgent agent: deliveryAgents.values()){
            if(agent.isAvailabilityStatus()){
                agent.assign();
                order.assignDeliveryAgent(agent);
                notifyDeliveryAgent(order);
                System.out.println("Agent "+agent.getName()+"assigned to order"+orderId);
                return;
            }
        }
        throw  new IllegalStateException("No available delivery agent");
    }
   //notification methods
    private void notifyDeliveryAgent(Order order) {
    }

    private void notifyCustomer(Order order) {
    }

    private void notifyRestaurant(Order order) {
    }
}
