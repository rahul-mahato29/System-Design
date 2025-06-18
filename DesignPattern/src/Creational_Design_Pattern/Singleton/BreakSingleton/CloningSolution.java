package Creational_Design_Pattern.Singleton.BreakSingleton;

class SuperClass implements Cloneable {
    int i = 10;

    @Override
    protected Object clone()
            throws CloneNotSupportedException
    {
        return super.clone();
    }
}

// Singleton class
class Singleton extends SuperClass {

    // public instance initialized when loading the class
    public static Singleton instance = new Singleton();

    private Singleton()
    {
        // private constructor
    }

    //Solution : To overcome this issue, override clone() method and throw an exception from clone method
    @Override
    protected Object clone()
            throws CloneNotSupportedException
    {
        throw new CloneNotSupportedException();
    }
}

public class CloningSolution {

    // Main driver method
    public static void main(String[] args)
            throws CloneNotSupportedException
    {
        Singleton instance1 = Singleton.instance;
        Singleton instance2 = (Singleton)instance1.clone();

        System.out.println("instance1 hashCode:- "
                + instance1.hashCode());
        System.out.println("instance2 hashCode:- "
                + instance2.hashCode());
    }
}
