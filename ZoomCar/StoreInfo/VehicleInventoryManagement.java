package ZoomCar.StoreInfo;

import ZoomCar.Product.Vehicle;

import java.util.List;

public class VehicleInventoryManagement {
    private List<Vehicle> vehicleList;

    public VehicleInventoryManagement(List<Vehicle> vehicleList) {
        this.vehicleList=vehicleList;
    }

    public List<Vehicle> getVehicleList() {
        return vehicleList;
    }

    public void setVehicleList(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }
}
