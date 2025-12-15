package decoratorPattern;

public class TopingsDecorator implements Pizza{
    protected final Pizza toppings;

    public TopingsDecorator(Pizza toppings) {
        this.toppings = toppings;
    }

    @Override
    public void make() {

    }
}
