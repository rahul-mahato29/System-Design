package ParkingLot.repositories;

import ParkingLot.entities.ParkingSpot;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ParkingSpotRepository {
    private final Map<Integer, ParkingSpot> map = new HashMap<>();

    public void save(ParkingSpot s) { map.put(s.getId(), s); }

    public Optional<ParkingSpot> find(int id) { return Optional.ofNullable(map.get(id)); }
    public Collection<ParkingSpot> findAll() { return map.values(); }
}
