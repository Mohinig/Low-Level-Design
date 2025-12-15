import java.util.UUID;

public class PaymentMethod {
    String id;
    User user;
    PaymentMethodType type;

    public PaymentMethod(User user, PaymentMethodType type) {
        this.id = UUID.randomUUID().toString();
        this.user = user;
        this.type = type;
    }
}
