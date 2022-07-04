package mvc;

import base.CarIF;
import base.TicketIF;

import java.util.List;

public interface IModelInterface extends IObservableInterface{

    public int enter(CarIF c);
    public double leave(int i,long duration);
    public List<TicketIF> getTicket();

}
