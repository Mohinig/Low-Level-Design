import java.sql.Time;
import java.util.Date;
import java.util.Objects;

public class Bid {
    private long time;
    private int amount;

    public Bid(int amount) {
        this.time = System.nanoTime();
        this.amount = amount;
    }

    public long getTime() {
        return time;
    }

    public int getAmount() {
        return amount;
    }


}
