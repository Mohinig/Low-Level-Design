package repo;

import dto.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class InMemoryUserRepository implements UserRepository {
    private final Map<String, User> users=new HashMap<>();
    public void save(User user){
        users.put(user.getId(),user);
    }

    @Override
    public User findById(String userId) {
        return users.get(userId);
    }


    @Override
    public Collection<User> findAll() {
        return users.values();
    }

}
