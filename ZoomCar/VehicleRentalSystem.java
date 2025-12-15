package ZoomCar;

import ZoomCar.StoreInfo.Location;
import ZoomCar.StoreInfo.Store;
import ZoomCar.UserProfile.User;

import java.util.ArrayList;
import java.util.List;

public class VehicleRentalSystem {
    List<User> userList=new ArrayList<>();
    List<Store> storeList=new ArrayList<>();

    public VehicleRentalSystem(List<User> userList, List<Store> storeList) {
        this.userList = userList;
        this.storeList = storeList;
    }
    public Store getStore(Location location){
        return storeList.get(0);
    }

}
