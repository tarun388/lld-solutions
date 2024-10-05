import vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private static ParkingLot instance;
    private List<Level> levels;

    private ParkingLot() {
        levels = new ArrayList<>();
    }

    public static synchronized ParkingLot getInstance() {
        if (instance == null) {
            instance = new ParkingLot();
        }
        return instance;
    }

    public void addLevel(Level level) {
        levels.add(level);
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for (Level level: levels) {
            if (level.parkVehicle(vehicle)) {
                System.out.println("vehicle.Vehicle parked");
                return true;
            }
        }
        System.out.println("Could not park vehicle");
        return false;
    }

    public boolean unparkVehicle(Vehicle vehicle) {
        for (Level level: levels) {
            if (level.unparkVehicle(vehicle)) {
                System.out.println("vehicle.Vehicle unparked");
                return true;
            }
        }
        System.out.println("Could not unpark vehicle");
        return false;
    }

    public void displayAvailability() {
        for (Level level: levels) {
            level.displayAvailability();
        }
    }
}
