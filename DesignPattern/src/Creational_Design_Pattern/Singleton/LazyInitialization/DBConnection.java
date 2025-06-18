package Creational_Design_Pattern.Singleton.LazyInitialization;

public class DBConnection {

    private static DBConnection ConnObj;

    private DBConnection(){}

    public static DBConnection getInstance() {
        if(ConnObj == null) {
            ConnObj = new DBConnection();        //Resolved the Eager-disadvantage, we will be creating the object only
                                                 //only when we need it.
        }
        return ConnObj;
    }
}


//Disadvantage : What if, Initially when object is not created & 2 diff threads comes in parallel, and
//               checking condition "if(ConnObj == null)", for both thread the condition will be false,
//               so, two objected will get created.