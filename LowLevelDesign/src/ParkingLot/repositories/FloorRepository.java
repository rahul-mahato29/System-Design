package ParkingLot.repositories;

import ParkingLot.entities.Floor;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class FloorRepository {
    private final Map<Integer, Floor> map = new HashMap<>();

    public void save(Floor f) { map.put(f.getId(), f); }

    public Optional<Floor> find(int id) { return Optional.ofNullable(map.get(id)); }
    public Collection<Floor> findAll() { return map.values(); }
}