package ParkingLot.entities;

import ParkingLot.entities.enums.VehicleType;

public class Bike extends Vehicle{
    public Bike(String number) {
        super(number, VehicleType.TWO_WHEELER);
    }
}
