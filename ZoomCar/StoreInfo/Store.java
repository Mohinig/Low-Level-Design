package ZoomCar.StoreInfo;

import ZoomCar.Product.Vehicle;
import ZoomCar.Product.VehicleType;
import ZoomCar.UserProfile.Reservation;
import ZoomCar.UserProfile.User;

import java.util.ArrayList;
import java.util.List;

public class Store {
    int storeID;
    VehicleInventoryManagement vehicleInventoryManagement;
    Location location;
    List<Reservation> reservationList =new ArrayList<>();
     public List<Vehicle> getVehicle(VehicleType vehicleType){
         return vehicleInventoryManagement.getVehicleList();
     }
     public void setVehicle(List<Vehicle> vehicleList){
         vehicleInventoryManagement=new VehicleInventoryManagement(vehicleList);
     }
     public Reservation createReservation(Vehicle vehicle, User user){
         Reservation reservation=new Reservation();
         reservation.createReserve(vehicle,user);
         return reservation;
     }
     public boolean completeReservation(int resId){
         return true;
     }
}
