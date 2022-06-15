package base;

import command.ICommand;

import java.util.ArrayList;
import java.util.List;

public interface ParkhausIF {

    int enter(Car c);

    boolean leave(int nr);

    Car[] getCars();

    List<TicketIF> getTicket();

    ArrayList<ICommand> getCommand();
}
