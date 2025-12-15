package parking;

import vehicletype.Vehicle;
import vehicletype.VehicleType;

public class ParkingSpot {
    private final int spotNumber;
    private final VehicleType vehicleType;
    private Vehicle vehicle;
    private boolean isOccupied;

    public ParkingSpot(int spotNumber, VehicleType vehicleType) {
        this.spotNumber = spotNumber;
        this.vehicleType = vehicleType;
        this.isOccupied = false;
    }
    public synchronized boolean isAvailable(){
        return !isOccupied;
    }
    public synchronized boolean park(Vehicle vehicle){
        if(isOccupied || vehicle.getVehicleType()!=vehicleType)
            return false;
        this.vehicle=vehicle;
        isOccupied=true;
        return true;
    }
    public synchronized void unpark(){
        vehicle=null;
        isOccupied=false;
    }
    VehicleType getVehicleType(){
        return vehicleType;
    }
    Vehicle getVehicle(){
        return vehicle;
    }
    int getSpotNumber(){
        return spotNumber;
    }
}
