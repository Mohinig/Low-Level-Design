package models;

import java.util.HashSet;
import java.util.Set;

public class User {
    private String name;
    private boolean isActive;
    private Set<Integer> listedProperties;
    private Set<Integer> shortlistedProperties;

    public User(String name) {
        this.name = name;
        this.isActive = false;
        this.listedProperties = new HashSet<>();
        this.shortlistedProperties = new HashSet<>();
    }

    public String getName() { return name; }
    public void login() { isActive = true; }
    public void logout() { isActive = false; }
    public Set<Integer> getListedProperties() { return listedProperties; }
    public Set<Integer> getShortlistedProperties() { return shortlistedProperties; }
}
