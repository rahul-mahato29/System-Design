package ParkingLot.services;

import ParkingLot.entities.ParkingLot;
import ParkingLot.entities.ParkingSpot;
import ParkingLot.entities.Vehicle;
import ParkingLot.repositories.ParkingLotRepository;
import ParkingLot.repositories.ParkingSpotRepository;
import ParkingLot.strategies.SpotAssignmentStrategy;

public class ParkingSpotManager {
    private final ParkingLotRepository lotRepo;
    private SpotAssignmentStrategy strategy;


    public ParkingSpotManager(ParkingLotRepository lotRepo, SpotAssignmentStrategy strategy) {
        this.lotRepo = lotRepo; this.strategy = strategy;
    }


    public void setStrategy(SpotAssignmentStrategy s) { this.strategy = s; }


    public ParkingSpot findAndReserve(Vehicle v) {
        ParkingLot lot = lotRepo.get().orElseThrow(() -> new IllegalStateException("Lot not configured"));
        ParkingSpot spot = strategy.findSpot(lot.getFloors(), v.getType());
        if (spot == null) throw new IllegalStateException("No spot available for " + v.getType());
        spot.park(v);
        return spot;
    }


    public void release(int spotId, ParkingSpotRepository spotRepo) {
        spotRepo.find(spotId).orElseThrow(() -> new IllegalArgumentException("Invalid spot"))
                .unpark();
    }
}
