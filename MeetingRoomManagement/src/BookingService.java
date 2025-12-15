import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

class BookingService {

    private final BookingRepository bookingRepo;
    private final MeetingRoomRepository roomRepo;
    private final RoomLockManager roomLockManager;
    private final AtomicLong bookingIdSeq = new AtomicLong(1);

    public BookingService(BookingRepository bookingRepo,
                          MeetingRoomRepository roomRepo,
                          RoomLockManager roomLockManager) {
        this.bookingRepo = bookingRepo;
        this.roomRepo = roomRepo;
        this.roomLockManager = roomLockManager;
    }

    // bookRoom(employeeId, roomId, startTime, endTime)
    public Booking bookRoom(String employeeId, String roomId,
                            LocalDateTime startTime, LocalDateTime endTime) {
        // 1. Validate times
        TimeSlot slot = new TimeSlot(startTime, endTime);

        // 2. Validate room exists
        MeetingRoom room = roomRepo.findById(roomId)
                .orElseThrow(() -> new IllegalArgumentException("Room not found: " + roomId));

        ReentrantLock lock = roomLockManager.getLockForRoom(roomId);
        lock.lock();
        try {
            // 3. Check overlapping active bookings
            List<Booking> overlapping = bookingRepo.findByRoomIdAndInterval(roomId, slot);
            if (!overlapping.isEmpty()) {
                throw new IllegalStateException("Room is already booked in the given time slot");
            }

            // 4. Create booking
            String bookingId = "B-" + bookingIdSeq.getAndIncrement();
            Booking booking = new Booking(
                    bookingId,
                    employeeId,
                    roomId,
                    slot,
                    LocalDateTime.now()
            );
            bookingRepo.save(booking);
            return booking;
        } finally {
            lock.unlock();
        }
    }

    // getAvailableRooms(startTime, endTime)
    public List<MeetingRoom> getAvailableRooms(LocalDateTime startTime, LocalDateTime endTime) {
        TimeSlot slot = new TimeSlot(startTime, endTime); // validates range
        List<MeetingRoom> allRooms = roomRepo.findAll();
        List<MeetingRoom> available = new ArrayList<>();

        for (MeetingRoom room : allRooms) {
            List<Booking> activeOverlaps = bookingRepo
                    .findByRoomIdAndInterval(room.getRoomId(), slot);
            if (activeOverlaps.isEmpty()) {
                available.add(room);
            }
        }
        return available;
    }

    // cancelBooking(bookingId)
    public void cancelBooking(String bookingId) {
        Booking booking = bookingRepo.findById(bookingId)
                .orElseThrow(() -> new IllegalArgumentException("Booking not found: " + bookingId));

        // Lock per-room to avoid weird races with new bookings
        ReentrantLock lock = roomLockManager.getLockForRoom(booking.getRoomId());
        lock.lock();
        try {
            if (!booking.isCancelled()) {
                booking.cancel();
                bookingRepo.save(booking); // re-save updated state
            }
        } finally {
            lock.unlock();
        }
    }

    // listBookingsForRoom(roomId)
    public List<Booking> listBookingsForRoom(String roomId) {
        return bookingRepo.findByRoomId(roomId)
                .stream()
                .sorted(Comparator.comparing(b -> b.getTimeSlot().getStartTime()))
                .collect(Collectors.toList());
    }

    // listBookingsForEmployee(employeeId)
    public List<Booking> listBookingsForEmployee(String employeeId) {
        return bookingRepo.findByEmployeeId(employeeId)
                .stream()
                .sorted(Comparator.comparing(b -> b.getTimeSlot().getStartTime()))
                .collect(Collectors.toList());
    }

    // Optional helper: mark completed bookings (could be scheduled job)
    public void markCompletedBookings(LocalDateTime now) {
        // in-memory version: iterate all bookings
        // (in DB you'd run an UPDATE with a WHERE condition)
    }
}