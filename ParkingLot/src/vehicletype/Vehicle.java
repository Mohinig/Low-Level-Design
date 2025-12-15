package vehicletype;

public abstract class Vehicle {
    protected int VehicleNo;
    protected VehicleType vehicleType;

    public Vehicle(int vehicleNo, VehicleType vehicleType) {
        VehicleNo = vehicleNo;
        this.vehicleType = vehicleType;
    }

    public int getVehicleNo() {
        return VehicleNo;
    }

    public void setVehicleNo(int vehicleNo) {
        VehicleNo = vehicleNo;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
