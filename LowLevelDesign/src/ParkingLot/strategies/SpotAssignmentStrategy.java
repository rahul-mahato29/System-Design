package ParkingLot.strategies;

import ParkingLot.entities.Floor;
import ParkingLot.entities.ParkingSpot;
import ParkingLot.entities.enums.VehicleType;

import java.util.List;

// Strategy: find a parking spot
public interface SpotAssignmentStrategy {
    ParkingSpot findSpot(List<Floor> floors, VehicleType type);
}