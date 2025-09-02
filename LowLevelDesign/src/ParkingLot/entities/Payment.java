package ParkingLot.entities;

import ParkingLot.entities.enums.PaymentMethod;
import ParkingLot.entities.enums.PaymentStatus;

public class Payment {
    private final String id; // UUID
    private final String ticketId;
    private final PaymentMethod method;
    private PaymentStatus status;
    private final double amount;
    private final long paidAtMillis;


    public Payment(String id, String ticketId, PaymentMethod method, PaymentStatus status, double amount, long paidAtMillis) {
        this.id = id; this.ticketId = ticketId; this.method = method; this.status = status; this.amount = amount; this.paidAtMillis = paidAtMillis;
    }
    public String getId() { return id; }
    public String getTicketId() { return ticketId; }
    public PaymentMethod getMethod() { return method; }
    public PaymentStatus getStatus() { return status; }
    public void setStatus(PaymentStatus s) { this.status = s; }
    public double getAmount() { return amount; }
    public long getPaidAtMillis() { return paidAtMillis; }
}