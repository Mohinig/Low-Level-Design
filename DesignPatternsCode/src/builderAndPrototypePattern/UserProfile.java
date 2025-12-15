package builderAndPrototypePattern;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserProfile implements Cloneable {
    private String name;
    private String email;
    private Address address;
    private List<String> preferences;

    public UserProfile(Builder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.address = builder.address;
        this.preferences = builder.preferences;
    }

    // Deep clone via Prototype
    @Override
    public UserProfile clone() {
        Address clonedAddress = this.address != null ? this.address.clone() : null;
        List<String> clonedPreferences = new ArrayList<>(this.preferences);
        return new Builder()
                .setName(this.name)
                .setEmail(this.email)
                .setAddress(clonedAddress)
                .setPreferences(clonedPreferences)
                .build();
    }

    public List<String> getPreferences() {
        return preferences;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "UserProfile{name='" + name + "', email='" + email +
                "', address=" + address + ", preferences=" + preferences + '}';
    }

    public static class Builder {
        private String name;
        private String email;
        private Address address;
        private List<String> preferences = new ArrayList<>();

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setAddress(Address address) {
            this.address = address;
            return this;
        }


        public Builder setPreferences(List<String> preferences) {
            this.preferences = preferences;
            return this;
        }

        public Builder addPreference(String preference) {
            this.preferences.add(preference);
            return this;
        }

        public UserProfile build() {
            return new UserProfile(this);
        }

    }
}
