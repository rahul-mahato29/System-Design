package Strategy_Design_Pattern.WithoutStrategyPattern;

public class OffRoadVehicle extends Vehicle{

    //different drive logic - this custom logic can be same with diff custom logic (Issue with normal inheritance)
    @Override
    public void drive() {
        System.out.println("offRoad drive capabilities");
    }
}
