
import java.time.LocalDateTime;

public class Booking {
    private final String bookingId;
    private final String employeeId;
    private final String roomId;
    private final TimeSlot timeSlot;
    private final LocalDateTime createdAt;
    private BookingStatus status;

    public Booking(String bookingId, String employeeId, String roomId,
                   TimeSlot timeSlot, LocalDateTime createdAt) {
        this.bookingId = bookingId;
        this.employeeId = employeeId;
        this.roomId = roomId;
        this.timeSlot = timeSlot;
        this.createdAt = createdAt;
        this.status = BookingStatus.ACTIVE;
    }

    public String getBookingId() { return bookingId; }
    public String getEmployeeId() { return employeeId; }
    public String getRoomId() { return roomId; }
    public TimeSlot getTimeSlot() { return timeSlot; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public BookingStatus getStatus() { return status; }

    public boolean isActive() {
        return status == BookingStatus.ACTIVE;
    }

    public boolean isCancelled() {
        return status == BookingStatus.CANCELLED;
    }

    public boolean overlaps(TimeSlot slot) {
        if (!isActive()) return false;
        return this.timeSlot.overlaps(slot);
    }

    public void cancel() {
        if (status == BookingStatus.CANCELLED) return;
        this.status = BookingStatus.CANCELLED;
    }

    public void markCompleted() {
        if (status == BookingStatus.ACTIVE) {
            this.status = BookingStatus.COMPLETED;
        }
    }
}
