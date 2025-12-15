package strategy;

import model.Ride;

import java.util.List;

public interface RideSelectionStrategy {
    Ride selectRide(List<Ride> availableRides);
}
