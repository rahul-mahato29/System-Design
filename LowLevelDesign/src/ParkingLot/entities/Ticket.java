package ParkingLot.entities;

import ParkingLot.entities.enums.VehicleType;

public class Ticket {
    private final String id; // UUID
    private final String vehicleNumber;
    private final VehicleType vehicleType;
    private final int spotId;
    private final int entryGateId;
    private final long entryTimeMillis;


    public Ticket(String id, String vehicleNumber, VehicleType vt, int spotId, int entryGateId, long entryTimeMillis) {
        this.id = id; this.vehicleNumber = vehicleNumber; this.vehicleType = vt;
        this.spotId = spotId; this.entryGateId = entryGateId; this.entryTimeMillis = entryTimeMillis;
    }

    public String getId() { return id; }
    public String getVehicleNumber() { return vehicleNumber; }
    public VehicleType getVehicleType() { return vehicleType; }
    public int getSpotId() { return spotId; }
    public int getEntryGateId() { return entryGateId; }
    public long getEntryTimeMillis() { return entryTimeMillis; }
}