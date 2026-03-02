import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;

public class Topic{
    String name;
    Set<Subscriber> subscriberSet;
    ExecutorService delieveryExecutor;

    public Topic(String name,ExecutorService delieveryExecutor) {
        this.name = name;
        this.delieveryExecutor=delieveryExecutor;
        this.subscriberSet=new HashSet<>();
    }

    void addSubscriber(Subscriber subscriber){
        subscriberSet.add(subscriber);
    }
    void removeSubscriber(Subscriber subscriber){
        subscriberSet.remove(subscriber);
    }
    void broadcast(Message message){
        for (Subscriber subscriber : subscriberSet) {
            delieveryExecutor.submit(() -> {
                try {
                    subscriber.onMessage(message);
                } catch (Exception e) {
                    System.err.println("Error delivering message to subscriber " + subscriber.getId() + ": " + e.getMessage());
                }
            });
        }
    }
}
