package ZoomCar.Product;

public class Vehicle {
    int id;
    String vehicleNo;
    VehicleType vehicletype;
    int kmDriven;
    Status status;

    public Vehicle(int id, String vehicleNo, VehicleType vehicletype, int kmDriven, Status status) {
        this.id = id;
        this.vehicleNo = vehicleNo;
        this.vehicletype = vehicletype;
        this.kmDriven = kmDriven;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public VehicleType getVehicletype() {
        return vehicletype;
    }

    public void setVehicletype(VehicleType vehicletype) {
        this.vehicletype = vehicletype;
    }

    public int getKmDriven() {
        return kmDriven;
    }

    public void setKmDriven(int kmDriven) {
        this.kmDriven = kmDriven;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
