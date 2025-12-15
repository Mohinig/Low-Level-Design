import service.RideService;
import strategy.MostVacantStrategy;
import strategy.PreferredVehicleStrategy;

public class App {
    public static void main(String[] args) {
        RideService rideService = new RideService();

        // Add Users and Vehicles
        rideService.addUser("Rohan", "M", 36);
        rideService.addVehicle("Rohan", "Swift", "KA-01-12345");

        rideService.addUser("Shashank", "M", 29);
        rideService.addVehicle("Shashank", "Baleno", "TS-05-62395");

        rideService.addUser("Nandini", "F", 29);

        rideService.addUser("Shipra", "F", 27);
        rideService.addVehicle("Shipra", "Polo", "KA-05-41491");
        rideService.addVehicle("Shipra", "Activa", "KA-12-12332");

        rideService.addUser("Gaurav", "M", 29);
        rideService.addUser("Rahul", "M", 35);
        rideService.addVehicle("Rahul", "XUV", "KA-05-1234");

        // Offer Rides
        rideService.offerRide("Rohan", "Hyderabad", "Bangalore", 1, "KA-01-12345");
        rideService.offerRide("Shipra", "Bangalore", "Mysore", 1, "KA-12-12332");
        rideService.offerRide("Shipra", "Bangalore", "Mysore", 2, "KA-05-41491");
        rideService.offerRide("Shashank", "Hyderabad", "Bangalore", 2, "TS-05-62395");
        rideService.offerRide("Rahul", "Hyderabad", "Bangalore", 5, "KA-05-1234");

        // This should fail
        rideService.offerRide("Rohan", "Bangalore", "Pune", 1, "KA-01-12345");

        // Select Rides
        rideService.selectRide("Nandini", "Bangalore", "Mysore", 1, new MostVacantStrategy());
        rideService.selectRide("Gaurav", "Bangalore", "Mysore", 1, new PreferredVehicleStrategy("Activa"));
        rideService.selectRide("Shashank", "Mumbai", "Bangalore", 1, new MostVacantStrategy());
        rideService.selectRide("Rohan", "Hyderabad", "Bangalore", 1, new PreferredVehicleStrategy("Baleno"));
        rideService.selectRide("Shashank", "Hyderabad", "Bangalore", 1, new PreferredVehicleStrategy("Polo"));

        // End Rides
        rideService.endRide("KA-01-12345");
        rideService.endRide("KA-12-12332");
        rideService.endRide("KA-05-41491");
        rideService.endRide("TS-05-62395");

        // Ride Stats
        rideService.printRideStats();
    }
}
