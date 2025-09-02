package ParkingLot.entities;

public abstract class Gate {
    private final int id;

    protected Gate(int id) { this.id = id; }

    public int getId() { return id; }
}
