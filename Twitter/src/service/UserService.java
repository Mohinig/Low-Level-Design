package service;

import dto.User;
import repo.UserRepository;

import java.util.concurrent.atomic.AtomicInteger;

public class UserService {
    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String createUser(String id) {
        userRepository.save(new User(id));
        return id;
    }

    public void follow(String followerId, String followeeId) {
        User follower = userRepository.findById(followerId);
        User followee = userRepository.findById(followeeId);

        if (follower != null && followee != null) {
            follower.getFollowing().add(followeeId);
            followee.getFollowers().add(followerId);
        }
    }

    public void unfollow(String followerId, String followeeId) {
        User follower = userRepository.findById(followerId);
        User followee = userRepository.findById(followeeId);

        if (follower != null && followee != null) {
            follower.getFollowing().remove(followeeId);
            followee.getFollowers().remove(followerId);
        }
    }

    public User getUser(String userId) {
        return userRepository.findById(userId);
    }
}

