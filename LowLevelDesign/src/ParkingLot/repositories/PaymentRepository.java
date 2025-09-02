package ParkingLot.repositories;

import ParkingLot.entities.Payment;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class PaymentRepository {
    private final Map<String, Payment> payments = new HashMap<>();

    public void save(Payment p) { payments.put(p.getId(), p); }

    public Optional<Payment> find(String id) { return Optional.ofNullable(payments.get(id)); }
}