package abstractFactoryPattern;

public class Main {
    public static void main(String[] args) {
        VehicleFactory electricFactory=new ElectricVehicleFactory();
        Car eCar= electricFactory.createCar();
        Bike eBike= electricFactory.createBike();
        eCar.drive();
        eBike.ride();
        VehicleFactory petrolFactory=new PetrolVehicleFactory();
        Car pCar=petrolFactory.createCar();
        Bike pBike= petrolFactory.createBike();
        pCar.drive();
        pBike.ride();
    }
}
