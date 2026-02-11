import java.sql.Time;
import java.util.UUID;

public class User {
    String id;
    String name;

    public User(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void onMessageReceived(Message message,Chat chat){
        System.out.printf("[Notification for %s in chat '%s'] %s: %s\n",
                this.getName(), chat.getName(this), message.getSender().getName(), message.getContent());
    }
}
