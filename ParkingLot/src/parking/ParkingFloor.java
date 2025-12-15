package parking;

import vehicletype.Vehicle;
import vehicletype.VehicleType;

import java.util.List;
import java.util.Optional;

public class ParkingFloor {
    private final int parkingFloorNumber;
    private final List<ParkingSpot> parkingSpots;

    public ParkingFloor(int parkingFloorNumber, List<ParkingSpot> parkingSpots) {
        this.parkingFloorNumber = parkingFloorNumber;
        this.parkingSpots = parkingSpots;
    }
    public synchronized Optional<ParkingSpot> getAvailableSpot(VehicleType type){
        return parkingSpots.stream().filter(parkingSpot -> parkingSpot.isAvailable() && parkingSpot.getVehicleType()==type).findFirst();
    }
    public int getParkingFloorNumber(){
        return parkingFloorNumber;
    }

    public List<ParkingSpot> getParkingSpots(){
        return parkingSpots;
    }

    List<Integer> getAvailableSpots(VehicleType type){
        return parkingSpots.stream()
                .filter(parkingSpot -> parkingSpot.isAvailable() && parkingSpot.getVehicleType()==type)
                .map(ParkingSpot::getSpotNumber)
                .toList();
    }
}
