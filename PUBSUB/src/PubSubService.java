import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PubSubService {
    private static final PubSubService INSTANCE = new PubSubService();
    private final Map<String,Topic> topicResgistry;
    private final ExecutorService deliveryExecutor;

    public PubSubService() {
        this.topicResgistry = new ConcurrentHashMap<>();
        this.deliveryExecutor = Executors.newCachedThreadPool();
    }

    public static PubSubService getInstance() {
        return INSTANCE;
    }


    void createTopic(String topic){
      topicResgistry.putIfAbsent(topic,new Topic(topic,deliveryExecutor));
      System.out.println("Topic"+topic+"created");
    }
    void publish(String topicname,Message message){
        System.out.println("Publishing topic to:"+topicname);
       Topic topic= topicResgistry.get(topicname);
        if (topic == null) throw new IllegalArgumentException("Topic not found: " + topicname);
        topic.broadcast(message);
    }
    void subscribe(String topicname,Subscriber subscriber){
        Topic topic= topicResgistry.get(topicname);
        if (topic == null) throw new IllegalArgumentException("Topic not found: " + topicname);
        topic.addSubscriber(subscriber);
        System.out.println("Subscriber"+subscriber.getId()+"subscribed to topic"+topicname);
    }
    void unsubscribe(String topicname,Subscriber subscriber){
        Topic topic= topicResgistry.get(topicname);
        if (topic != null) throw new IllegalArgumentException("Topic not found: " + topicname);
        topic.removeSubscriber(subscriber);
        System.out.println("Subscriber"+subscriber.getId()+"unsubscribed to topic"+topicname);

    }
    void shutdown(){
        System.out.println("PubSubService shutting down...");
        deliveryExecutor.shutdown();
        try {
            // Wait a reasonable time for existing tasks to complete
            if (!deliveryExecutor.awaitTermination(60, TimeUnit.SECONDS)) {
                deliveryExecutor.shutdownNow();
            }
        } catch (InterruptedException ie) {
            deliveryExecutor.shutdownNow();
            Thread.currentThread().interrupt();
        }
        System.out.println("PubSubService shutdown complete.");
    }
}
