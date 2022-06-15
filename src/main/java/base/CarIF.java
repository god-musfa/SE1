package base;

public interface CarIF {
    int nr();
    long begin();
    long end();
    int duration();
    int price();
    String getType();
    Ticket getTicket();
}
