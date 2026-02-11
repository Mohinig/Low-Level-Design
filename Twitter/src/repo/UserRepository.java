package repo;

import dto.User;

import java.util.Collection;

public interface UserRepository {
    void save(User user);
    User findById(String userId);

    Collection<User> findAll();
}
