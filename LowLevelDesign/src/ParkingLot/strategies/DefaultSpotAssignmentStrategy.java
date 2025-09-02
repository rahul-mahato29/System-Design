package ParkingLot.strategies;

import ParkingLot.entities.Floor;
import ParkingLot.entities.ParkingSpot;
import ParkingLot.entities.enums.SpotType;
import ParkingLot.entities.enums.VehicleType;

import java.util.List;

// Default: first suitable, scanning floors top -> bottom
public class DefaultSpotAssignmentStrategy implements SpotAssignmentStrategy {
    @Override
    public ParkingSpot findSpot(List<Floor> floors, VehicleType type) {
        for (Floor f : floors) {
            for (ParkingSpot s : f.getSpots()) {
                if (s.isEmpty() && ((type == VehicleType.TWO_WHEELER && s.getSpotType() == SpotType.TWO_WHEELER)
                        || (type == VehicleType.FOUR_WHEELER && s.getSpotType() == SpotType.FOUR_WHEELER))) {
                    return s;
                }
            }
        }
        return null; // none available
    }
}