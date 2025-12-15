package strategy;

import model.Ride;

import java.util.List;

public class MostVacantStrategy implements RideSelectionStrategy {
    @Override
    public Ride selectRide(List<Ride> availableRides) {
        return availableRides.stream()
                .filter(Ride::isActive)
                .max((r1, r2) -> Integer.compare(r1.getAvailableSeats(), r2.getAvailableSeats()))
                .orElse(null);
    }
}
