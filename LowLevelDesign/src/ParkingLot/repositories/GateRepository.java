package ParkingLot.repositories;

import ParkingLot.entities.Gate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GateRepository {
    private final Map<Integer, Gate> gates = new HashMap<>();

    public void save(Gate g) { gates.put(g.getId(), g); }

    public Optional<Gate> find(int id) { return Optional.ofNullable(gates.get(id)); }
}
