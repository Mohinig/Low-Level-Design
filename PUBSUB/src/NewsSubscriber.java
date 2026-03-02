public class NewsSubscriber implements Subscriber{
    String id;

    public NewsSubscriber(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public void onMessage(Message message) {
        System.out.println("Received message:"+message+" on NewsSubscriber:"+id);
    }
}
