import java.util.*;

public class InMemoryMeetingRoomRepository implements MeetingRoomRepository {

    private final Map<String, MeetingRoom> rooms = new HashMap<>();

    @Override
    public Optional<MeetingRoom> findById(String roomId) {
        return Optional.ofNullable(rooms.get(roomId));
    }

    @Override
    public List<MeetingRoom> findAll() {
        return new ArrayList<>(rooms.values());
    }

    public void save(MeetingRoom room) {
        rooms.put(room.getRoomId(), room);
    }
}
