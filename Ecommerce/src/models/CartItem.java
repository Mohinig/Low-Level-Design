package models;

public class CartItem {
    Product product;
    int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }
    public void increament(int x){
        this.quantity+=x;
    }
    public double getPrice(){
        return product.getPrice()*quantity;
    }
}
