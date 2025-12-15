import java.util.Date;
import java.util.UUID;

public class Transaction {
    private final String id;
    private final Account userFrom;
    private final Account userTo;
    private final double amount;
    private final Date date;

    public Transaction(Account userFrom, Account userTo, double amount) {
        this.id = UUID.randomUUID().toString();
        this.userFrom = userFrom;
        this.userTo = userTo;
        this.amount = amount;
        this.date = new Date();
    }

    public String getId() {
        return id;
    }

    public String getUserFrom() {
        return userFrom.getUser().getName().toString();
    }

    public String getUserTo() {
        return userTo.getUser().getName().toString();
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }
}
