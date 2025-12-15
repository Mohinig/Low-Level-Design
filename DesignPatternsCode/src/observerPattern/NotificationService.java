package observerPattern;

import java.util.ArrayList;
import java.util.List;

public class NotificationService implements Publisher{
    private List<Subscriber> subscriberList=new ArrayList<>();
    @Override
    public void subscribe(Subscriber subscriber) {
       subscriberList.add(subscriber);
    }

    @Override
    public void unsubscribe(Subscriber subscriber) {
       subscriberList.remove(subscriber);
    }

    @Override
    public void notify(String message) {
   for(Subscriber subscriber:subscriberList){
       subscriber.update(message);
   }
    }
}
