package ParkingLot.strategies;

class HourlyPricing implements PricingStrategy {
    private final double ratePerHour;
    public HourlyPricing(double ratePerHour) { this.ratePerHour = ratePerHour; }
    @Override
    public double computeFee(long entryMillis, long exitMillis) {
        long durMs = Math.max(0, exitMillis - entryMillis);
        double hours = Math.ceil(durMs / (1000.0 * 60 * 60));
        return Math.max(ratePerHour, hours * ratePerHour);
    }
}
