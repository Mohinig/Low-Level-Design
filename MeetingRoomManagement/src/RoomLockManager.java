import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class RoomLockManager {
    private final ConcurrentHashMap<String, ReentrantLock> roomLocks = new ConcurrentHashMap<>();

    public ReentrantLock getLockForRoom(String roomId) {
        return roomLocks.computeIfAbsent(roomId, key -> new ReentrantLock());
    }
}
