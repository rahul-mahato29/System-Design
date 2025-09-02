package ParkingLot.strategies;

public interface PricingStrategy {
    double computeFee(long entryMillis, long exitMillis);
}
