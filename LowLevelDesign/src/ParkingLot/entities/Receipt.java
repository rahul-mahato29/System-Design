package ParkingLot.entities;

public class Receipt {
    private final String id; // UUID
    private final String ticketId;
    private final double amount;
    private final long exitTimeMillis;


    public Receipt(String id, String ticketId, double amount, long exitTimeMillis) {
        this.id = id; this.ticketId = ticketId; this.amount = amount; this.exitTimeMillis = exitTimeMillis;
    }
    public String getId() { return id; }
    public String getTicketId() { return ticketId; }
    public double getAmount() { return amount; }
    public long getExitTimeMillis() { return exitTimeMillis; }
}