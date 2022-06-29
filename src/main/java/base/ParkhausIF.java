package base;

import command.Enter;
import command.ICommand;

import java.util.ArrayList;
import java.util.List;

public interface ParkhausIF {

    int enter(CarIF c);

    boolean leave(int nr);

    CarIF[] getCars();

    List<TicketIF> getTicket();

    ArrayList<ICommand> getCommand();

    ArrayList<Enter> getEnterCommand();

    void undo();
}
