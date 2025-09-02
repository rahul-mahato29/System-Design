package ParkingLot.entities;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private final int id;
    private final List<Floor> floors = new ArrayList<>();

    public ParkingLot(int id) { this.id = id; }

    public int getId() { return id; }
    public List<Floor> getFloors() { return floors; }

    public void addFloor(Floor f) { floors.add(f); }
}
