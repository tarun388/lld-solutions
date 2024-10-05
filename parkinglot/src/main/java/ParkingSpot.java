import vehicle.Vehicle;
import vehicle.VehicleType;

public class ParkingSpot {
    private final int index;
    private final VehicleType type;
    private Vehicle parkedVehicle;

    public ParkingSpot(int index, VehicleType type) {
        this.index = index;
        this.type = type;
    }

    public boolean isAvailable() {
        return parkedVehicle == null;
    }

    public synchronized boolean parkVehicle(Vehicle vehicle) {
        if (isAvailable() && vehicle.getType().equals(type)) {
            parkedVehicle = vehicle;
            return true;
        }
        return false;
    }

    public synchronized void unparkVehicle() {
        parkedVehicle = null;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public void displayAvailability() {
        System.out.println("Spot " + index + (isAvailable() ? " Available for " : " Occupied by ") + type);
    }
}
