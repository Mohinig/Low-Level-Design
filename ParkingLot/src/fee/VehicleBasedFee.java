package fee;

import parking.Ticket;
import vehicletype.VehicleType;

import java.util.Map;

public class VehicleBasedFee implements Fee{
    private final Map<VehicleType, Double> hourlyRates = Map.of(
            VehicleType.CAR, 20.0,
            VehicleType.MOTORCYCLE, 10.0,
            VehicleType.TRUCK, 30.0
    );
    @Override
    public double calculateFee(Ticket ticket) {
        long duration=ticket.getExitTime()-ticket.getEntryTime();
        long hours=(duration/(1000*60*60))+1;
        return hours*hourlyRates.get(ticket.getVehicle().getVehicleType());
    }
}
