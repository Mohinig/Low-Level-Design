package models;

public class Account {
    String name;
    String password;
    ShoppingCart shoppingCart;

    public Account(String name, String password) {
        this.name = name;
        this.password = password;
        this.shoppingCart = new ShoppingCart();
    }
    ShoppingCart getCart(){
        return shoppingCart;
    }
}
