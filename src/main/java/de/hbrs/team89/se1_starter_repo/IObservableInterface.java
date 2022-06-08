package de.hbrs.team89.se1_starter_repo;

public interface IObservableInterface {
    public void registerObserver (IObserverInterface o);
    public void removeObserver (IObserverInterface o);
    public void notifyObservers();
}
