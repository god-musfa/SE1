package base;

import multiton.Fahrzeugtyp;
import multiton.Kundentyp;

public interface CarIF {
    int nr();
    String getVehicleType();
    String getKundentyp();
    Ticket getTicket();
}
