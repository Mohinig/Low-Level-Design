package factoryPattern;

// VehicleFactory.java
public class VehicleFactory {
    public static Vehicle getVehicle(String type) {
        if (type == null) return null;
        switch (type.toLowerCase()) {
            case "car":
                return new Car();
            case "bike":
                return new Bike();
            default:
                throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
    }
}

