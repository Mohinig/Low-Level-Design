package decoratorPattern;

public class Veggies extends TopingsDecorator{
    public Veggies(Pizza toppings) {
        super(toppings);
    }
    @Override
    public void make() {
     System.out.println("add veggies");
    }
}
