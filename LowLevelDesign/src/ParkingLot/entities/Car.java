package ParkingLot.entities;

import ParkingLot.entities.enums.VehicleType;

public class Car extends Vehicle{
    public Car(String number) {
        super(number, VehicleType.FOUR_WHEELER);
    }
}
