package ParkingLot.entities;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    private final int id;
    private final List<ParkingSpot> spots = new ArrayList<>();

    public Floor(int id) { this.id = id; }

    public int getId() { return id; }
    public List<ParkingSpot> getSpots() { return spots; }

    public void addSpot(ParkingSpot s) { spots.add(s); }
}
