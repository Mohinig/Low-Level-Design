package abstractFactoryPattern;

public class ElectricCar implements Car{
    @Override
    public void drive() {
        System.out.println("Driving an Electric Car.");
    }
}
