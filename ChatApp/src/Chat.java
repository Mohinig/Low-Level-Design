import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

abstract class Chat {
  String id;
  List<User> users;
  List<Message> messages;

    public Chat() {
        this.id = UUID.randomUUID().toString();
        this.users = new CopyOnWriteArrayList<>();
        this.messages = new CopyOnWriteArrayList<>();
    }

    public String getId() {
        return id;
    }

    public List<User> getUsers() {
        return List.copyOf(users);
    }

    public List<Message> getMessages() {
        return List.copyOf(messages);
    }

    void addMessage(Message message){
      this.messages.add(message);
  }
  public abstract String getName(User perspectiveUser);
}
