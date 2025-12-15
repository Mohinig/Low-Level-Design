import java.util.UUID;

public class User {
    private final String id;
    private String name;
    private String email;
    private String phoneno;

    public User(String name, String email, String phoneno) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.phoneno = phoneno;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
