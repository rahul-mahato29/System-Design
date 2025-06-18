package Creational_Design_Pattern.Singleton.SynchronizedMethod;

public class DBConnection {

    private static DBConnection ConnObj;

    private DBConnection(){}

    synchronized public static DBConnection getInstance() {
        if(ConnObj == null) {
            ConnObj = new DBConnection();        //Resolved the Lazy-disadvantage, once 1 thread will go inside the
                                                 //block, as synchronized keyword will lock it for thread-1 then allow thread-2
        }
        return ConnObj;
    }
}


//Disadvantage : So, for example if our application is using getInstance() let say 100times, then every time for each
//               call it will LOCK/UNLOCK, so locking and unlocking for 100times, will make it slow.