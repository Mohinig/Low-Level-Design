package ZoomCar.UserProfile;

public class Bill {
    Reservation reservation;
    boolean isPaid;
    double amount;

    public Bill(Reservation reservation) {
        this.reservation = reservation;
        this.isPaid = false;
        this.amount = computeAmount();
    }

    private double computeAmount() {
        return 100.0;
    }

}
