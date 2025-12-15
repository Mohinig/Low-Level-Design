public class MeetingRoom {
    private final String roomId;
    private final String name;
    private final int capacity;
    private final String location;

    public MeetingRoom(String roomId, String name, int capacity, String location) {
        this.roomId = roomId;
        this.name = name;
        this.capacity = capacity;
        this.location = location;
    }

    public String getRoomId() { return roomId; }
    public String getName() { return name; }
    public int getCapacity() { return capacity; }
    public String getLocation() { return location; }
}
