package decoratorPattern;

public class PlainPizza implements Pizza{
    private final String base;

    public PlainPizza(String base) {
        this.base = base;
    }

    @Override
    public void make() {
        System.out.println(base);
    }
}
