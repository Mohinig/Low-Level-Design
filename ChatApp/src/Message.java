import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

public class Message {
    String id;
    LocalDateTime timestamp;
    User sender;
    String content;


    public Message(User sender, String content) {
        this.id = UUID.randomUUID().toString();
        this.timestamp=LocalDateTime.now();
        this.sender = sender;
        this.content = content;
    }

    public String getId() {
        return id;
    }


    public LocalDateTime getTimestamp() {
        return timestamp;
    }


    public User getSender() {
        return sender;
    }


    public String getContent() {
        return content;
    }

}
