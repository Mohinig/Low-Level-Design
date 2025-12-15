package decoratorPattern;

public class Pepporoni extends TopingsDecorator{
    public Pepporoni(Pizza toppings) {
        super(toppings);
    }
    @Override
    public void make() {
   System.out.println("add pepporni");
    }
}
