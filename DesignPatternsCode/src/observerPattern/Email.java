package observerPattern;

public class Email implements Subscriber{
    private String email;

    public Email(String email) {
        this.email = email;
    }

    @Override
    public void update(String message) {
        System.out.println("Email sent to " + email + ": " + message);
    }
}
