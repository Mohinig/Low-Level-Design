import fee.VehicleBasedFee;
import parking.ParkingFloor;
import parking.ParkingLot;
import parking.ParkingSpot;
import parking.Ticket;
import vehicletype.Car;
import vehicletype.Motorcycle;
import vehicletype.Vehicle;
import vehicletype.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ParkingLot parkingLot= ParkingLot.getParkingLot();
        List<ParkingSpot> parkingSpots1=List.of(
                new ParkingSpot(101, VehicleType.CAR),
                new ParkingSpot(102,VehicleType.CAR),
                new ParkingSpot(103,VehicleType.MOTORCYCLE)
        );
        List<ParkingSpot> parkingSpots2=List.of(
                new ParkingSpot(201, VehicleType.CAR),
                new ParkingSpot(202,VehicleType.CAR),
                new ParkingSpot(203,VehicleType.MOTORCYCLE)
        );
        ParkingFloor floor1=new ParkingFloor(1,parkingSpots1);
        ParkingFloor floor2=new ParkingFloor(2,parkingSpots2);
        parkingLot.addFloors(floor1);
        parkingLot.addFloors(floor2);

        parkingLot.setFee(new VehicleBasedFee());
        Vehicle car1=new Car(12345);
        Vehicle car2=new Car(23456);
        Vehicle car3=new Car(34567);
        Vehicle bike=new Motorcycle(980);
        System.out.println("Available spots");
        for(ParkingFloor floor:parkingLot.getParkingFloors()){
            System.out.println("Floor: "+floor.getParkingFloorNumber()+" "+floor.getAvailableSpot(VehicleType.CAR));
        }
        List<String> parkingTicket=new ArrayList<>();
        try{
            Ticket ticket1=parkingLot.parkVehicle(car1);
            System.out.println("Car 1:"+ticket1.getTicketId());
            parkingTicket.add(ticket1.getTicketId());

            Ticket ticket2=parkingLot.parkVehicle(car2);
            System.out.println("Car 2:"+ticket2.getTicketId());
            parkingTicket.add(ticket2.getTicketId());

            Ticket ticket3=parkingLot.parkVehicle(bike);
            System.out.println("Bike:"+ticket3.getTicketId());
            parkingTicket.add(ticket3.getTicketId());

            Ticket ticket4=parkingLot.parkVehicle(car3);
            System.out.println("Car 3:"+ticket4.getTicketId());
            parkingTicket.add(ticket4.getTicketId());
        }catch (Exception e){
            System.out.println("Exception: "+e.getMessage());
        }
        try{
            double fee=parkingLot.unparkVehicle(parkingTicket.get(0));
            System.out.println("Ticket:"+parkingTicket.get(0)+",Fee:"+fee);
        }catch (Exception e){
            System.out.println("Exception: "+e.getMessage());
        }
    }
}