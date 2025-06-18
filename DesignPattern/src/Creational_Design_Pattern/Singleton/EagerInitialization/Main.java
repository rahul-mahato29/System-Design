package Creational_Design_Pattern.Singleton.EagerInitialization;

public class Main {

    public static void main(String[] args) {
        DBConnection dbConnection = DBConnection.getInstance();
    }
}
