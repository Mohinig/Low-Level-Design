package objects;

import java.util.UUID;

public class DeliveryAgent {
    private final String id;
    private final String name;
    private final int phoneNo;
    private boolean availabilityStatus;

    public DeliveryAgent(String name, int phoneNo) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.phoneNo = phoneNo;
        this.availabilityStatus=true;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPhoneNo() {
        return phoneNo;
    }
    public void setAvailabilityStatus(boolean available){
        this.availabilityStatus=available;
    }
    public synchronized boolean isAvailabilityStatus() {
        return availabilityStatus;
    }
    public synchronized void assign(){
        if(!availabilityStatus)throw new IllegalStateException("Already assigned");
        availabilityStatus=false;
    }
    public synchronized void release(){
        availabilityStatus=true;
    }
}
