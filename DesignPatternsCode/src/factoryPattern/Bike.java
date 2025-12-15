package factoryPattern;

public class Bike implements Vehicle{
    int wheels;
    @Override
    public void setWheels() {
        this.wheels=2;
    }

    @Override
    public void drive() {
        System.out.println("Riding a Bike with "+wheels+" wheels");
    }
}
