package dto;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class User {
    String id;
    Set<String> followers;
    Set<String> following;
    public User(String id){
        this.id= this.getId();
        this.followers=new HashSet<>();
        this.following=new HashSet<>();
    }
    public String getId() { return id; }

    public Set<String> getFollowers() { return followers; }

    public Set<String> getFollowing() { return following; }

}
