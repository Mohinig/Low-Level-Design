package ZoomCar;

import ZoomCar.Product.Status;
import ZoomCar.Product.Vehicle;
import ZoomCar.Product.VehicleType;
import ZoomCar.StoreInfo.Location;
import ZoomCar.StoreInfo.Store;
import ZoomCar.UserProfile.Bill;
import ZoomCar.UserProfile.Payment;
import ZoomCar.UserProfile.Reservation;
import ZoomCar.UserProfile.User;

import java.util.ArrayList;
import java.util.List;

public class ZoomCar {

    public static void main(String[] args) {
        List<User> userList=addUser();
        List<Vehicle> vehicleList=addVehicle();
        List<Store> storeList=addStore(vehicleList);
        VehicleRentalSystem vehicleRentalSystem=new VehicleRentalSystem(userList,storeList);

        User user=userList.get(0);

        Location location=new Location("Blr","Karnataka");
        Store store=vehicleRentalSystem.getStore(location);

        List<Vehicle> storeVehicle=store.getVehicle(VehicleType.CAR);
        Reservation reservation=store.createReservation(storeVehicle.get(1),user);
        Bill bill=new Bill(reservation);
        Payment payment=new Payment();
        payment.PayBill(bill);
        store.completeReservation(reservation.reservationId);
    }

    private static List<Store> addStore(List<Vehicle> vehicleList) {
        Store store1=new Store();
        store1.setVehicle(vehicleList);
        List<Store> storeList=new ArrayList<>();
        storeList.add(store1);
        return storeList;
    }

    private static List<Vehicle> addVehicle() {
        Vehicle vehicle1=new Vehicle(1,"KA9395U925", VehicleType.CAR,2000, Status.ACTIVE);
        Vehicle vehicle2=new Vehicle(1,"KA9395U925", VehicleType.CAR,2000, Status.ACTIVE);
        List<Vehicle> vehicleList=new ArrayList<>();
        vehicleList.add(vehicle1);
        vehicleList.add(vehicle2);
        return  vehicleList;
    }

    private static List<User> addUser() {
        User user1=new User(1,"WB925025","MOHINI");
        User user2=new User(2,"WB02Y502","PINAKI");
        List<User> userList=new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        return userList;
    }


}
