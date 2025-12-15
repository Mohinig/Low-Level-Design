package parking;

import fee.Fee;
import fee.FlatFee;
import parking.ParkingFloor;
import parking.Ticket;
import vehicletype.Vehicle;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingLot {
   private static ParkingLot parkingLot;
   private final List<ParkingFloor> parkingFloorList;
   private final Map<String, Ticket> activeTickets=new ConcurrentHashMap<>();
   private Fee fee;

   private ParkingLot(){
      parkingFloorList=new ArrayList<>();
      fee=new FlatFee();
   }
   public static synchronized ParkingLot getParkingLot(){
      if(parkingLot==null){
         parkingLot=new ParkingLot();
      }
      return parkingLot;
   }
   public List<ParkingFloor> getParkingFloors(){
      return parkingFloorList;
   }
   public void addFloors(ParkingFloor parkingFloor){
      parkingFloorList.add(parkingFloor);
   }
   public void setFee(Fee fee){
      this.fee=fee;
   }
   public synchronized Ticket parkVehicle(Vehicle vehicle) throws Exception{
      for(ParkingFloor parkingFloor:parkingFloorList){
         Optional<ParkingSpot> parkingSpot=parkingFloor.getAvailableSpot(vehicle.getVehicleType());
         if(parkingSpot.isPresent()){
            ParkingSpot spot=parkingSpot.get();
            String ticketId = UUID.randomUUID().toString();
            Ticket ticket=new Ticket(ticketId,vehicle,spot);
            activeTickets.put(ticketId,ticket);
            return ticket;
         }
      }
      throw new Exception("No available spots"+vehicle.getVehicleType());
   }
   public synchronized double unparkVehicle(String ticketId)throws Exception{
      Ticket ticket=activeTickets.get(ticketId);
      if(ticket==null)throw new Exception("Invalid tickets");
      ParkingSpot spot=ticket.getParkingSpot();
      spot.unpark();
      ticket.setExitTime();
      return fee.calculateFee(ticket);
   }
}
