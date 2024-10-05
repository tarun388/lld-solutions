import vehicle.Vehicle;
import vehicle.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Level {
    private final int floor;
    private final List<ParkingSpot> parkingSpots;

    public Level(int floor, int numSpots) {
        this.floor = floor;
        parkingSpots = new ArrayList<>(numSpots);

        double spotForBikes = 0.50;
        double spotForCars = 0.30;

        int numBikes = (int) (spotForBikes * numSpots);
        int numCars = (int) (spotForCars * numSpots);

        for (int i = 1; i <= numBikes; i++) {
            parkingSpots.add(new ParkingSpot(i, VehicleType.MOTORCYCLE));
        }

        for (int i = numBikes + 1; i <= numCars ; i++) {
            parkingSpots.add(new ParkingSpot(i, VehicleType.CAR));
        }

        for (int i = numCars + 1; i <= numSpots ; i++) {
            parkingSpots.add(new ParkingSpot(i, VehicleType.TRUCK));
        }
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for (ParkingSpot parkingSpot: parkingSpots) {
            if (parkingSpot.isAvailable() && parkingSpot.parkVehicle(vehicle)) {
                return true;
            }
        }
        return false;
    }

    public boolean unparkVehicle(Vehicle vehicle) {
        for (ParkingSpot parkingSpot: parkingSpots) {
            if (!parkingSpot.isAvailable() && parkingSpot.getParkedVehicle().equals(vehicle)) {
                parkingSpot.unparkVehicle();
                return true;
            }
        }
        return false;
    }

    public void displayAvailability() {
        System.out.println("Level " + floor + " Availability");
        for (ParkingSpot parkingSpot: parkingSpots) {
            parkingSpot.displayAvailability();
        }
    }
}
