package Strategy_Design_Pattern.WithStrategyPattern;

import Strategy_Design_Pattern.WithStrategyPattern.Strategy.DriveStrategy;
import Strategy_Design_Pattern.WithStrategyPattern.Strategy.SportDriveStrategy;

public class SportVehicle extends Vehicle{
    public SportVehicle() {
        super(new SportDriveStrategy());
    }
}
