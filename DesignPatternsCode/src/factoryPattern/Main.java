package factoryPattern;

public class Main {
    public static void main(String[] args) {
        Vehicle car=VehicleFactory.getVehicle("car");
        car.setWheels();
        car.drive();
        Vehicle bike=VehicleFactory.getVehicle("bike");
        bike.setWheels();
        bike.drive();
    }
}

