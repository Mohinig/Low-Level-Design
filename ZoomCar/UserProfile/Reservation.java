package ZoomCar.UserProfile;

import ZoomCar.Product.Vehicle;
import ZoomCar.StoreInfo.Location;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
    public int reservationId;
    User user;
    Vehicle vehicle;
    Location location;
    Date start;
    Date end;
    ReservationStatus reservationStatus;

    public int createReserve(Vehicle vehicle, User user) {
        reservationId=1223;
        this.user=user;
        this.vehicle=vehicle;
        reservationStatus=ReservationStatus.SCHEDULED;
        return reservationId;
    }
}
