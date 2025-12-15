package builderAndPrototypePattern;

public class Main {
    public static void main(String[] args) {
        Address address = new Address("Bangalore", "India");

        UserProfile original = new UserProfile.Builder()
                .setName("Ananya")
                .setEmail("ananya@example.com")
                .setAddress(address)
                .addPreference("Dark Mode")
                .addPreference("Email Notifications")
                .build();

        // Clone the profile
        UserProfile copy = original.clone();
        original.getPreferences().add("Changed setting");
        System.out.println("Original: " + original);
        System.out.println("Copy:     " + copy);
    }
}
