package Strategy_Design_Pattern.WithStrategyPattern;

import Strategy_Design_Pattern.WithStrategyPattern.Strategy.DriveStrategy;

public class Vehicle {

    DriveStrategy driveStrategyObject;

    //constructor injection
    public Vehicle(DriveStrategy driveStrategyObj) {
        this.driveStrategyObject = driveStrategyObj;
    }

    public void drive() {
        driveStrategyObject.drive();
    }
}
