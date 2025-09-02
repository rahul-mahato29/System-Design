package ParkingLot.services;

import ParkingLot.entities.Ticket;
import ParkingLot.entities.Vehicle;
import ParkingLot.repositories.TicketRepository;

import java.util.Optional;
import java.util.UUID;

public class TicketService {
    private final TicketRepository ticketRepo;


    public TicketService(TicketRepository ticketRepo) { this.ticketRepo = ticketRepo; }


    public Ticket generateTicket(Vehicle v, int spotId, int entryGateId) {
        String id = UUID.randomUUID().toString();
        long now = System.currentTimeMillis();
        Ticket t = new Ticket(id, v.getNumber(), v.getType(), spotId, entryGateId, now);
        ticketRepo.save(t);
        return t;
    }


    public Optional<Ticket> get(String id) { return ticketRepo.find(id); }
}