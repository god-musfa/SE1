package de.hbrs.team89.se1_starter_repo;

import java.util.List;

public interface IModelInterface extends IObservableInterface{

    public int enter(Car c);
    public boolean leave(int i);
    public List<Ticket> getTicket();

}
