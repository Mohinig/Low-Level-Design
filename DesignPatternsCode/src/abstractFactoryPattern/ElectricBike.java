package abstractFactoryPattern;

public class ElectricBike implements Bike{
    @Override
    public void ride() {
        System.out.println("Riding an Electric Bike.");
    }
}
