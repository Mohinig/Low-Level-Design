package strategy;

import model.Ride;

import java.util.List;

public class PreferredVehicleStrategy implements RideSelectionStrategy {
    private final String preferredModel;

    public PreferredVehicleStrategy(String preferredModel) {
        this.preferredModel = preferredModel;
    }

    @Override
    public Ride selectRide(List<Ride> availableRides) {
        return availableRides.stream()
                .filter(r -> r.getVehicle().getModel().equalsIgnoreCase(preferredModel) && r.isActive())
                .findFirst()
                .orElse(null);
    }
}
