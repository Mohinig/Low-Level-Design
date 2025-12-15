package builderAndPrototypePattern;

// Deep-copyable complex field
public class Address implements Cloneable{
    private String city;
    private String country;

    public Address(String city, String country) {
        this.city = city;
        this.country = country;
    }

    public Address(Address other) {
        this.city = other.city;
        this.country = other.country;
    }

    @Override
    public Address clone() {
        return new Address(this);
    }

    @Override
    public String toString() {
        return city + ", " + country;
    }
}
