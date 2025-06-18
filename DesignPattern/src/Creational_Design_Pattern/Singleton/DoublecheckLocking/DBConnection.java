package Creational_Design_Pattern.Singleton.DoublecheckLocking;

public class DBConnection {

    private static volatile DBConnection ConnObj;

    private DBConnection(){}

     public static DBConnection getInstance() {
        if(ConnObj == null) {
            synchronized (DBConnection.class) {
                if(ConnObj == null) {
                    ConnObj = new DBConnection();
                }
            }
        }
        return ConnObj;
    }
}

/*
In Case of Double Locking : only one thread will have to go through LOCK/UNLOCK process, because once the a thread
is get lock and object is created then next time when thread will come, then it will check IF(ConnObj == null) is true
or not, once object will be created for all thread it will be false, hence it will not go for LOCKING process.

In case, when 2 thread will come initially and check for object creation, in this case only thread will have to go
through LOCKING process, other will be not go for LOCKING. So, this will overcome the disadvantage  of SynchronizedMethod.

volatile-keyword :
With the use of volatile keyword, all read/write operation will take place from memory, not from L1-Cache.
*/