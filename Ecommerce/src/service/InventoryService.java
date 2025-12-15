package service;

import models.OrderItem;
import models.Product;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InventoryService {
    Map<String,Integer> stock;
    InventoryService getInstance(){
        return getInstance();
    }

    public InventoryService() {
        this.stock = new ConcurrentHashMap<>();
    }
    public void addProduct(Product product,int q){
        stock.put(product.getName(),stock.getOrDefault(product.getName(),0)+q);
    }
    public Map<String,Integer> getStock(){
        return stock;
    }
    public synchronized void updateStock(List<OrderItem> items){
        for(OrderItem item:items) {
            if (stock.getOrDefault(item.getProduct().getName(), 0) < item.getQuantity()) {
                throw new RuntimeException("Not enough product");
            }
        }
            for(OrderItem item:items){
                stock.compute(item.getProduct().getName(),(id,curr)->curr- item.getQuantity());
            }
        }
}
