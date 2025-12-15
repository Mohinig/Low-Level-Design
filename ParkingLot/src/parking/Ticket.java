package parking;

import vehicletype.Vehicle;

import java.util.Date;

public class Ticket {
    private final String ticketId;
    private final Vehicle vehicle;
    private final ParkingSpot parkingSpot;
    private final  long entryTime;
    private long exitTime;

    public Ticket(String ticketId, Vehicle vehicle, ParkingSpot parkingSpot) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
        this.entryTime = new Date().getTime();
    }

    public String getTicketId() {
        return ticketId;
    }


    public Vehicle getVehicle() {
        return vehicle;
    }


    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }


    public long getEntryTime() {
        return entryTime;
    }

    public long getExitTime() {
        return exitTime;
    }

    public void setExitTime() {
        this.exitTime = new Date().getTime();
    }
}
