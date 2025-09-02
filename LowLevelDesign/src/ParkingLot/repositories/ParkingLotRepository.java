package ParkingLot.repositories;

import ParkingLot.entities.ParkingLot;

import java.util.Optional;

public class ParkingLotRepository {
    private ParkingLot lot; // assuming single lot for the round

    public Optional<ParkingLot> get() {
        return Optional.ofNullable(lot);
    }

    public void save(ParkingLot l) { this.lot = l; }
}
