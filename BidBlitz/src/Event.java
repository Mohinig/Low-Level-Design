import java.util.*;

public class Event {
    private final String eventName;
    private final int id;
    private final String prize;
    private final Date date;

    private final Set<Integer> registeredMembers=new HashSet<>();

    private final Map<Integer,List<Bid>> bidsMemberMap=new HashMap<>();

    public Event(String eventName, int id, String prize, Date date) {
        this.eventName = eventName;
        this.id = id;
        this.prize = prize;
        this.date = date;
    }

    public String getEventName() {
        return eventName;
    }

    public int getId() {
        return id;
    }

    public String getPrize() {
        return prize;
    }

    public Date getDate() {
        return date;
    }

    public void registerMembers(int id){
        registeredMembers.add(id);
    }
  public boolean isMemberRegistered(int memberId){
        return registeredMembers.contains(memberId);
  }
  public void submitBids(int id,List<Bid> bids){
        bidsMemberMap.put(id,bids);
  }
  public Map<Integer,List<Bid>> getBidsMemberMap(){
        return bidsMemberMap;
  }
}
