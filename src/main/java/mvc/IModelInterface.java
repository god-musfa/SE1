package mvc;

import base.CarIF;
import base.TicketIF;

import java.util.List;

public interface IModelInterface extends IObservableInterface{

    public int enter(CarIF c);
    public boolean leave(int i);
    public List<TicketIF> getTicket();

}
