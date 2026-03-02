public class AlertSubscriber implements Subscriber{
    String id;

    public AlertSubscriber(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public void onMessage(Message message) {
        System.out.println("Received message:"+message+" on AlertSubscriber:"+id);
    }
}
