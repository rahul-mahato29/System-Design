package ParkingLot.entities;

import ParkingLot.entities.enums.SpotType;
import ParkingLot.entities.enums.VehicleType;

public class ParkingSpot {
    private final int id;
    private final SpotType spotType;
    private boolean empty = true;
    private Vehicle parkedVehicle;


    public ParkingSpot(int id, SpotType type) {
        this.id = id;
        this.spotType = type;
    }
    public int getId() { return id; }
    public SpotType getSpotType() { return spotType; }
    public boolean isEmpty() { return empty; }
    public Vehicle getParkedVehicle() { return parkedVehicle; }


    public void park(Vehicle v) {
        if (!empty) throw new IllegalStateException("Spot already occupied");
        if (!canFit(v)) throw new IllegalArgumentException("Vehicle not compatible with spot");
        this.parkedVehicle = v;
        this.empty = false;
    }
    public void unpark() {
        this.parkedVehicle = null;
        this.empty = true;
    }
    public boolean canFit(Vehicle v) {
        return (spotType == SpotType.TWO_WHEELER && v.getType() == VehicleType.TWO_WHEELER)
                || (spotType == SpotType.FOUR_WHEELER && v.getType() == VehicleType.FOUR_WHEELER);
    }
}
