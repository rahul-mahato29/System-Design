package Creational_Design_Pattern.Singleton.BillPughSolution;

public class DBConnection {
    
    private DBConnection() {}
    
    //Nested Class
    private static class DBConnectionHelper {
        private static final DBConnection INSTANCE_OBJECT = new DBConnection();
    }
    
    public static DBConnection getInstance() {
        return DBConnectionHelper.INSTANCE_OBJECT;
    }
}`

/*
Nested class do not get loaded at the time of starting of application, so we can say it is solving the problem of 
Eager-Initialization. Nested class only load when they are refer, or they are used.



NOTE : 

enum DBConnection {
    Instance : 
}

Enum's are by default singleton only, because by default enum's all constructor are private & only 1 object 
is created per JVM.
*/
