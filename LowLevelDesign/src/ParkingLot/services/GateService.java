package ParkingLot.services;

import ParkingLot.entities.ParkingSpot;
import ParkingLot.entities.Receipt;
import ParkingLot.entities.Ticket;
import ParkingLot.entities.Vehicle;
import ParkingLot.entities.enums.PaymentMethod;
import ParkingLot.repositories.GateRepository;
import ParkingLot.repositories.ParkingSpotRepository;

public class GateService {
    private final GateRepository gateRepo;
    private final ParkingSpotManager spotManager;
    private final TicketService ticketService;
    private final PaymentService paymentService;
    private final ParkingSpotRepository spotRepo;


    public GateService(GateRepository gateRepo, ParkingSpotManager spotManager, TicketService ticketService, PaymentService paymentService, ParkingSpotRepository spotRepo) {
        this.gateRepo = gateRepo; this.spotManager = spotManager; this.ticketService = ticketService; this.paymentService = paymentService; this.spotRepo = spotRepo;
    }


    public Ticket vehicleEntry(Vehicle v, int entryGateId) {
        if (!gateRepo.find(entryGateId).isPresent()) throw new IllegalArgumentException("Invalid gate");
        ParkingSpot spot = spotManager.findAndReserve(v);
        return ticketService.generateTicket(v, spot.getId(), entryGateId);
    }


    public Receipt vehicleExit(String ticketId, int exitGateId, PaymentMethod method) {
        Ticket t = ticketService.get(ticketId).orElseThrow(() -> new IllegalArgumentException("Invalid ticket"));
        if (!gateRepo.find(exitGateId).isPresent()) throw new IllegalArgumentException("Invalid gate");
        long now = System.currentTimeMillis();
        Receipt r = paymentService.processExit(t, method, now);
        spotManager.release(t.getSpotId(), spotRepo);
        return r;
    }
}