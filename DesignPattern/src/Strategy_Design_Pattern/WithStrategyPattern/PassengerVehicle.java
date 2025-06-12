package Strategy_Design_Pattern.WithStrategyPattern;

import Strategy_Design_Pattern.WithStrategyPattern.Strategy.DriveStrategy;
import Strategy_Design_Pattern.WithStrategyPattern.Strategy.NormalDriveStrategy;

public class PassengerVehicle extends Vehicle{
    public PassengerVehicle() {
        super(new NormalDriveStrategy());
    }
}
