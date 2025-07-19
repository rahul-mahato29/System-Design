package Observer_Design_Pattern.Observable;

import Observer_Design_Pattern.Observers.Observer;

public interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
