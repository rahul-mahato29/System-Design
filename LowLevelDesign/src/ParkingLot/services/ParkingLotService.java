package ParkingLot.services;

import ParkingLot.entities.ParkingLot;
import ParkingLot.repositories.FloorRepository;
import ParkingLot.repositories.ParkingLotRepository;
import ParkingLot.repositories.ParkingSpotRepository;

public class ParkingLotService {
    private final ParkingLotRepository lotRepo;
    private final FloorRepository floorRepo;
    private final ParkingSpotRepository spotRepo;


    public ParkingLotService(ParkingLotRepository lotRepo, FloorRepository floorRepo, ParkingSpotRepository spotRepo) {
        this.lotRepo = lotRepo; this.floorRepo = floorRepo; this.spotRepo = spotRepo;
    }


    public ParkingLot createLot(int id) {
        ParkingLot lot = new ParkingLot(id);
        lotRepo.save(lot);
        return lot;
    }
