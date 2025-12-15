package ZoomCar.UserProfile;

public class User {
    int userID;
    String licenseNo;
    String name;

    public User(int userID, String licenseNo, String name) {
        this.userID = userID;
        this.licenseNo = licenseNo;
        this.name = name;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
