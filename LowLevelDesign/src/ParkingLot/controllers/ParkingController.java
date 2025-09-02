package ParkingLot.controllers;

import ParkingLot.entities.*;
import ParkingLot.entities.enums.PaymentMethod;
import ParkingLot.entities.enums.SpotType;
import ParkingLot.repositories.GateRepository;
import ParkingLot.services.GateService;
import ParkingLot.services.ParkingLotService;

public class ParkingController {
    private final ParkingLotService lotService;
    private final GateService gateService;
    private final GateRepository gateRepo;


    public ParkingController(ParkingLotService lotService, GateService gateService, GateRepository gateRepo) {
        this.lotService = lotService; this.gateService = gateService; this.gateRepo = gateRepo;
    }


    // Pre-setup APIs (simulate admin)
    public void createLot(int lotId) { lotService.createLot(lotId); }
    public void addFloor(int floorId) { lotService.addFloor(floorId); }
    public void addSpot(int spotId, SpotType type, int floorId) { lotService.addSpot(spotId, type, floorId); }
    public void addEntryGate(int id) { gateRepo.save(new EntryGate(id)); }
    public void addExitGate(int id) { gateRepo.save(new ExitGate(id)); }


    // Runtime APIs
    public Ticket enter(Vehicle v, int entryGate) { return gateService.vehicleEntry(v, entryGate); }
    public Receipt exit(String ticketId, int exitGate, PaymentMethod method) { return gateService.vehicleExit(ticketId, exitGate, method); }
}
