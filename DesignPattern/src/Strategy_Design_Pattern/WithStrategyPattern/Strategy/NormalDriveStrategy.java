package Strategy_Design_Pattern.WithStrategyPattern.Strategy;

public class NormalDriveStrategy implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("normal drive capability");
    }
}
