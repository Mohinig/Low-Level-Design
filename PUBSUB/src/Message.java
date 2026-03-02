import java.time.LocalDateTime;

public class Message {
    String payload;
    LocalDateTime timestamp;

    public Message(String payload) {
        this.payload = payload;
        this.timestamp = LocalDateTime.now();
    }

    public String getPayload() {
        return payload;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Message{" +
                "payload='" + payload + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
