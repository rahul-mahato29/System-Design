package ParkingLot.repositories;

import ParkingLot.entities.Ticket;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TicketRepository {
    private final Map<String, Ticket> tickets = new HashMap<>();

    public void save(Ticket t) { tickets.put(t.getId(), t); }

    public Optional<Ticket> find(String id) { return Optional.ofNullable(tickets.get(id)); }
}
