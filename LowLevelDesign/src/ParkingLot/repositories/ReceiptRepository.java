package ParkingLot.repositories;

import ParkingLot.entities.Receipt;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ReceiptRepository {
    private final Map<String, Receipt> receipts = new HashMap<>();

    public void save(Receipt r) { receipts.put(r.getId(), r); }

    public Optional<Receipt> find(String id) { return Optional.ofNullable(receipts.get(id)); }
}
