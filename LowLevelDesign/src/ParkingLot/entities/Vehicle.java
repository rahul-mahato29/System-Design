package ParkingLot.entities;

import ParkingLot.entities.enums.VehicleType;

public class Vehicle {
    private final String number;
    private final VehicleType type;

    protected Vehicle(String number, VehicleType type) {
        this.number = number;
        this.type = type;
    }

    public String getNumber() { return number; }
    public VehicleType getType() { return type; }
}
