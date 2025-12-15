package factoryPattern;

public class Car implements Vehicle{
    int wheels;
    @Override
    public void setWheels() {
        this.wheels=4;
    }

    @Override
    public void drive() {
        System.out.println("Driving a Car with "+wheels+" wheels");
    }
}
