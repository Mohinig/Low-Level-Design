import java.util.List;
import java.util.Optional;

public interface MeetingRoomRepository {
    Optional<MeetingRoom> findById(String roomId);
    List<MeetingRoom> findAll();

    void save(MeetingRoom meetingRoom);
}
