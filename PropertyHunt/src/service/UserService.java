package service;

import models.User;

import java.util.HashMap;
import java.util.Map;

public class UserService {
    private Map<String, User> users = new HashMap<>();
    private User activeUser;


    public void register(String name) {
        users.putIfAbsent(name, new User(name));
        System.out.println("<-User registered: " + name);
    }

    public void login(String name) {
        User user = users.get(name);
        if (user != null) {
            user.login();
            activeUser = user;
            System.out.println("<-" +
                    "Welcome " + name);
        } else System.out.println("<-User not found.");
    }

    public void logout() {
        if (activeUser != null) {
            activeUser.logout();
            System.out.println("<-Goodbye " + activeUser.getName());
            activeUser = null;
        }
    }

    public User getActiveUser() {
        return activeUser;
    }
}
