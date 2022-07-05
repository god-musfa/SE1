package base;

import command.Enter;
import command.ICommand;

import java.util.ArrayList;
import java.util.List;

public interface ParkhausIF {

    int enter(CarIF c);

    double leave(int nr,long duration);
    int getParkingSpotSize();
    CarIF[] getCars();

    List<TicketIF> getTicket();

    ArrayList<ICommand> getCommand();

    ArrayList<Enter> getEnterCommand();

    void undo();
    List<CarIF> getCarsList();
    void changeMax(int newSize);
    String carsListToString();
    void reset();
}
