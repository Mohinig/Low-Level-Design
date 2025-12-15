package observerPattern;

public class Main {
    public static void main(String[] args) {
        NotificationService service=new NotificationService();
        Subscriber email=new Email("mohinig@gmal.com");
        Subscriber phone=new SMS("85164146234");
        service.subscribe(email);
        service.subscribe(phone);

        service.notify("Breaking New!");

        service.unsubscribe(email);
        service.notify("News received on phone");
    }
}
