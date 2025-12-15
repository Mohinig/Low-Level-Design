package observerPattern;

public class SMS implements Subscriber{
    String phoneNo;

    public SMS(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public void update(String message) {
        System.out.println("SMS sent to " + phoneNo + ": " + message);
    }
}
