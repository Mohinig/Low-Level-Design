package objects;

import java.util.UUID;

public class Customer {
    private final String id;
    private final String name;
    private final String email;
    private final int phoneNo;

    public Customer(String name, String email, int phoneNo) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
    }

    public String getId() {
        return id;
    }
}
