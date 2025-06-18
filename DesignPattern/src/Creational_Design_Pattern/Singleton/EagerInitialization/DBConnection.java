package Creational_Design_Pattern.Singleton.EagerInitialization;

public class DBConnection {

    //1. created the object eagerly - in advance itself
    private static DBConnection ConnObj = new DBConnection();

    //2. private constructor
    private DBConnection(){}

    //3. public method to access the object
    public static DBConnection getInstance() {
        return ConnObj;
    }
}


//Disadvantage : even if we are not calling or using getInstance() method anywhere, object will be created
//               & get stored in the memory, (taking space in memory).