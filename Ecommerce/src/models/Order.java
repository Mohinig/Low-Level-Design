package models;

import enums.OrderStatus;

import java.util.List;

public class Order {
     Account user;
     int id;
     List<OrderItem> items;
     double total;
     OrderStatus status;
     OrderStatus current;

     public Order(Account user, int id, List<OrderItem> items, double total, OrderStatus status, OrderStatus current) {
          this.user = user;
          this.id = id;
          this.items = items;
          this.total = total;
          this.status = OrderStatus.PLACED;
     }
}
