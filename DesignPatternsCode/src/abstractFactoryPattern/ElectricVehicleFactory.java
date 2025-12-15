package abstractFactoryPattern;

public class ElectricVehicleFactory implements VehicleFactory{
    @Override
    public Car createCar() {
        return new ElectricCar();
    }

    @Override
    public Bike createBike() {
        return new ElectricBike();
    }
}
