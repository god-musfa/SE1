package mvc;

import base.Car;
import base.TicketIF;

import java.util.List;

public interface IModelInterface extends IObservableInterface{

    public int enter(Car c);
    public boolean leave(int i);
    public List<TicketIF> getTicket();

}
