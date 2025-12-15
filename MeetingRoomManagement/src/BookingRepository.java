import java.sql.Time;
import java.util.List;
import java.util.Optional;

public interface BookingRepository {
    Booking save(Booking booking);
    Optional<Booking> findById(String bookingId);
    List<Booking> findByRoomId(String roomId);
    List<Booking> findByEmployeeId(String employeeId);
    List<Booking> findByRoomIdAndInterval(String roomId, TimeSlot slot);
}
