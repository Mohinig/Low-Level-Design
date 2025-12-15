import java.time.LocalDateTime;

public class TimeSlot {
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;

    public TimeSlot(LocalDateTime startTime, LocalDateTime endTime) {
        if (startTime == null || endTime == null) {
            throw new IllegalArgumentException("Start or end time cannot be null");
        }
        if (!startTime.isBefore(endTime)) {
            throw new IllegalArgumentException("Start time must be before end time");
        }
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalDateTime getStartTime() { return startTime; }
    public LocalDateTime getEndTime() { return endTime; }

    // [start, end) overlap check
    public boolean overlaps(TimeSlot other) {
        return this.startTime.isBefore(other.endTime)
                && this.endTime.isAfter(other.startTime);
    }

    public boolean contains(LocalDateTime t) {
        return ( !t.isBefore(startTime) ) && t.isBefore(endTime);
    }
}
