import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Member {
    private final int id;
    private final String name;
    private int supercoins;

    private final Set<Integer> registeredEvents=new HashSet<>();


    public Member(String name, int coins,int id) {
        this.name = name;
        this.supercoins = coins;
        this.id=id;
    }

    public int getSupercoins() {
        return supercoins;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void deductCoins(int amount){
        supercoins-=amount;
    }
    public void registerEvent(int eventId){
        registeredEvents.add(eventId);
    }
    public boolean isRegisteredEvent(int eventId){
        return registeredEvents.contains(eventId);
    }
}
