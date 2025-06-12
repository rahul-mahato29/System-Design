package Strategy_Design_Pattern.WithStrategyPattern.Strategy;

public class SportDriveStrategy implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("Sport drive capability");
    }
}
