package Strategy_Design_Pattern.WithStrategyPattern.Strategy;

public class AnyCustomDriveStrategy implements DriveStrategy{

    //logic of custom drive strategy
    @Override
    public void drive() {
        System.out.println("Any Custom Drive Strategy in future");
    }
}
