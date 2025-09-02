package ParkingLot.services;

import ParkingLot.entities.Floor;
import ParkingLot.entities.ParkingLot;
import ParkingLot.entities.ParkingSpot;
import ParkingLot.entities.enums.SpotType;
import ParkingLot.repositories.FloorRepository;
import ParkingLot.repositories.ParkingLotRepository;
import ParkingLot.repositories.ParkingSpotRepository;

public class ParkingLotService {
    private final ParkingLotRepository lotRepo;

    private final FloorRepository floorRepo;
    private final ParkingSpotRepository spotRepo;


    public ParkingLotService(ParkingLotRepository lotRepo, FloorRepository floorRepo, ParkingSpotRepository spotRepo) {
        this.lotRepo = lotRepo;
        this.floorRepo = floorRepo;
        this.spotRepo = spotRepo;
    }


    public ParkingLot createLot(int id) {
        ParkingLot lot = new ParkingLot(id);
        lotRepo.save(lot);
        return lot;
    }

    public Floor addFloor(int floorId) {
        Floor f = new Floor(floorId);
        floorRepo.save(f);
        lotRepo.get().orElseThrow(() -> new IllegalStateException("Create lot first")).addFloor(f);
        return f;
    }


    public ParkingSpot addSpot(int spotId, SpotType type, int floorId) {
        Floor f = floorRepo.find(floorId).orElseThrow(() -> new IllegalArgumentException("No such floor"));
        ParkingSpot s = new ParkingSpot(spotId, type);
        spotRepo.save(s);
        f.addSpot(s);
        return s;
    }
}