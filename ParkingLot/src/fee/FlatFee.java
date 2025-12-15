package fee;

import parking.Ticket;

public class FlatFee implements Fee {
    private static final double RATE_PER_HOUR=10.0;
    @Override
    public double calculateFee(Ticket ticket) {
        long duration=ticket.getExitTime()-ticket.getEntryTime();
        long hours=(duration/(1000*60*60))+1;
        return hours*RATE_PER_HOUR;
    }
}
