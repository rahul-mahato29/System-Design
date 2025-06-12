package Strategy_Design_Pattern.WithStrategyPattern;

import Strategy_Design_Pattern.WithStrategyPattern.Strategy.SportDriveStrategy;

public class OffRoadVehicle extends Vehicle{

    public OffRoadVehicle() {
        super(new SportDriveStrategy());  //I want SportDriveStrategy for OffRoadVehicle
    }
}
