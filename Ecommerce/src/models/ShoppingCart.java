package models;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
   Map<Integer,CartItem> items=new HashMap<>();
   public void addItem(Product product,int q){
       if(items.containsKey(product.getId())){
           items.get(product.getId()).increament(q);
       }else{
           items.put(product.getId(),new CartItem(product,q));
       }
   }
   public void removeitem(int productId){
       items.remove(productId);
   }
   public Map<Integer,CartItem> getItems(){
       return Map.copyOf(items);
   }
   public double calculateTotal(){
       return items.values().stream().mapToDouble(CartItem::getPrice).sum();
   }
   public void clearCart(){
       items.clear();
   }
}
