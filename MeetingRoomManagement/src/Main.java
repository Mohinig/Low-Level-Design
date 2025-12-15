

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.time.LocalDateTime;

public class Main {

    public static void main(String[] args) {

        // --- Create Repositories ---
        BookingRepository bookingRepo = new InMemoryBookingRepository();
        MeetingRoomRepository roomRepo = new InMemoryMeetingRoomRepository(); // we will define below
        RoomLockManager lockManager = new RoomLockManager();

        // --- Create Service ---
        BookingService bookingService = new BookingService(bookingRepo, roomRepo, lockManager);

        // --- Add Rooms ---
        roomRepo.save(new MeetingRoom("R1", "Conference A", 10, "Floor 1"));
        roomRepo.save(new MeetingRoom("R2", "Conference B", 8, "Floor 1"));
        roomRepo.save(new MeetingRoom("R3", "Board Room", 12, "Floor 2"));

        // --- Simulate Employee Details ---
        String empA = "E101";
        String empB = "E102";

        // --- Booking Examples ---

        LocalDateTime t1 = LocalDateTime.of(2025, 1, 10, 10, 0);
        LocalDateTime t2 = LocalDateTime.of(2025, 1, 10, 11, 0);

        System.out.println("== Booking Room R1 for 10:00–11:00 ==");
        Booking b1 = bookingService.bookRoom(empA, "R1", t1, t2);
        System.out.println("Booking ID: " + b1.getBookingId());

        // Try overlapping booking
        LocalDateTime t3 = LocalDateTime.of(2025, 1, 10, 10, 30);
        LocalDateTime t4 = LocalDateTime.of(2025, 1, 10, 11, 30);

        System.out.println("\n== Trying overlapping booking for R1 ==");
        try {
            bookingService.bookRoom(empA, "R1", t3, t4);
        } catch (Exception e) {
            System.out.println("Expected failure: " + e.getMessage());
        }

        // Book a different room for same interval
        System.out.println("\n== Booking Room R2 for 10:30–11:30 ==");
        Booking b2 = bookingService.bookRoom(empB, "R2", t3, t4);
        System.out.println("Booking ID: " + b2.getBookingId());

        // List available rooms for a time
        System.out.println("\n== Available rooms at 10:30–11:30 ==");
        bookingService.getAvailableRooms(t3, t4).forEach(
                room -> System.out.println(room.getRoomId() + " - " + room.getName())
        );

        // List bookings for a room
        System.out.println("\n== Bookings for Room R1 ==");
        bookingService.listBookingsForRoom("R1").forEach(
                bk -> System.out.println(bk.getBookingId() + " " + bk.getTimeSlot().getStartTime())
        );

        // Cancel a booking
        System.out.println("\n== Cancel booking " + b1.getBookingId() + " ==");
        bookingService.cancelBooking(b1.getBookingId());

        // Check again
        System.out.println("\n== Bookings for Room R1 After Cancellation ==");
        bookingService.listBookingsForRoom("R1").forEach(
                bk -> System.out.println(bk.getBookingId() + " - Status: " + bk.getStatus())
        );
    }
}

