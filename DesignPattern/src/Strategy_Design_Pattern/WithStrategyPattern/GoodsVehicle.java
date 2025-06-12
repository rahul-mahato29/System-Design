package Strategy_Design_Pattern.WithStrategyPattern;

import Strategy_Design_Pattern.WithStrategyPattern.Strategy.DriveStrategy;
import Strategy_Design_Pattern.WithStrategyPattern.Strategy.NormalDriveStrategy;

public class GoodsVehicle extends Vehicle{
    public GoodsVehicle() {
        super(new NormalDriveStrategy()); // NormalDriveStrategy for GoodVehicle
    }
}
