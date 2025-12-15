import java.sql.Time;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class InMemoryBookingRepository implements BookingRepository {
    private final Map<String, Booking> bookings = new ConcurrentHashMap<>();

    @Override
    public Booking save(Booking booking) {
        bookings.put(booking.getBookingId(), booking);
        return booking;
    }

    @Override
    public Optional<Booking> findById(String bookingId) {
        return Optional.ofNullable(bookings.get(bookingId));
    }

    @Override
    public List<Booking> findByRoomId(String roomId) {
        return bookings.values().stream()
                .filter(b -> b.getRoomId().equals(roomId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Booking> findByEmployeeId(String employeeId) {
        return bookings.values().stream()
                .filter(b -> b.getEmployeeId().equals(employeeId))
                .collect(Collectors.toList());
    }

    @Override
    public List<Booking> findByRoomIdAndInterval(String roomId, TimeSlot slot) {
        return bookings.values().stream()
                .filter(b -> b.getRoomId().equals(roomId))
                .filter(Booking::isActive)
                .filter(b -> b.overlaps(slot))
                .collect(Collectors.toList());
    }
}
