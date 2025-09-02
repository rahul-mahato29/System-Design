package ParkingLot.services;

import ParkingLot.entities.Payment;
import ParkingLot.entities.Receipt;
import ParkingLot.entities.Ticket;
import ParkingLot.entities.enums.PaymentMethod;
import ParkingLot.entities.enums.PaymentStatus;
import ParkingLot.entities.enums.VehicleType;
import ParkingLot.repositories.PaymentRepository;
import ParkingLot.repositories.ReceiptRepository;
import ParkingLot.strategies.FourWheelerPricingStrategy;
import ParkingLot.strategies.PricingStrategy;
import ParkingLot.strategies.TwoWheelerPricingStrategy;

import java.util.UUID;

public class PaymentService {
    private final PaymentRepository paymentRepo;
    private final ReceiptRepository receiptRepo;


    public PaymentService(PaymentRepository payRepo, ReceiptRepository recRepo) { this.paymentRepo = payRepo; this.receiptRepo = recRepo; }


    private PricingStrategy strategyFor(VehicleType type) {
        return (type == VehicleType.TWO_WHEELER) ? new TwoWheelerPricingStrategy() : new FourWheelerPricingStrategy();
    }


    public Receipt processExit(Ticket ticket, PaymentMethod method, long exitMillis) {
        double amount = strategyFor(ticket.getVehicleType()).computeFee(ticket.getEntryTimeMillis(), exitMillis);
        Payment payment = new Payment(UUID.randomUUID().toString(), ticket.getId(), method, PaymentStatus.PENDING, amount, exitMillis);
// mock payment gateway
        payment.setStatus(PaymentStatus.SUCCESS);
        paymentRepo.save(payment);


        Receipt r = new Receipt(UUID.randomUUID().toString(), ticket.getId(), amount, exitMillis);
        receiptRepo.save(r);
        return r;
    }
}
